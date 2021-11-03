package com.kakaofriends.front.domain;

/**
 * Created by ben on 2017. 11. 22..
 */
public enum EventOrderType {

    DOMESTIC("D", "국내"),
    GLOBAL("G", "해외");

    final private String code;
    final private String name;


    EventOrderType(String code, String name) {
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