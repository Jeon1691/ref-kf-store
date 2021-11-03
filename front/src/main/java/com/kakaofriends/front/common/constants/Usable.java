package com.kakaofriends.front.common.constants;

/**
 * Usable
 *
 * Author  april
 * Date    2018. 1. 29.
 */
public enum Usable {
    USE("Y", true),
    NOT_USE("N", false);

    private String code;
    private boolean use;

    Usable(String code, boolean use) {
        this.code = code;
        this.use = use;
    }

    public String getCode() {
        return code;
    }

    public boolean isUse() {
        return use;
    }

    public static Usable get(String code) {
        for (Usable usable : Usable.values()) {
            if (usable.getCode().equals(code)) {
                return usable;
            }
        }
        return Usable.NOT_USE;
    }

    public static Usable get(boolean isUse) {
        if (isUse) {
            return USE;
        }
        return NOT_USE;
    }
}
