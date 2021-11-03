package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.basket.BasketData;
import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.product.DisplayGoodsExpansion;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.repository.BasketRepository;
import com.kakaofriends.front.service.basket.vo.Basket;
import com.kakaofriends.front.service.basket.vo.BasketProduct;
import com.kakaofriends.front.service.product.DisplayGoodsService;
import com.kakaofriends.front.service.product.ProductService;
import com.kakaofriends.front.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.BASKET_DIRECT_YES;


@Slf4j
@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketRepository basketRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	@Autowired
	private DisplayGoodsService displayGoodsService;

	@Override
	public int basketInsertProduct(BasketDto.Request request, String ownerId, String bsDirect, Boolean plus) {
		if(StringUtils.isEmpty(request.getDisplayGoodsId()) || StringUtils.isEmpty(request.getPrCode())){
			return 0;
		}

		boolean isDomestic = Country.isDomestic(Country.getCountryCodeByName(request.getOaCountryName()));
		BasketExpansion basketExpansion = basketRepository.findByBsOwnerIdPrCode(ownerId, request.getPrCode(), request.getDisplayGoodsId(), bsDirect, exchangeRateComponent.getExchangeRate(), isDomestic);

		//product 기준 ctseq조회 변경 -> displayGoods 2018.09.05 layla
/*		ProductExpansion productExpansion = productService.findProductByProductCode(request.getPrCode());
		if(request.getCtSeq() == null){
			request.setCtSeq(productExpansion.getCategory().getCtSeq());
		}*/
		ProductDto.ProductRequest basketDisplayGoodsId = new ProductDto.ProductRequest();
		basketDisplayGoodsId.setPrCode(request.getDisplayGoodsId().toString());
		DisplayGoodsExpansion displayGoodsExpansion = displayGoodsService.findByDisplayGoodsId(basketDisplayGoodsId);
		if(request.getCtSeq() == null){
			request.setCtSeq(displayGoodsExpansion.getCategory().getCtSeq());
		}

		int ret = 0;
		if (null != basketExpansion) {
			//추천상품 셋팅 2018.08.29 layla
			if (basketExpansion.getBasket().getDisplayGoodsId() != null) {
				basketExpansion.setSuggestedProducts(basketRepository.findSuggestedProductByPrCode(basketExpansion.getBasket().getDisplayGoodsId(), basketExpansion.getStDomestic()));
			}

			basketExpansion.getSuggestedProducts().forEach( a -> {
				ProductLevelPrice productLevelPrice = a.getProductLevelPrice();
				productLevelPrice.setExchangePrice(getExchangePrice(productLevelPrice.getPrlpSaleprice1()));
				productLevelPrice.setExchangeDiscountPrice(getExchangePrice(productLevelPrice.getPrlpDiscountprice1()));
			});

			//장바구니에 넣는 갯수를 최대 999로 제어
			long maxBsEa = maxBsEa(basketExpansion.getBasket().getBsEa(), request.getPrEa());

			basketExpansion.getBasket().setBsEa(plus ? maxBsEa : request.getPrEa());
			basketExpansion.getBasket().setBsDirect(bsDirect);
			if(basketExpansion.getIsCustomProduct()){
				basketExpansion.getBasket().setBsEtc5(request.getBsEtc5());
			}
            ret = basketRepository.basketUpdateBsEaBySeq(basketExpansion.getBasket());
		} else {
			com.kakaofriends.core.domain.Basket basket = new com.kakaofriends.core.domain.Basket();
			basket.setBsPrCode(request.getPrCode());
			basket.setBsEa(request.getPrEa());
			basket.setBsCtSeq(request.getCtSeq());
			basket.setBsOwnerId(ownerId);
			basket.setBsMoid(ownerId);
			basket.setBsInid(ownerId);
			basket.setBsType("1");
			basket.setBsUse("Y");
			basket.setBsModate(new Date());
			basket.setBsIndate(new Date());
			basket.setBsDirect(bsDirect);
			basket.setBsEtc5(request.getBsEtc5());
			basket.setDisplayGoodsId(request.getDisplayGoodsId());
            ret = basketRepository.basketInsert(basket);
		}
		return ret;
	}

	@Override
	public int basketInsertProductList(BasketDto.Request request, String friendsMemberId, String basketDirectNo, boolean b) {
		for(BasketDto.Request detail : request.getProductList()){
			//getPrcode, getPrEa, getOaCountry
			detail.setDisplayGoodsId(request.getDisplayGoodsId());
			detail.setCtSeq(request.getCtSeq());
			basketInsertProduct(detail, friendsMemberId, basketDirectNo, b);
		}
		return 0;
	}
	
	@Override
	public Long basketInsertProduct(BasketDto.Request request, String ownerId) {
		if(request.getBsSeq() == null) {
			com.kakaofriends.core.domain.Basket basket = new com.kakaofriends.core.domain.Basket();
			basket.setBsPrCode(request.getPrCode());
			basket.setBsEa(request.getPrEa());
			basket.setBsCtSeq(request.getCtSeq());
			basket.setBsOwnerId(ownerId);
			basket.setBsMoid(ownerId);
			basket.setBsInid(ownerId);
			basket.setBsType("1");
			basket.setBsUse("Y");
			basket.setBsModate(new Date());
			basket.setBsIndate(new Date());
			basket.setBsDirect("Y");
			basket.setBsEtc5(request.getBsEtc5());
			basket.setDisplayGoodsId(request.getDisplayGoodsId());
			basketRepository.basketInsert(basket);
			return basket.getBsSeq();
		} else {
			boolean isDomestic = Country.isDomestic(request.getOaCountryCode());
			BasketExpansion basketExpansion = basketRepository.findByBsOwnerIdBsSeq(ownerId, request.getBsSeq(), BASKET_DIRECT_YES, exchangeRateComponent.getExchangeRate(), isDomestic);
			//추천상품 셋팅 2018.08.29 layla
			if (basketExpansion.getBasket().getDisplayGoodsId() != null) {
				basketExpansion.setSuggestedProducts(basketRepository.findSuggestedProductByPrCode(basketExpansion.getBasket().getDisplayGoodsId(), basketExpansion.getStDomestic()));
			}

			//product 기준 ctseq조회 변경 -> displayGoods 2018.09.05 layla
/*			ProductExpansion productExpansion = productService.findProductByProductCode(request.getPrCode());
			if(request.getCtSeq() == null){
				request.setCtSeq(productExpansion.getCategory().getCtSeq());
			}*/
			ProductDto.ProductRequest basketDisplayGoodsId = new ProductDto.ProductRequest();
			basketDisplayGoodsId.setPrCode(request.getDisplayGoodsId().toString());
			DisplayGoodsExpansion displayGoodsExpansion = displayGoodsService.findByDisplayGoodsId(basketDisplayGoodsId);
			if(request.getCtSeq() == null){
				request.setCtSeq(displayGoodsExpansion.getCategory().getCtSeq());
			}

			basketExpansion.getSuggestedProducts().forEach( a -> {
				ProductLevelPrice productLevelPrice = a.getProductLevelPrice();
				productLevelPrice.setExchangePrice(getExchangePrice(productLevelPrice.getPrlpSaleprice1()));
				productLevelPrice.setExchangeDiscountPrice(getExchangePrice(productLevelPrice.getPrlpDiscountprice1()));
			});

			basketExpansion.getBasket().setBsEa(request.getPrEa());
			basketExpansion.getBasket().setBsDirect(BASKET_DIRECT_YES);
			if(basketExpansion.getIsCustomProduct()){
				basketExpansion.getBasket().setBsEtc5(request.getBsEtc5());
			}
			basketRepository.basketUpdateBsEa(basketExpansion.getBasket());
			return request.getBsSeq();
		}
	}

	@Override
	public List<Long> basketInsertProductList(BasketDto.Request request, String friendsMemberId) {
		List<Long> seqList = new ArrayList<>();
		for(BasketDto.Request detail : request.getProductList()){
			detail.setDisplayGoodsId(request.getDisplayGoodsId());
			detail.setCtSeq(request.getCtSeq());
			seqList.add(basketInsertProduct(detail, friendsMemberId));
		}
		return seqList;
	}

	@Override
	public List<BasketExpansion> findByBsOwnerId(String ownerId, String countryCode) {
		boolean isDomestic = Country.isDomestic(countryCode);
		List<BasketExpansion> basketExpansionList = basketRepository.findByBsOwnerId(ownerId, exchangeRateComponent.getExchangeRate(), isDomestic);
		basketExpansionList.forEach(b -> {
			b.setDisplayGoodsGroup(displayGoodsService.findByDisplayGoodsIdGoodsAsBasket(b.getBasket().getDisplayGoodsId(), b.getBasket().getBsPrCode()));
			//추천상품 셋팅 2018.08.29 layla
			if (b.getBasket().getDisplayGoodsId() != null) {
				b.setSuggestedProducts(basketRepository.findSuggestedProductByPrCode(b.getBasket().getDisplayGoodsId(), b.getStDomestic()));
			}
		});
		setExchangePriceByList(basketExpansionList);



		return basketExpansionList;
	}

	@Override
	public List<BasketExpansion> findByBsSeqIds(List<String> bsSeqIds, String countryCode) {
		boolean isDomestic = Country.isDomestic(countryCode);
		List<BasketExpansion> basketExpansionList = basketRepository.findByBsSeqIds(bsSeqIds, exchangeRateComponent.getExchangeRate(), isDomestic);
		basketExpansionList.forEach(b -> {
			//추천상품 셋팅 2018.08.29 layla
			if (b.getBasket().getDisplayGoodsId() != null) {
				b.setSuggestedProducts(basketRepository.findSuggestedProductByPrCode(b.getBasket().getDisplayGoodsId(), b.getStDomestic()));
			}
		});
		setExchangePriceByList(basketExpansionList);

		return basketExpansionList;
	}

	@Override
	public int basketDeleteProduct(com.kakaofriends.core.domain.Basket basket) {
		return basketRepository.basketDeleteProduct(basket);
	}

	@Override
	public int basketDeleteProducts(List<com.kakaofriends.core.domain.Basket> baskets) {
		return baskets.stream().mapToInt(e -> basketRepository.basketDeleteProduct(e)).sum();
	}

	@Override
	public int findByBsOwnerIdAllCount(String ownerId, String bsDirect) {
		return basketRepository.findByBsOwnerIdAllCount(ownerId, bsDirect);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Basket> getList(List<Long> sequenceList) {
		List<Basket> basketList = new ArrayList<>();
		List<BasketData> basketDataList = basketRepository.selectList(sequenceList);
		for (BasketData data : basketDataList) {
			basketList.add(this.converts(data));
		}
		return basketList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<BasketProduct> getBasketProductList(List<Long> basketSequenceList) {
		List<Basket> basketList = this.getList(basketSequenceList);
		List<BasketProduct> basketProductList = new ArrayList<>();
		for (Basket basket : basketList) {
			BasketProduct basketProduct = new BasketProduct();
			basketProduct.setBasket(basket);
			basketProduct.setProduct(productService.getWithPrice(basket.getProductCode()));
			basketProductList.add(basketProduct);
		}
		return basketProductList;
	}

	@Override
	public void removeList(List<Long> sequenceList) {
		try {
			for (Long sequence : sequenceList) {
				this.remove(sequence);
			}
		} catch (Exception e) {
			log.error("#### Exception caught : During remove basket : message = {}", e.getMessage());
			log.error("#### Exception caught : {}", e);
		}
	}

	private void remove(long sequence) {
		log.info("#### remove basket : sequence = {}", sequence);
		basketRepository.delete(sequence);
	}

	@Override
	@Transactional
	public void remove(String memberId) {
		log.info("#### remove basket : memberId = {}", memberId);
		basketRepository.deleteByMemberId(memberId);
	}

	public double getExchangePrice(int price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
	}

	public void setExchangePriceByList(List<BasketExpansion> basketExpansionList){
		if(basketExpansionList.size() > 0){
			basketExpansionList.forEach(e -> e.getSuggestedProducts().forEach( a -> {
				ProductLevelPrice productLevelPrice = a.getProductLevelPrice();
				productLevelPrice.setExchangePrice(getExchangePrice(productLevelPrice.getPrlpSaleprice1()));
				productLevelPrice.setExchangeDiscountPrice(getExchangePrice(productLevelPrice.getPrlpDiscountprice1()));
			}));
		}
	}


	/**
	 * 작성자 : layla
	 * 날짜 : 2018. 1. 15.
	 *
	 * 장바구니 상품 수량 업데이트 시
	 * 기프트백 수량 체크
	 * 내가 구매하고자 하는 상품(기프트백 외 수량합계) >= 기프트백(종류상관없이 수량합계)
	 *
	 * @return 기프트백 수량 확인 결과
	 */
	public boolean checkProductEa(List<com.kakaofriends.core.domain.Basket> bsList){
		long giftBag = 0;
		long notGiftBag = 0;

		for (com.kakaofriends.core.domain.Basket bs : bsList) {
			if(bs.isGiftBag()) {
				giftBag = giftBag + bs.getBsEa();
			} else {
				notGiftBag = notGiftBag + bs.getBsEa();
			}
		}

		return (giftBag <= notGiftBag);
	}

	@Override
	public int findByDisplayProductIdAllCount(String ownerId, Long displayGoodsId) {
		return basketRepository.findByDisplayProductIdAllCount(ownerId, displayGoodsId);
	}


	private Basket converts(BasketData data) {
		Basket basket = new Basket();
		basket.setSequence(data.getBsSeq());
		basket.setMemberId(data.getBsOwnerId());
		basket.setProductCode(data.getBsPrCode());
		basket.setProductOption(data.getBsPrOption());
		basket.setEa(data.getBsEa());
		basket.setCategorySequence(data.getBsCtSeq());
		basket.setType(data.getBsType());
		basket.setUse(Usable.get(data.getBsUse()));
		basket.setModifiedId(data.getBsMoId());
		basket.setInsertedId(data.getBsInId());
		basket.setModifiedDate(data.getBsMoDate());
		basket.setInsertedDate(data.getBsInDate());
		basket.setDirect(data.getBsDirect());
		return basket;
	}

	/**
	 * 작성자 : layla
	 * 날짜 : 2018. 3. 27.
	 *
	 * 장바구니에 넣는 갯수를 최대 999로 제어
	 *
	 * @return 장바구니에 넣을 수량
	 */
	private long maxBsEa(long bsEa, long requestPrEa) {
		long maxBsEa = bsEa + requestPrEa;
		if (maxBsEa > 999) {
			maxBsEa = 999;
		}
		return maxBsEa;
	}
}
