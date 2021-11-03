package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;
import com.kakaofriends.front.domain.Country;

public enum  DeliInOutType implements Code {

	DOMESTIC("1", "국내", true),
	OVERSEAS("2", "국외", false);

	private String code;
	private String name;
	private boolean domestic;


	DeliInOutType(String code, String name, boolean domestic) {
		this.code = code;
		this.name = name;
		this.domestic = domestic;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static DeliInOutType getDeliveryInOutType(Country country) {
		if (country.equals(Country.Korea)) {
			return DeliInOutType.DOMESTIC;
		} else {
			return DeliInOutType.OVERSEAS;
		}
	}

	public static DeliInOutType get(String code) {
		for (DeliInOutType type : DeliInOutType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return DeliInOutType.DOMESTIC;
	}

	public static DeliInOutType get(boolean isDomestic) {
		if (isDomestic) {
			return DeliInOutType.DOMESTIC;
		} else {
			return DeliInOutType.OVERSEAS;
		}
	}

	public boolean isDomestic() {
		return this.equals(DOMESTIC);
	}
}
