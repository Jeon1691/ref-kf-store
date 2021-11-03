package com.kakaofriends.front.service.giftcard.vo;

/**
 * GiftCardMasterType
 *
 * Author  april
 * Date    2018. 1. 22.
 */
public enum GiftCardMasterType {
//    쿠폰구분(1:즉시,2:예약,3:별도,4:주문) + 5:포인트지류, 6:온라인쿠폰, 7:온라인 지류쿠폰
    INSTANT("1"),
    RESERVE("2"),
    SPECIAL("3"),
    ORDER("4"),
    PAPER_POINT("5"),
    ONLINE_COUPON("6"),
    ONLINE_PAPER_COUPON("7");

    private String code;

    GiftCardMasterType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GiftCardMasterType get(String code) {
        for (GiftCardMasterType type : GiftCardMasterType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return SPECIAL;
    }
}
