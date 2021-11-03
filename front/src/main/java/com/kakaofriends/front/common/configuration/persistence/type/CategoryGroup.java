package com.kakaofriends.front.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum CategoryGroup implements Code {

	CATEGORIES("3", "categories"),
	CHARACTERS("4", "characters");

	private String code;
	private String name;

	CategoryGroup(String code, String name) {
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
