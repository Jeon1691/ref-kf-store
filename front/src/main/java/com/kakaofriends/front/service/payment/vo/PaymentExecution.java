package com.kakaofriends.front.service.payment.vo;

import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.controller.order.vo.OrderPayment;
import lombok.Data;

/**
 * PaymentExecution 결제 실행
 *
 * Author  april
 * Date    2018. 1. 11.
 */
@Data
public class PaymentExecution {
    private String tid;

    /**
     * PG사에서 전달해주는 unique id
     * - inicis : uid
     * - kakaopay : pg_token
     * - paypal : payerId
     */
    private String uid;

    /**
     * 이니시스 결제모듈에서 전달받는 데이터
     */
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String cardCode;
    private String payMethod;
    private String encrypted;
    private String sessionKey;

    private String inicisUrl;

    private String sessionId;

    public static PaymentExecution converts(PaymentGateway paymentGateway, OrderPayment orderPayment) {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setTid(orderPayment.getTid());
        paymentExecution.setMemberName(orderPayment.getMemberName());
        paymentExecution.setMemberPhone(orderPayment.getMemberPhone());
        paymentExecution.setMemberEmail(orderPayment.getMemberEmail());
        paymentExecution.setCardCode(orderPayment.getCardCode());
        paymentExecution.setPayMethod(orderPayment.getPayMethod());
        paymentExecution.setEncrypted(orderPayment.getEncrypted());
        paymentExecution.setSessionKey(orderPayment.getSessionKey());
        paymentExecution.setInicisUrl(orderPayment.getInicisMobileUrl());
        switch (paymentGateway) {
            case PAYPAL:
                paymentExecution.setUid(orderPayment.getPayerId());
                break;
            case KAKAOPAY:
                paymentExecution.setUid(orderPayment.getKakaoToken());
                break;
            default:
                paymentExecution.setUid(orderPayment.getUid());
                break;
        }
        return paymentExecution;
    }
}