package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum BannerType implements Code {

    MAIN_ROLLING("1", "mainRolling", "PC"),
    MAIN_CARD_NORMAL("2", "mainCardNormal", "PC"),
    MAIN_CARD_WIDE("3", "mainCardWide", "PC"),
    MAIN_BAND("4", "mainCardBand", "PC"),
    PRODUCT_DETAIL("5", "productDetail", "PC"),
    STORE_ROLLING("6", "storeRolling", "PC"),

    MAIN_ROLLING_MOBILE("11", "mainRollingMobile", "MO"),
    MAIN_CARD_NORMAL_MOBILE("12", "mainCardNormalMobile", "MO"),
    MAIN_CARD_WIDE_MOBILE("13", "mainCardWideMobile", "MO"),
    MAIN_BAND_MOBILE("14", "mainCardBandMobile", "MO"),
    PRODUCT_DETAIL_MOBILE("15", "productDetailMobile", "MO"),
    STORE_ROLLING_MOBILE("16", "storeRollingMobile", "MO"),
    GNB_BAND_MOBILE("17", "gnbBandMobile", "MO"),

    MAIN_ROLLING_EN("21", "mainRollingEN", "PC"),
    MAIN_CARD_NORMAL_EN("22", "mainCardNormalEN", "PC"),
    MAIN_CARD_WIDE_EN("23", "mainCardWideEN", "PC"),

    MAIN_ROLLING_MOBILE_EN("31", "mainRollingMobileEN", "MO"),
    MAIN_CARD_NORMAL_MOBILE_EN("32", "mainCardNormalMobileEN", "MO"),
    MAIN_CARD_WIDE_MOBILE_EN("33", "mainCardWideMobileEN", "MO"),

    GNB_BAND_MOBILE_EN("37", "gnbBandMobileEN", "MO"),

    MAIN_ROLLING_BG("41", "mainRollingBg", "PC"),
    MAIN_ROLLING_BG_EN("42", "mainRollingBgEN", "PC"),
    MAIN_ROLLING_MOBILE_BG("43", "mainRollingMobileBg", "MO"),
    MAIN_ROLLING_MOBILE_BG_EN("44", "mainRollingMobileBgEN", "MO"),

    MAIN_TOP("51", "mainTop", "PC"),
    MAIN_TOP_EN("52", "mainTopEN", "PC"),
    MAIN_TOP_MOBILE("53", "mainTopMobile", "MO"),
    MAIN_TOP_MOBILE_EN("54", "mainTopMobileEN", "MO"),

    MAIN_NEW_PRODUCT("61", "mainNewProduct", "PC"),
    MAIN_NEW_PRODUCT_EN("62", "mainNewProductEN", "PC"),
    MAIN_NEW_PRODUCT_MOBILE("63", "mainNewProductMobile", "MO"),
    MAIN_NEW_PRODUCT_MOBILE_EN("64", "mainNewProductMobileEN", "MO"),

    MAIN_THEME("71", "mainTheme", "PC"),
    MAIN_THEME_EN("72", "mainThemeEN", "PC"),
    MAIN_THEME_MOBILE("73", "mainThemeMobile", "MO"),
    MAIN_THEME_MOBILE_EN("74", "mainThemeMobileEN", "MO"),

    MAIN_THEME_BG("75", "mainThemeBg", "PC"),
    MAIN_THEME_BG_EN("76", "mainThemeBgEN", "PC"),
    MAIN_THEME_MOBILE_BG("77", "mainThemeMobileBg", "MO"),
    MAIN_THEME_MOBILE_BG_EN("78", "mainThemeMobileBgEN", "MO");

	private String code;
	private String name;
	private String device;

	BannerType(String code, String name, String device) {
		this.code = code;
		this.name = name;
		this.device = device;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDevice() {
		return device;
	}
}
