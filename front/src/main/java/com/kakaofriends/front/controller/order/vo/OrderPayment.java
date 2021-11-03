package com.kakaofriends.front.controller.order.vo;

import lombok.Data;

/**
 * OrderPayment : 주문 결제
 *
 * Author  april
 * Date    2018. 1. 23.
 */
@Data
public class OrderPayment {
    private String tid;
    private String uid;
    private String payerId;
    private String kakaoToken;

    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String cardCode;
    private String payMethod;
    private String encrypted;
    private String sessionKey;

    private String inicisMobileUrl;
}