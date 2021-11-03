package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.basket.BasketData;
import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.product.ProductData;
import com.kakaofriends.front.domain.product.ProductLevelPriceData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.BASKET_DIRECT_NO;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

/**
 * TestBasketRepository
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestBasketRepository {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductLevelPriceRepository productLevelPriceRepository;

    @Test
    public void test() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatterBuilder startBuilder = new DateTimeFormatterBuilder().append(formatter);
        startBuilder.parseDefaulting(ChronoField.HOUR_OF_DAY, 0);
        startBuilder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0);
        startBuilder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);
        DateTimeFormatter startTimeFormat = startBuilder.toFormatter();
        DateTimeFormatterBuilder endBuilder = new DateTimeFormatterBuilder().append(formatter);
        endBuilder.parseDefaulting(ChronoField.HOUR_OF_DAY, 23);
        endBuilder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 59);
        endBuilder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 59);
        DateTimeFormatter endTimeFormat = endBuilder.toFormatter();
        LocalDateTime startDate = LocalDateTime.parse("2017-04-02", startTimeFormat);
        LocalDateTime endDate = LocalDateTime.parse("2017-04-02", endTimeFormat);
        System.out.println("#### start date Test = " + startDate);
        System.out.println("#### end date Test = " + endDate);
    }

    @Test
    public void selectBasket() {
        List<Long> list = new ArrayList<>();
        list.add(3333l);
        list.add(4444l);
        list.add(5555l);
        List<BasketData> resultList = basketRepository.selectList(list);
        System.out.println("#### Basket Test = " + resultList);
    }


    @Test
    public void selectProduct() {
        String productCode = "FRPBRYSPD0003";
        ProductData data = productRepository.selectByProductCode(productCode);
        System.out.println("#### Product Test = " + data);
    }

    @Test
    public void selectPrice() {
        String productCode = "FRPBRYSPD0003";
        ProductLevelPriceData data = productLevelPriceRepository.select(productCode);
        System.out.println("#### Product Price Test = " + data);
    }

    @Test
    public void selectFindByBsOwnerId() {
        List<BasketExpansion> basketExpansions = basketRepository.findByBsOwnerId("54685", 1073.469970703125, true);
        System.out.println("#### Test = " + basketExpansions);

        basketExpansions.forEach(b -> {
            //추천상품 셋팅
            if (b.getDisplayGoodsId() != null) {
                b.setSuggestedProducts(basketRepository.findSuggestedProductByPrCode(b.getDisplayGoodsId(), b.getStDomestic()));
            }
        });

        System.out.println("#### Test = " + basketExpansions);
    }

    @Test
    public void insert(){
        BasketDto.Request request = new BasketDto.Request();
        request.setPrCode("FRPBMZTEV0001");
        request.setDisplayGoodsId(13102L);
        String ownerId = "67393bd9-1f86-4b32-9512-f189b4d4bb6c";

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
        basket.setBsDirect(BASKET_DIRECT_NO);
        basket.setBsEtc5(request.getBsEtc5());
        basket.setDisplayGoodsId(request.getDisplayGoodsId());
        basketRepository.basketInsert(basket);
    }
}
