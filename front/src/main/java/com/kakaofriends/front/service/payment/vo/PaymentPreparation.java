package com.kakaofriends.front.service.payment.vo;

import com.kakaofriends.front.common.api.OrderPath;
import com.kakaofriends.front.domain.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * PaymentPreparation : 결제 준비 요청
 *
 * Author  april
 * Date    2018. 1. 11.
 */
@Data
public class PaymentPreparation {
    private String orderNumber;
    private long memberId;
    /**
     * 이니시스 모바일에서 전처리에 필요한 값
     */
    private String memberEmail;
    private String memberName;

    private List<PaymentItem> paymentItem;
    private BigDecimal deliveryPrice;
    private BigDecimal discountPrice;
    private Currency currency;

    /**
     * 카카오페이에서 요청하는 다음 액션에 대한 url 값
     *
     * - approvalUrl : 결제 승인 후 반환 될 url
     * - failUrl : 결제 실패 후 반환 될
     * - cancelUrl : 결제 중 취소 후 반환 될 url
     */
    private String approvalUrl;
    private String failUrl;
    private String cancelUrl;

    private String message;

    public PaymentPreparation() {
        deliveryPrice = new BigDecimal(0);
        memberId = 0l;
    }

    //주문: order, 회수비: orderadddeli
    public OrderPath orderPath;
}