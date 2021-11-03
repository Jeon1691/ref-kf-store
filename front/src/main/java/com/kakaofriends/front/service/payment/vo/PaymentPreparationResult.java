package com.kakaofriends.front.service.payment.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * PaymentPreparationResult : 결제 준비에 대한 응답
 *
 * Author  april
 * Date    2018. 1. 11.
 */
@Data
public class PaymentPreparationResult implements Serializable {
    private String tid;
    private String message;

    /**
     * 이니시스에서 반환한 결제요청 데이터
     */
    private String encryptedField;

    /**
     * 카카오페이에서 반환한 결제 화면 url
     */
    private String mobileURl;
    private String webUrl;
    private String mobileDom;

    private String createdAt;

    private String sessionId;
}