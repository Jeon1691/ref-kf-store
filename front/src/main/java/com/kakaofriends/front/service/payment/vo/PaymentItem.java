package com.kakaofriends.front.service.payment.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * PaymentItem : 결제할 상품 아이템 클래스
 *
 * Author  april
 * Date    2018. 1. 12.
 */
@Data
public class PaymentItem {
    private String name;
    private String productCode;
    private BigDecimal price;
    private int quantity;

    public PaymentItem() {
        this.price = new BigDecimal(0);
    }

    /**
     * 결제 한건의 금액을 계산한다.
     * - 상품 가격 * 수량
     *
     * @return 결제 건 금액
     */
    public BigDecimal getPaymentItemPrice() {
        BigDecimal quantity = new BigDecimal(this.getQuantity());
        return this.price.multiply(quantity);
    }
}