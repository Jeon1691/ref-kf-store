package com.kakaofriends.front.domain;

/**
 * Created by ben on 2017. 11. 22..
 */
public enum EventType {

    DELIVERY("D", "배송비"),
    POINT("P", "포인트"),
    COUPON("C", "쿠폰");


    final private String code;
    final private String name;


    EventType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}