package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum ProductDisplayType implements Code {

	NEW_ITEM("1", "newITem", "신상품"),
	SALE_ITEM("2", "saleItem", "할인상품"),
	BEST_SELLER_ITEM("3", "bestSellerItem", "베스트셀러"),
	SUGGEST_ITEM("4", "suggestItem", "추천상품"),
	PROMOTION_ITEM("5", "promotionItem", "기획상품"),
    THEME_ITEM("6", "themeItem", "테마상품"),
    NEW_SALE_ITEM("7", "newSaleItem", "세일상품");

	private final String code;
	private final String name;
	private final String alias;

	ProductDisplayType(String code, String name, String alias) {
		this.code = code;
		this.name = name;
		this.alias = alias;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}
}
