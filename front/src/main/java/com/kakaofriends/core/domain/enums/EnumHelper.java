package com.kakaofriends.core.domain.enums;

public class EnumHelper {

	public static <E extends Enum<E> & Code> E getValue(String code, E[] values) {
		if (code == null || values == null || values.length == 0) {
			return null;
		}
		for (E value : values) {
			if (code.equals(value.getCode())) {
				return value;
			}
		}
		return null;
	}
}
