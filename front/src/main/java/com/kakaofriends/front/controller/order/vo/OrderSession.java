package com.kakaofriends.front.controller.order.vo;

import lombok.Data;

import java.util.List;

/**
 * OrderSession : 주문 세션
 *
 * Author  april
 * Date    2018. 3. 22.
 */
@Data
public class OrderSession {
    private String orderNumber;
    private String paymentSessionId;
    private List<Long> basketSequenceList;
}
