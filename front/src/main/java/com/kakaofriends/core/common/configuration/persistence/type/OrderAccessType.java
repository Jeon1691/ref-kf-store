package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;
import org.springframework.mobile.device.Device;

import java.util.Locale;

public enum OrderAccessType implements Code {
    KR("1", "KR"),
    EN("2", "EN"),
    CN("3", "CN"),
    MOBILE("5", "MOBILE");

    private final String code;
    private final String name;

    OrderAccessType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static OrderAccessType getAccessType(Locale locale, Device device) {
        if (device.isNormal()) {
            if (locale.equals(Locale.KOREA)) {
                return OrderAccessType.KR;
            }
            return OrderAccessType.EN;
        }
        return OrderAccessType.MOBILE;
    }

    public static OrderAccessType get(String code) {
        for (OrderAccessType type : OrderAccessType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return OrderAccessType.KR;
    }
}

