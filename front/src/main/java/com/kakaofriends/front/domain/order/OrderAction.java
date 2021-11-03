package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;

/**
 * OrderAction
 *
 * Author  layla
 * Date    2018. 02. 22.
 */
public enum OrderAction {
    //ADD(0, "ADD"), //재고 입고
    ORDER(OrderStatusType.RECEIVING_ORDER.getCode(), "ORDER"), //주문
    CANCEL(OrderStatusType.CANCEL_COMPLETED.getCode(), "CANCEL"); //취소
    //EXCHANGE(OrderStatusType.RECEIVING_ORDER.getCode(), "EXCHANGE"), //교환
    //REFUND(OrderStatusType.RECEIVING_ORDER.getCode(), "REFUND"); //환불

    private Integer code;
    private String name;

    OrderAction(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

