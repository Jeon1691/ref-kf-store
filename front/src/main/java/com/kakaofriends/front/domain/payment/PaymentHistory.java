package com.kakaofriends.front.domain.payment;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.Currency;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
/**
 * PaymentHistoryData : 결제이력 클래스
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@Data
public class PaymentHistory {
    private long id;
    private long memberId;
    private String orderId;
    private PaymentHistoryType type;
    private PaymentAction action;
    private PayType paymentMethod;
    private Currency currency;
    private float paymentAmount;
    private float shippingAmount;
    private LocalDateTime createdDate;

    @Getter
    public static final long NON_MEMBER = -1;

    public void setMemberId(String memberId) {
        try {
            this.memberId = Long.parseLong(memberId);
        } catch (NumberFormatException e) {
            this.memberId = NON_MEMBER;
        }
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

}