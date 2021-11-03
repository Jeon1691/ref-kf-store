package com.kakaofriends.front.service.product.vo;

/**
 * GoodsOptionType : 상품 옵션타입
 *
 * Author  layla
 * Date    2018. 8. 24.
 */
public enum GoodsOptionType {
    SINGLE("S"), //단품
    OPTION_SINGLE("1"), //옵션1단
    OPTION_MULTI("2"); //옵션2단

    private String code;

    GoodsOptionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GoodsOptionType get(String code) {
        for (GoodsOptionType type : GoodsOptionType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return GoodsOptionType.SINGLE;
    }
}
