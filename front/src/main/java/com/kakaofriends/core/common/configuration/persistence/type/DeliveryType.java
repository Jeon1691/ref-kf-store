package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;
import com.kakaofriends.front.domain.Country;

public enum DeliveryType implements Code {

	PARCEL_SERVICE("1", "parcelService", "택배"),
	DIRECT_DELIVERY("2", "EN", "직배"),
	QUICK_DELIVERY("3", "CN", "일반쿽"),
	DHL("4", "MOBILE", "DHL"),
	FREIGHT("5", "MOBILE", "화물"),
	EMS("6", "MOBILE", "EMS"),
	FORWARD("7", "MOBILE", "포워더"),
	DOSAN_QUICK("8", "MOBILE", "두산퀵");

	private final String code;
	private final String name;
	private final String alias;

	DeliveryType(String code, String name, String alias) {
		this.code = code;
		this.name = name;
		this.alias = alias;
	}

	public String getCode() {
		return this.code;
	}

	public static DeliveryType get(String code) {
		for (DeliveryType type : DeliveryType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}

	public static DeliveryType getDeliveryType(Country country) {
		switch (country) {
			case Korea:
				return DeliveryType.PARCEL_SERVICE;
			default:
				return DeliveryType.EMS;
		}
	}
}