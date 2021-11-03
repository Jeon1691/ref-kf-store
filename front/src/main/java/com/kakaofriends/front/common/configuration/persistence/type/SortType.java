package com.kakaofriends.front.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum SortType implements Code {

	NEW("new", "신상품순", "Newly stocked"),
	PRICE_ASC("priceAsc", "낮은가격순", "Price low to high"),
	PRICE_DESC("priceDesc", "높은가격순", "Price high to low");

	private String code;
	private String name;
	private String ename;

	SortType(String code, String name, String ename) {
		this.code = code;
		this.name = name;
		this.ename = ename;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getEname() { return ename; }
}