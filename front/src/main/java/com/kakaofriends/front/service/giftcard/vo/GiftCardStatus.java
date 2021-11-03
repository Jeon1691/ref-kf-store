package com.kakaofriends.front.service.giftcard.vo;

/**
 * GiftCardStatus : gift card 사용 상태 값
 *
 * Author  april
 * Date    2018. 1. 22.
 */
public enum GiftCardStatus {
    AVAILABLE("1"),
    NOT_AVAILABLE("2"),
    ALREADY_USED("3");

    private String code;

    GiftCardStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GiftCardStatus get(String code) {
        for (GiftCardStatus status : GiftCardStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
