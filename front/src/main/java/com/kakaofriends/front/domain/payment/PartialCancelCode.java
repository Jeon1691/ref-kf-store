package com.kakaofriends.front.domain.payment;

import com.kakaofriends.core.domain.enums.Code;

public enum PartialCancelCode implements Code {

	ALL_CANCEL("0", "allCancel"),
	PARTIAL_CANCEL("1", "partialCancel");

	private String code;
	private String name;

	PartialCancelCode(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}
}
