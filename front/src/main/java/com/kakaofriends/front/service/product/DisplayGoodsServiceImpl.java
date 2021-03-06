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
		//???????????? / ?????????????????? ?????? ??????
		for (Goods goods : goodsList) {
			GoodsEtcData etcData = new GoodsEtcData();
			if (goods.getOptionType().equals(GoodsOptionType.SINGLE.getCode())) {
				etcData = displayGoodsRepository.findByGoodsIdEctData(goods);
				//???????????? 2????????? ????????? ????????? ???????????????
				if (goodsList.size() > 1) {
					hasOption = true;
				}
				//???????????? ????????? ??????????????? goods??? ?????? product?????? ?????? 2018.09.03 layla
				goods.setSalePrice(etcData.getSalePrice());
				goods.setDiscountPrice(etcData.getDiscountPrice());
				goods.setExchangePrice(getExchangePrice(etcData.getSalePrice()));
				goods.setExchangeDiscountPrice(getExchangePrice(etcData.getDiscountPrice()));
				goods.setDiscountsDate(etcData.getDiscountsDate());
				goods.setDiscounteDate(etcData.getDiscounteDate());
				//???????????? findProducts??? ??? goodsOptionid ??????
				//* findByDisplayGoodsIdGoods ?????? ??????????????? join ????????? ?????? ?????????????????? ???????????? ????????? ?????? ????????? 2018.09.03 layla
				goods.setGoodsOptionId(displayGoodsRepository.findGoodsOptionId(goods.getId()));
				goods.setIsSoldOut(etcData.getIsSoldOut());
			} else {
				hasOption = true;
				etcData = displayGoodsRepository.findByGoodsIdEctDataSum(goods);
			}
			//goods.setStZeroCheck(etcData.getStZeroCheck());
			goods.setForeigndeliCheck(etcData.getForeigndeliCheck());
		}
		//???????????? ??? ???????????? ?????????????????? ??????
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

		//???????????? ??? ???????????? ?????????????????? ??????
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
			// ?????? ????????? ?????? ??? ?????? ???????????? set ??? ???????????? ????????? ?????? ??????
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

				//?????? ??????
				priceDiffernce = priceDiffernce * (-1);
				exchangePriceDiffernce = exchangePriceDiffernce * (-1);

				//?????? ??????/?????? ???????????? ???????????? ????????????
				String txtPriceDiffernce = String.valueOf(priceDiffernce);
				String txtExchangePriceDiffernce = String.valueOf(exchangePriceDiffernce);

				//???????????? ?????? + ????????????
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

	//????????? ?????? ??????????????? ??? ????????? ?????? ?????? as ??????????????????
	private DisplayGoodsGroup makeDisplayGoodsGroupAsDetail(Map<String, List<Goods>> goodsListGroupByAddonType) {
		DisplayGoodsGroup displayGoodsGroup = new DisplayGoodsGroup();
		//?????? ?????? set
		displayGoodsGroup.setMainGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()));
		//?????? ?????? set
		displayGoodsGroup.setSubGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()));

		if (displayGoodsGroup.getMainGoodsList() != null) {
			Long mainGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()).get(0).getId();
			//?????? ?????? ????????? ????????? set
			List<GoodsOptionTitle> goodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(mainGoodsId);
			displayGoodsGroup.setMainGoodsOptionTitleList(goodsOptionTitleList);

			//???????????? ?????????????????? ????????? ????????? 1?????? ????????? ?????????????????? ?????????
			if (displayGoodsGroup.getMainGoodsList().size() == 1) {
				//????????? 1?????? ???????????? 2????????? ???????????? ???????????? ???????????? ???????????? ?????? ??? ?????? (?????? ??? ????????? ????????? ??????????????? mainGoodsOptionTitleList)
				displayGoodsGroup.setMainGoodsOptionList(findByDisplayGoodsIdOption(mainGoodsId, 0L));
			}
		}

		if (displayGoodsGroup.getSubGoodsList() != null) {
			Long subGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()).get(0).getId();
			//???????????? ?????? ????????? ????????? set
			List<GoodsOptionTitle> subGoodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(subGoodsId);
			displayGoodsGroup.setSubGoodsOptionTitleList(subGoodsOptionTitleList);

			//???????????? ?????????????????? ????????? ????????? 1?????? ????????? ?????????????????? ?????????
			if (displayGoodsGroup.getSubGoodsList().size() == 1) {
				//????????? 1?????? ???????????? 2????????? ???????????? ???????????? ???????????? ???????????? ?????? ??? ?????? (?????? ??? ????????? ????????? ??????????????? mainGoodsOptionTitleList)
				displayGoodsGroup.setSubGoodsOptionList(findByDisplayGoodsIdOption(subGoodsId, 0L));
			}
		}
		return displayGoodsGroup;
	}

	//????????? ?????? ??????????????? ??? ????????? ?????? ?????? as ????????????
	private DisplayGoodsGroup makeDisplayGoodsGroupAsBasket(Map<String, List<Goods>> goodsListGroupByAddonType, Long displayGoodsId, String bsPrCode) {
		DisplayGoodsGroup displayGoodsGroup = new DisplayGoodsGroup();
		//?????? ?????? set
		displayGoodsGroup.setMainGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()));
		//?????? ?????? set
		displayGoodsGroup.setSubGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()));

		if (displayGoodsGroup.getMainGoodsList() != null) {
			Long mainGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()).get(0).getId();
			//?????? ?????? ????????? ????????? set
			List<GoodsOptionTitle> goodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(mainGoodsId);
			displayGoodsGroup.setMainGoodsOptionTitleList(goodsOptionTitleList);

			//?????????????????? ??????????????? ???????????? ????????? ???????????? ???????????? ???
			Long basketGoodsId = displayGoodsRepository.findGoodsIdByPrcode(displayGoodsId, bsPrCode);
			displayGoodsGroup.setMainGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(basketGoodsId, 0L));
		}

		if (displayGoodsGroup.getSubGoodsList() != null) {
			Long subGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()).get(0).getId();
			//???????????? ?????? ????????? ????????? set
			List<GoodsOptionTitle> subGoodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(subGoodsId);
			displayGoodsGroup.setSubGoodsOptionTitleList(subGoodsOptionTitleList);

			//?????????????????? ??????????????? ???????????? ????????? ???????????? ???????????? ???
			Long basketGoodsId = displayGoodsRepository.findGoodsIdByPrcode(displayGoodsId, bsPrCode);
			displayGoodsGroup.setSubGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(basketGoodsId, 0L));
		}
		return displayGoodsGroup;
	}

	public double getExchangePrice(int price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
	}
}