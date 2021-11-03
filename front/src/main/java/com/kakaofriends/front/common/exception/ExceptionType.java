package com.kakaofriends.front.common.exception;

/**
 * ExceptionType
 *
 * Author  april
 * Date    2018. 1. 18.
 */
public enum ExceptionType {

    INTERNAL_SERVER_ERROR("9000", "exception.common.server.error"),
    NOT_ACCEPTABLE("9001", ""),
    INVALID_BINDING("9003", "exception.binding.invalid");

    private String code;

    private String message;

    ExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static ExceptionType get(String code) {
        for (ExceptionType item : ExceptionType.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}