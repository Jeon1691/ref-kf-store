package com.kakaofriends.front.service.product;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.product.*;
import com.kakaofriends.front.repository.DisplayGoodsRepository;
import com.kakaofriends.front.service.product.vo.GoodsAddonType;
import com.kakaofriends.front.service.product.vo.GoodsOptionType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class DisplayGoodsServiceImpl implements DisplayGoodsService {

	private DisplayGoodsRepository displayGoodsRepository;

	private ExchangeRateComponent exchangeRateComponent;

	@Override
	public int findProductCountByCategoryWithCharacter(ProductDto.ProductRequest productRequest) {
		return displayGoodsRepository.findProductCountByCategoryWithCharacter(productRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByCategoryWithCharacter(ProductDto.ProductRequest productRequest, PaginationInfo pagination) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return displayGoodsRepository.findProductsByCategoryWithCharacter(productRequest, pagination);
	}

	@Override
	public int findProductCountByCategoryGroup(ProductDto.ProductRequest productRequest) {
		return displayGoodsRepository.findProductCountByCategoryGroup(productRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByCategoryGroup(ProductDto.ProductRequest productRequest, PaginationInfo pagination) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return displayGoodsRepository.findProductsByCategoryGroup(productRequest, pagination);
	}

	@Override
	public int findProductCountByName(ProductDto.SearchRequest searchRequest) {
		return displayGoodsRepository.findProductCountByName(searchRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByName(ProductDto.SearchRequest searchRequest, PaginationInfo pagination) {
		searchRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return displayGoodsRepository.findProductsByName(searchRequest, pagination);
	}

	@Override
	public List<ProductDto.SuggestedProduct> findSuggestedByDisplayGoodsId(ProductDto.ProductRequest productRequest) {
		return displayGoodsRepository.findSuggestedByDisplayGoodsId(productRequest);
	}

	@Override
	public DisplayGoodsExpansion findByDisplayGoodsId(ProductDto.ProductRequest productRequest) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return displayGoodsRepository.findByDisplayGoodsId(productRequest);
	}

	@Override
	public DisplayGoodsGroup findByDisplayGoodsIdGoodsAsDetail(Long displayGoodsId) {
		double exchangeRate = exchangeRateComponent.getExchangeRate();
		List<Goods> goodsList = displayGoodsRepository.findByDisplayGoodsIdGoods(displayGoodsId, exchangeRate);

		boolean hasOption = false;
		//재고정보 / 해외배송정보 각각 조회
		for (Goods goods : goodsList) {
			GoodsEtcData etcData = new GoodsEtcData();
			if (goods.getOptionType().equals(GoodsOptionType.SINGLE.getCode())) {
				etcData = displayGoodsRepository.findByGoodsIdEctData(goods);
				//단품인데 2개이상 있을때 선택이 가능하므로
				if (goodsList.size() > 1) {
					hasOption = true;
				}
				//단품일때 금액과 할인기간은 goods가 아닌 product에서 긁어 2018.09.03 layla
				goods.setSalePrice(etcData.getSalePrice());
				goods.setDiscountPrice(etcData.getDiscountPrice());
				goods.setExchangePrice(getExchangePrice(etcData.getSalePrice()));
				goods.setExchangeDiscountPrice(getExchangePrice(etcData.getDiscountPrice()));
				goods.setDiscountsDate(etcData.getDiscountsDate());
				goods.setDiscounteDate(etcData.getDiscounteDate());
				//단품일때 findProducts를 할 goodsOptionid 셋팅
				//* findByDisplayGoodsIdGoods 에서 조회했을때 join 때문에 하위 아이템수만큼 타이틀이 나오는 문제 있었음 2018.09.03 layla
				goods.setGoodsOptionId(displayGoodsRepository.findGoodsOptionId(goods.getId()));
				goods.setIsSoldOut(etcData.getIsSoldOut());
			} else {
				hasOption = true;
				etcData = displayGoodsRepository.findByGoodsIdEctDataSum(goods);
			}
			//goods.setStZeroCheck(etcData.getStZeroCheck());
			goods.setForeigndeliCheck(etcData.getForeigndeliCheck());
		}
		//상품조회 후 추가상품 구분타입으로 묶음
		Map<String, List<Goods>> goodsListGroupByAddonType = goodsList.stream().collect(Collectors.groupingBy(Goods::getAddonType));
		DisplayGoodsGroup displayGoodsGroup = makeDisplayGoodsGroupAsDetail(goodsListGroupByAddonType);
		displayGoodsGroup.setIsHasOption(hasOption);
		return displayGoodsGroup;
	}

	@Override
	public DisplayGoodsGroup findByDisplayGoodsIdGoodsAsBasket(Long displayGoodsId, String bsPrCode) {
		double exchangeRate = exchangeRateComponent.getExchangeRate();
		List<Goods> goodsList = displayGoodsRepository.findByDisplayGoodsIdGoods(displayGoodsId, exchangeRate);

		boolean hasOption = false;
		for (Goods goods : goodsList) {
			if (goods.getOptionType().equals(GoodsOptionType.SINGLE.getCode())) {
				if (goodsList.size() > 1) {
					hasOption = true;
				}
			} else {
				hasOption = true;
			}
		}

		//상품조회 후 추가상품 구분타입으로 묶음
		Map<String, List<Goods>> goodsListGroupByAddonType = goodsList.stream().collect(Collectors.groupingBy(Goods::getAddonType));
		DisplayGoodsGroup displayGoodsGroup = makeDisplayGoodsGroupAsBasket(goodsListGroupByAddonType, displayGoodsId, bsPrCode);
		displayGoodsGroup.setIsHasOption(hasOption);
		return displayGoodsGroup;
	}

	@Override
	public List<GoodsOptionTitle> findByDisplayGoodsIdOptionTitle(Long displayGoodsId) {
		return displayGoodsRepository.findByDisplayGoodsIdOptionTitle(displayGoodsId);
	}

	@Override
	public List<GoodsOption> findByDisplayGoodsIdOption(Long goodsId, Long parentGoodsOptionId) {
		List<GoodsOption> goodsOptionList = displayGoodsRepository.findByDisplayGoodsIdOption(goodsId, parentGoodsOptionId);
		goodsOptionList.forEach( a -> {
			GoodsOptionPrice goodsOptionPrice = displayGoodsRepository.findByDisplayGoodsIdOptionPrice(a.getId(), a.getGoodsId());
			// 하위 제품을 조회 해 와서 환율금액 set 및 상품가와 제품가 차액 계산
			if (goodsOptionPrice != null) {
				goodsOptionPrice.setExchangePrice(getExchangePrice(goodsOptionPrice.getSalePrice()));
				goodsOptionPrice.setExchangeDiscountPrice(getExchangePrice(goodsOptionPrice.getDiscountPrice()));
				goodsOptionPrice.setPrExchangePrice(getExchangePrice(goodsOptionPrice.getPrSalePrice()));
				goodsOptionPrice.setPrExchangeDiscountPrice(getExchangePrice(goodsOptionPrice.getPrDiscountPrice()));

				int priceDiffernce = 0;
				double exchangePriceDiffernce = 0;
				if (goodsOptionPrice.getIsDiscountPeriod()) {
					if (goodsOptionPrice.getIsPrDiscountPeriod()) {
						priceDiffernce = goodsOptionPrice.getDiscountPrice() - goodsOptionPrice.getPrDiscountPrice();
						exchangePriceDiffernce = goodsOptionPrice.getExchangeDiscountPrice() - goodsOptionPrice.getPrExchangeDiscountPrice();
					} else {
						priceDiffernce = goodsOptionPrice.getDiscountPrice() - goodsOptionPrice.getPrSalePrice();
						exchangePriceDiffernce = goodsOptionPrice.getExchangeDiscountPrice() - goodsOptionPrice.getPrExchangePrice();
					}
				} else {
					if (goodsOptionPrice.getIsPrDiscountPeriod()) {
						priceDiffernce = goodsOptionPrice.getSalePrice() - goodsOptionPrice.getPrDiscountPrice();
						exchangePriceDiffernce = goodsOptionPrice.getExchangePrice() - goodsOptionPrice.getPrExchangeDiscountPrice();
					} else {
						priceDiffernce = goodsOptionPrice.getSalePrice() - goodsOptionPrice.getPrSalePrice();
						exchangePriceDiffernce = goodsOptionPrice.getExchangePrice() - goodsOptionPrice.getPrExchangePrice();
					}
				}

				//차액 셋팅
				priceDiffernce = priceDiffernce * (-1);
				exchangePriceDiffernce = exchangePriceDiffernce * (-1);

				//차액 음수/양수 텍스트로 셋팅해서 내려보냄
				String txtPriceDiffernce = String.valueOf(priceDiffernce);
				String txtExchangePriceDiffernce = String.valueOf(exchangePriceDiffernce);

				//양수일때 앞에 + 붙어야함
				if (priceDiffernce > 0) {
					txtPriceDiffernce = "+" + txtPriceDiffernce;
				}
				if (exchangePriceDiffernce > 0) {
					txtExchangePriceDiffernce = "+" + txtExchangePriceDiffernce;
				}

				a.setSalePrice(txtPriceDiffernce);
				a.setExchangePrice(txtExchangePriceDiffernce);
				a.setIsSoldOut(goodsOptionPrice.getIsSoldOut());
			}
		});

		return goodsOptionList;
	}

	@Override
	public List<ProductExpansion> findProducts(Long goodsOptionId) {
		double exchangeRate = exchangeRateComponent.getExchangeRate();
		return displayGoodsRepository.findProducts(goodsOptionId, exchangeRate);
	}

	//경우에 따라 옵션타이틀 및 첫번째 옵션 조회 as 전시상품상세
	private DisplayGoodsGroup makeDisplayGoodsGroupAsDetail(Map<String, List<Goods>> goodsListGroupByAddonType) {
		DisplayGoodsGroup displayGoodsGroup = new DisplayGoodsGroup();
		//메인 상품 set
		displayGoodsGroup.setMainGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()));
		//추가 상품 set
		displayGoodsGroup.setSubGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()));

		if (displayGoodsGroup.getMainGoodsList() != null) {
			Long mainGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()).get(0).getId();
			//메인 옵션 타이틀 리스트 set
			List<GoodsOptionTitle> goodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(mainGoodsId);
			displayGoodsGroup.setMainGoodsOptionTitleList(goodsOptionTitleList);

			//전시상품 상세화면에서 리스트 크기가 1개일 때에는 선택옵션까지 내려줌
			if (displayGoodsGroup.getMainGoodsList().size() == 1) {
				//옵션이 1단만 있을때와 2단까지 있을때의 내려주는 데이터가 다르므로 옵션 단 체크 (조회 시 타이틀 갯수로 확인하면됨 mainGoodsOptionTitleList)
				displayGoodsGroup.setMainGoodsOptionList(findByDisplayGoodsIdOption(mainGoodsId, 0L));
			}
		}

		if (displayGoodsGroup.getSubGoodsList() != null) {
			Long subGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()).get(0).getId();
			//추가상품 옵션 타이틀 리스트 set
			List<GoodsOptionTitle> subGoodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(subGoodsId);
			displayGoodsGroup.setSubGoodsOptionTitleList(subGoodsOptionTitleList);

			//전시상품 상세화면에서 리스트 크기가 1개일 때에는 선택옵션까지 내려줌
			if (displayGoodsGroup.getSubGoodsList().size() == 1) {
				//옵션이 1단만 있을때와 2단까지 있을때의 내려주는 데이터가 다르므로 옵션 단 체크 (조회 시 타이틀 갯수로 확인하면됨 mainGoodsOptionTitleList)
				displayGoodsGroup.setSubGoodsOptionList(findByDisplayGoodsIdOption(subGoodsId, 0L));
			}
		}
		return displayGoodsGroup;
	}

	//경우에 따라 옵션타이틀 및 첫번째 옵션 조회 as 장바구니
	private DisplayGoodsGroup makeDisplayGoodsGroupAsBasket(Map<String, List<Goods>> goodsListGroupByAddonType, Long displayGoodsId, String bsPrCode) {
		DisplayGoodsGroup displayGoodsGroup = new DisplayGoodsGroup();
		//메인 상품 set
		displayGoodsGroup.setMainGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()));
		//추가 상품 set
		displayGoodsGroup.setSubGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()));

		if (displayGoodsGroup.getMainGoodsList() != null) {
			Long mainGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()).get(0).getId();
			//메인 옵션 타이틀 리스트 set
			List<GoodsOptionTitle> goodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(mainGoodsId);
			displayGoodsGroup.setMainGoodsOptionTitleList(goodsOptionTitleList);

			//장바구니에서 해당상품이 포함되는 마지막 옵션값만 내보내야 함
			Long basketGoodsId = displayGoodsRepository.findGoodsIdByPrcode(displayGoodsId, bsPrCode);
			displayGoodsGroup.setMainGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(basketGoodsId, 0L));
		}

		if (displayGoodsGroup.getSubGoodsList() != null) {
			Long subGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()).get(0).getId();
			//추가상품 옵션 타이틀 리스트 set
			List<GoodsOptionTitle> subGoodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(subGoodsId);
			displayGoodsGroup.setSubGoodsOptionTitleList(subGoodsOptionTitleList);

			//장바구니에서 해당상품이 포함되는 마지막 옵션값만 내보내야 함
			Long basketGoodsId = displayGoodsRepository.findGoodsIdByPrcode(displayGoodsId, bsPrCode);
			displayGoodsGroup.setSubGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(basketGoodsId, 0L));
		}
		return displayGoodsGroup;
	}

	public double getExchangePrice(int price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
	}
}