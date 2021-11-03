package com.kakaofriends.front.service.delivery;

import com.kakaofriends.core.domain.Config;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.repository.ConfigRepository;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.EventService;
import com.kakaofriends.front.service.basket.vo.Basket;
import com.kakaofriends.front.service.basket.vo.BasketProduct;
import com.kakaofriends.front.service.product.vo.Product;
import com.kakaofriends.front.utils.BoxUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * DeliveryServiceImpl : 배송비에 대한 비즈니스로직을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 15.
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class DeliveryServiceImpl implements DeliveryService {

    private ConfigRepository configRepository;
    private EventService eventService;
    private EmsService emsService;

    @Override
    public BigDecimal getDeliveryFee(Country country, List<BasketProduct> basketProductList) {
        BigDecimal price = this.getTotalPrice(basketProductList);
        switch (country) {
            case Korea:
                return this.getDomesticDeliveryFee(price);
            default:
                return this.getOverseaDeliveryFee(country, basketProductList);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getDomesticDeliveryFee() {
        Config config = configRepository.findByCfId("DELIVERYMONEY");
        return new BigDecimal(config.getCfValue());
    }

    @Override
    public BigDecimal getDomesticDeliveryFee(BigDecimal productPrice) {
        BigDecimal freeCondition = this.getDomesticFreeDeliveryConditionPrice();
        if (productPrice.compareTo(freeCondition) >= 0){
            return BigDecimal.ZERO;
        }
        return this.getDomesticDeliveryFee();
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getDomesticFreeDeliveryConditionPrice() {
        Config config = configRepository.findByCfId("DELIVERYLIMITMONEY");
        return new BigDecimal(config.getCfValue());
    }

    @Override
    public BigDecimal getOverseaDeliveryFree(Country country, double weight) {
        Long emsPrice = emsService.getEmsPrice(country.getCode(), weight);
        return BigDecimal.valueOf(emsPrice);
    }

    @Override
    public BigDecimal getOverseaDeliveryFee(Country country, List<BasketProduct> basketProductList) {
        BigDecimal price = this.getTotalPrice(basketProductList);

        EventDto eventDto = eventService.getCurrentEvent(EventOrderType.GLOBAL.getCode(), EventType.DELIVERY.getCode(), price.doubleValue());
        if (eventDto != null) {
            return BigDecimal.ZERO; // 이벤트가 존재하면 무료배송
        }

        BigDecimal deliveryFee = new BigDecimal(0);
        BoxUtil boxUtil = new BoxUtil();
        List<BoxItem> boxItemList = boxUtil.getBoxs(toBoxItemList(basketProductList), null);

        for (BoxItem boxItem : boxItemList) { // 배송 국가 별 무게로 배송비 계산
            BigDecimal one = this.getOverseaDeliveryFree(country, boxItem.getWeight());
            deliveryFee = deliveryFee.add(one);

        }
        return deliveryFee;
    }

    /**
     * 장바구니에 담긴 상품의 총액을 반환한다.
     *
     * @param basketProductList 장바구니 상품 목록
     * @return 장바구니에 담긴 상품의 총액
     */
    private BigDecimal getTotalPrice(List<BasketProduct> basketProductList) {
        BigDecimal price = new BigDecimal(0);
        for (BasketProduct basketProduct : basketProductList) {
            // price += product_price * ea
            BigDecimal basketProductPrice = basketProduct.getPrice();
            price = price.add(basketProductPrice);
        }
        return price;
    }

    /**
     * 장바구니에 담긴 각각의 상품을 box 에 담는다.
     *
     * @param basketProductList 장바구니 상품 목록
     * @return 박스에 담길 상품 목록
     */
    private LinkedList<BoxItem> toBoxItemList(List<BasketProduct> basketProductList){
        LinkedList<BoxItem> itemList = new LinkedList<>();

        basketProductList.forEach(e -> {
            Product product = e.getProduct();
            Basket basket = e.getBasket();
            BigDecimal amount = product.getCurrentPrice();

            for(int i=0; i < basket.getEa(); i++){
                itemList.add(new BoxItem(product, amount.longValue(), null));
            }
        });

        return itemList;
    }
}
