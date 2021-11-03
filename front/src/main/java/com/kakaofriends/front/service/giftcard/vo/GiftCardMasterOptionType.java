package com.kakaofriends.front.service.giftcard.vo;

/**
 * GiftCardMasterOptionType
 *
 * Author  april
 * Date    2018. 1. 22.
 */
public enum GiftCardMasterOptionType {
    AMOUNT("A"),
    DELIVERY("D"),
    CATEGORY("C");

    private String code;

    GiftCardMasterOptionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GiftCardMasterOptionType get(String code) {
        for (GiftCardMasterOptionType type : GiftCardMasterOptionType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return AMOUNT;
    }
}
