package com.kakaofriends.front.service.order.vo;

import lombok.Data;

import java.util.List;

/**
 * Order : 주문 정보에 대한 value object
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Data
public class Order {
    private OrderMain orderMain;
    private List<OrderSub> orderSubList;
    private OrderAddress orderAddress;
    private List<String> giftCardCodeList;

    public Order() {
    }

    public Order(OrderMain orderMain, List<OrderSub> orderSubList, OrderAddress orderAddress) {
        this.orderMain = orderMain;
        this.orderSubList = orderSubList;
        this.orderAddress = orderAddress;
    }

    public void setTid(String tid) {
        this.orderMain.setPgTid(tid);
        for (OrderSub orderSub : this.orderSubList) {
            orderSub.setPgTid(tid);
        }
    }

    public void setOrderNumber(String orderNumber) {
        this.orderMain.setOrderNumber(orderNumber);
        this.orderAddress.setOrderNumber(orderNumber);
        for (OrderSub orderSub : this.orderSubList) {
            orderSub.setOrderNumber(orderNumber);
        }
    }

}