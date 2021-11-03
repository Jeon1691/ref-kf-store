package com.kakaofriends.front.service.delivery;

import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.service.basket.vo.BasketProduct;

import java.math.BigDecimal;
import java.util.List;

/**
 * DeliveryService : 배송과 관련된 비즈니스 로직을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 15.
 */
public interface DeliveryService {
    /**
     * 배송비를 반환한다.
     *
     * @param country 배송 국가
     * @param basketProductList 장바구니에 담긴 상품 목록
     * @return 배송비
     */
    BigDecimal getDeliveryFee(Country country, List<BasketProduct> basketProductList);

    /**
     * 정책적으로 설정 되어있는 국내 배송비를 반환한다.
     * - 백오피스에 입력되어있는 국내 배송비
     *
     * @return 국내 배송비
     */
    BigDecimal getDomesticDeliveryFee();

    /**
     * 상품 구매 금액에 따른 국내 배송비를 반환한다.
     * - 무료 배송 조건에 부합 할 경우 배송비 0원을 반환한다.
     *
     * @param productPrice 구매 상품 총액
     * @return 상품 구매에 따른 배송비
     */
    BigDecimal getDomesticDeliveryFee(BigDecimal productPrice);

    /**
     * 국내 배송비 무료 조건이 되는 금액을 반환한다.
     * - 얼마 이상 무료배송
     *
     * @return 무료배송 조건 금액
     */
    BigDecimal getDomesticFreeDeliveryConditionPrice();

    /**
     * 해외 배송비를 반환한다.
     *
     * @param country 배송 국가
     * @param weight 상품의 무게
     * @return 해외 배송비
     */
    BigDecimal getOverseaDeliveryFree(Country country, double weight);

    /**
     * 해외 배송비를 반환한다.
     * - 장바구니에 담긴 상품의 무게를 계산하여 배송비를 계산한다.
     * - 이벤트 기간일 경우 무료배송 처리된다.
     *
     * @return 해외 배송비
     */
    BigDecimal getOverseaDeliveryFee(Country country, List<BasketProduct> basketProductList);
}
