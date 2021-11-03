package com.kakaofriends.front.common.configuration.persistence.type;

public enum BoardCategoryType {
    MEMBERSHIP(1, "회원"),
    ITEMS(2, "상품"),
    ORDER_PAYMENT(3, "주문결제"),
    SHIPPING(4, "배송"),
    COUPON(5, "쿠폰"),
    CANCEL_REFUND(6, "교환/반품/환불"),
    RETURN_EXCHANGE(7, "기타"),
    RECEIPT_REQUEST(8, "영수증/증빙서류");

    private Integer code;
    private String name;

    BoardCategoryType(Integer code, String name) {
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
