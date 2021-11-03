package com.kakaofriends.front.domain.payment;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * PaymentHistoryData : 결제에 대한 이력정보를 가진 데이터 클래스
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@Data
public class PaymentHistoryData {
    private long id;
    private long memberId;
    private String orderId;
    private String type;
    private String action;
    private String paymentMethod;
    private String currency;
    private float paymentAmount;
    private float shippingAmount;
    private LocalDateTime createdDate;
}
