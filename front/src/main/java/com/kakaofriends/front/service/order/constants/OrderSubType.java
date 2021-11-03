package com.kakaofriends.front.service.order.constants;

/**
 * OrderSubType : 결제 상세 유형
 *
 * Author  april
 * Date    2018. 1. 29.
 */
public enum OrderSubType {
    ORDER("1"),
    DELIVERY_FEE("2");

    private String code;

    OrderSubType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OrderSubType get(String code) {
        for (OrderSubType type : OrderSubType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return OrderSubType.ORDER;
    }
}
