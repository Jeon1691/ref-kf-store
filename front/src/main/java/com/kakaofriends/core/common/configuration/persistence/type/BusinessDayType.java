package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum BusinessDayType implements Code {
	week("week", "평일(월~금)"),
	daily("daily", "매일");

	private final String code;
	private final String name;

	BusinessDayType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}