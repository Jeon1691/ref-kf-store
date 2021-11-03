package com.kakaofriends.front.common.configuration.persistence.type;

public enum BoardType {
    BNOTICE(1, "bnotice"),
    FAQ(4, "faq");

    private Integer code;
    private String name;

    BoardType(Integer code, String name) {
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
