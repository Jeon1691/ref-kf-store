package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.product.*;
import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;
import com.kakaofriends.front.repository.DisplayGoodsRepository;
import com.kakaofriends.front.repository.theme.ThemeRepository;
import com.kakaofriends.front.service.product.vo.GoodsAddonType;
import com.kakaofriends.front.service.product.vo.GoodsOptionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * DisplayGoodsService
 * <p>
 * Author  layla
 * Date    2018. 8. 22.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class DisplayGoodsServiceTest {

    @Autowired
    private DisplayGoodsRepository displayGoodsRepository;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Test
    public void select() {
        //13108L ,
        List<Goods> goodsList = displayGoodsRepository.findByDisplayGoodsIdGoods(4281L, 1073.469970703125);
        boolean hasOption = false;
        //재고정보 / 해외배송정보 각각 조회
        for (Goods goods : goodsList) {
            GoodsEtcData etcData = new GoodsEtcData();
            if (goods.getOptionType().equals(GoodsOptionType.SINGLE.getCode())) {
                etcData = displayGoodsRepository.findByGoodsIdEctData(goods);

                //단품일때 금액과 할인기간은 goods가 아닌 product에서 긁어 2018.09.03 layla
                goods.setExchangePrice(getExchangePrice(etcData.getSalePrice()));
                goods.setExchangeDiscountPrice(getExchangePrice(etcData.getDiscountPrice()));
                goods.setDiscountsDate(goods.getDiscountsDate());
                goods.setDiscounteDate(goods.getDiscounteDate());
            } else {
                hasOption = true;
                etcData = displayGoodsRepository.findByGoodsIdEctDataSum(goods);
            }
            goods.setForeigndeliCheck(etcData.getForeigndeliCheck());
            goods.setIsSoldOut(etcData.getIsSoldOut());
            System.out.println(goods.toString());
        }
        //상품조회 후 추가상품 구분타입으로 묶음
        Map<String, List<Goods>> goodsListGroupByAddonType = goodsList.stream().collect(Collectors.groupingBy(Goods::getAddonType));
        DisplayGoodsGroup displayGoodsGroup = new DisplayGoodsGroup();
        //메인 상품 set
        displayGoodsGroup.setMainGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()));
        //추가 상품 set
        displayGoodsGroup.setSubGoodsList(goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()));

        if (goodsListGroupByAddonType != null) {

            Long mainGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.MAIN.getCode()).get(0).getId();
            //메인 옵션 타이틀 리스트 set
            List<GoodsOptionTitle> goodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(mainGoodsId);
            displayGoodsGroup.setMainGoodsOptionTitleList(goodsOptionTitleList);

            //리스트 크기가 1개일 때에는 선택옵션까지 내려줌
            if (displayGoodsGroup.getMainGoodsList().size() == 1) {
                //옵션이 1단만 있을때와 2단까지 있을때의 내려주는 데이터가 다르므로 옵션 단 체크 (조회 시 타이틀 갯수로 확인하면됨 mainGoodsOptionTitleList)
                if (goodsOptionTitleList.size() > 1) {
                    displayGoodsGroup.setMainGoodsOptionList(priceTest(mainGoodsId, 0L));
                } else {
                    displayGoodsGroup.setMainGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(mainGoodsId, 0L));
                }
            }

            if (displayGoodsGroup.getSubGoodsList() != null) {
                Long subGoodsId = goodsListGroupByAddonType.get(GoodsAddonType.SUB.getCode()).get(0).getId();
                //추가상품 옵션 타이틀 리스트 set
                List<GoodsOptionTitle> subGoodsOptionTitleList = displayGoodsRepository.findByDisplayGoodsIdOptionTitle(subGoodsId);
                displayGoodsGroup.setSubGoodsOptionTitleList(subGoodsOptionTitleList);

                //리스트 크기가 1개일 때에는 선택옵션까지 내려줌
                if (displayGoodsGroup.getSubGoodsList().size() == 1) {
                    //옵션이 1단만 있을때와 2단까지 있을때의 내려주는 데이터가 다르므로 옵션 단 체크 (조회 시 타이틀 갯수로 확인하면됨 mainGoodsOptionTitleList)
                    if (subGoodsOptionTitleList.size() > 1) {
                        displayGoodsGroup.setSubGoodsOptionList(priceTest(subGoodsId, 0L));
                    } else {
                        displayGoodsGroup.setSubGoodsOptionList(displayGoodsRepository.findByDisplayGoodsIdOption(subGoodsId, 0L));
                    }
                }
            }

            displayGoodsGroup.setIsHasOption(hasOption);
        }
        System.out.println(displayGoodsGroup.toString());
    }

    private List<GoodsOption> priceTest(Long goodsId, long parentGoodsOptionId) {
        List<GoodsOption> goodsOptionList = displayGoodsRepository.findByDisplayGoodsIdOption(goodsId, parentGoodsOptionId);
		goodsOptionList.forEach( a -> {
			GoodsOptionPrice goodsOptionPrice = displayGoodsRepository.findByDisplayGoodsIdOptionPrice(a.getId(), a.getGoodsId());
			// 하위 제품을 조회 해 와서 환율금액 set
			if (goodsOptionPrice != null) {
				goodsOptionPrice.setExchangePrice(getExchangePrice(goodsOptionPrice.getSalePrice()));
				goodsOptionPrice.setExchangeDiscountPrice(getExchangePrice(goodsOptionPrice.getDiscountPrice()));
				goodsOptionPrice.setPrExchangePrice(getExchangePrice(goodsOptionPrice.getPrSalePrice()));
				goodsOptionPrice.setPrExchangeDiscountPrice(getExchangePrice(goodsOptionPrice.getPrDiscountPrice()));

                int priceDiffernce = 0;
                double exchangePriceDiffernce = 0;
                if (goodsOptionPrice.getIsDiscountPeriod()) {
                    if (goodsOptionPrice.getIsDiscountPeriod()) {
                        priceDiffernce = goodsOptionPrice.getDiscountPrice() - goodsOptionPrice.getPrDiscountPrice();
                        exchangePriceDiffernce = goodsOptionPrice.getExchangeDiscountPrice() - goodsOptionPrice.getPrExchangeDiscountPrice();
                    } else {
                        priceDiffernce = goodsOptionPrice.getDiscountPrice() - goodsOptionPrice.getPrSalePrice();
                        exchangePriceDiffernce = goodsOptionPrice.getExchangeDiscountPrice() - goodsOptionPrice.getPrExchangePrice();
                    }
                } else {
                    if (goodsOptionPrice.getIsDiscountPeriod()) {
                        priceDiffernce = goodsOptionPrice.getSalePrice() - goodsOptionPrice.getPrDiscountPrice();
                        exchangePriceDiffernce = goodsOptionPrice.getExchangePrice() - goodsOptionPrice.getPrExchangeDiscountPrice();
                    } else {
                        priceDiffernce = goodsOptionPrice.getSalePrice() - goodsOptionPrice.getPrSalePrice();
                        exchangePriceDiffernce = goodsOptionPrice.getExchangeDiscountPrice() - goodsOptionPrice.getPrExchangeDiscountPrice();
                    }
                }

                a.setSalePrice(String.valueOf((priceDiffernce * (-1))));
                a.setExchangePrice(String.valueOf((exchangePriceDiffernce * (-1))));
            }
		});
		return goodsOptionList;
    }

    public double getExchangePrice(int price){
        return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
    }
}
