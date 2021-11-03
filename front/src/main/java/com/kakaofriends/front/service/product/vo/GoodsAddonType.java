package com.kakaofriends.front.service.product.vo;

/**
 * GoodsAddonType : 상품 구타입
 *
 * Author  layla
 * Date    2018. 8. 24.
 */
public enum GoodsAddonType {
    MAIN("M"), //메인
    SUB("S"); //추가상품

    private String code;

    GoodsAddonType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GoodsAddonType get(String code) {
        for (GoodsAddonType type : GoodsAddonType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return GoodsAddonType.MAIN;
    }
}
