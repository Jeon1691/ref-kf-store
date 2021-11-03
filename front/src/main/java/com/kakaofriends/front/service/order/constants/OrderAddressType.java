package com.kakaofriends.front.service.order.constants;

/**
 * OrderAddressType
 *
 * Author  april
 * Date    2018. 1. 29.
 */
public enum OrderAddressType {
    DEFAULT_ADDRESS("D"),
    NEW_ADDRESS("N");

    private String code;

    OrderAddressType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OrderAddressType get(String code) {
        for (OrderAddressType type : OrderAddressType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return OrderAddressType.NEW_ADDRESS;
    }

    public static  OrderAddressType get(boolean defaultAddress) {
        if (defaultAddress) {
            return DEFAULT_ADDRESS;
        }
        return NEW_ADDRESS;
    }
}
