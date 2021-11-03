package com.kakaofriends.front.service.order;

import com.google.common.collect.Lists;
import com.kakaofriends.core.domain.Basket;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.order.OrderSheetDto;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import com.kakaofriends.front.repository.OrderRepository;
import com.kakaofriends.front.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.BASKET_DIRECT_NO;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
@Service
@EnableAsync
@Deprecated
public class DeprecatedOrderServiceImpl implements DeprecatedOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private ProductService productService;

    @Autowired
    ExchangeRateComponent exchangeRateComponent;

    @Override
    public ModelAndView getModelAndViewForBasket( OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        return null;
    }

    @Override
    public ModelAndView getModelAndViewForDirect( OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        return null;
    }

    @Override
    public List<Long> getCheckedPrEas( List<Integer> checkBoxFlags, List<Long> prEas ) {
        List<Long> temp = Lists.newArrayList();
        for ( int i = 0; i < checkBoxFlags.size(); i++ ) {
            if ( checkBoxFlags.get( i ) == 1 ) temp.add( Long.valueOf( prEas.get( i ) ) );
        }
        return temp;
    }

    @Override
    public long getBasketAccount( OrderSheetExpansion orderSheetExpansion ) {
        return orderSheetExpansion.getIsDiscountPeriod() ? orderSheetExpansion.getProductLevelPrice().getPrlpDiscountprice1() * orderSheetExpansion.getBsEa() : orderSheetExpansion.getProductLevelPrice().getPrlpSupplyprice() * orderSheetExpansion.getBsEa();
    }

    @Override
    public String getProductName( List<OrderSheetExpansion> orderSheetExpansionList, String locale ) {
        String firstName = orderSheetExpansionList.stream().findFirst().get().getProduct().getPrName();
        String productName = firstName + (orderSheetExpansionList.size() > 1 ? " 외" + String.valueOf( orderSheetExpansionList.stream().count() - 1 ) + "개" : "");
        if ( Locale.ENGLISH.getLanguage().equals( locale ) ) {
            firstName = orderSheetExpansionList.stream().findFirst().get().getProduct().getPrName1();
            productName = firstName + (orderSheetExpansionList.size() > 1 ? " and others (" + String.valueOf( orderSheetExpansionList.stream().count() - 1 ) + ")" : "");
        }

        return productName;
    }

    @Override
    public int basketPrEaUpdateToBasket( List<String> prCodes, OrderSheetDto.OrderSheetRequest orderSheetRequest, String customProductMsg, String oaCountryCode ) {
        String userId = getFriendsMemberId();
        //장바구니 정보 put
        List<Basket> bsList = new ArrayList<>();
        for ( int i = 0; i < prCodes.size(); i++ ) {
            Basket bs = new Basket();
            bs.setBsPrCode( orderSheetRequest.getPrCodes().get( i ) );
            bs.setBsEa( orderSheetRequest.getPrEas().get( i ) );
            bs.setGiftBag( orderSheetRequest.getIsGiftBag().get( i ) );
            if ( orderSheetRequest.getBsSeq().get( i ) != null ) {
                bs.setBsSeq( orderSheetRequest.getBsSeq().get( i ) );
            }
            if ( orderSheetRequest.getDisplayGoodsIds().get( i ) != null ) {
                bs.setDisplayGoodsId( orderSheetRequest.getDisplayGoodsIds().get( i ) );
            }
            bsList.add( bs );
        }

        if ( basketService.checkProductEa( bsList ) ) {
            for ( Basket bs : bsList ) {
                /*
                 * 2018.01.25 layla
                 * */
                if ( BASKET_DIRECT_NO.equals( orderSheetRequest.getOrderDirect() ) ) {
                    //custom상품 insert코드 제외(미사용) 2018.09.09 layla
					/*if (productService.findProductByProductCode(bs.getBsPrCode()).getIsCustomProduct()) {
						basketService.basketInsertProduct(BasketDto.Request.builder().prCode(bs.getBsPrCode()).prEa(bs.getBsEa()).oaCountryName(Country.getCountryCodeByName(oaCountryCode)).bsEtc5(customProductMsg).build(), userId, orderSheetRequest.getOrderDirect(), false);
					} else {*/
                    basketService.basketInsertProduct(
                        BasketDto.Request.builder()
                            .displayGoodsId( bs.getDisplayGoodsId() )
                            .prCode( bs.getBsPrCode() )
                            .oaCountryName( Country.getCountryCodeByName( oaCountryCode ) )
                            .prEa( bs.getBsEa() )
                            .build(),
                        userId, orderSheetRequest.getOrderDirect(), false );
                    //}
                } else {
                    BasketDto.Request request = BasketDto.Request.builder()
                        .displayGoodsId( bs.getDisplayGoodsId() )
                        .bsSeq( bs.getBsSeq() )
                        .ctSeq( orderSheetRequest.getCtSeq() )
                        .prCode( bs.getBsPrCode() )
                        .prEa( bs.getBsEa() )
                        .oaCountryCode( oaCountryCode )
                        .bsEtc5( customProductMsg )
                        .build();
                    basketService.basketInsertProduct( request, userId );
                }
            }
            return 0;
        }
        return 1;
    }

    @Override
    public List<OrderSheetExpansion> findByOrderSheetCodeListFromBasketSeq( List<Long> orderSheetCodeList, String ownerId, String countryCode ) {
        boolean isDomestic = Country.isDomestic( countryCode );
        return orderRepository.findByOrderSheetCodeListFromBasketSeq( orderSheetCodeList, ownerId, exchangeRateComponent.getExchangeRate(), isDomestic );
    }
}