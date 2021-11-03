package com.kakaofriends.front.service.payment.vo;

import lombok.Data;

/**
 * PaymentResult
 *
 * Author  april
 * Date    2018. 1. 26.
 */
@Data
public class PaymentResult {
    private String tid;
    private String orderNumber;

    private String message;
}
