package com.kakaofriends.core.common.configuration.persistence.type;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.kakaofriends.core.domain.enums.Code;
import com.kakaofriends.front.common.api.PaymentGateway;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PayType implements Code {

	ONLY_CARD("1", "onlycard", "카드", "Credit Card"),
	ONLY_DBANK("2", "onlydbank" , "계좌이체", "Bank transfer"),
	ONLY_VBANK("3", "onlyvbank" , "가상계좌", "Virtual bank account number"),
	LATE_CASH("4", "latecash", "후불", "Deferred payment"),
	// Old KaKaoPay
	KAKAOPAY("5", "kakaopay", "카카오페이", "KakaoPay"),
	ONLY_HPP("6", "onlyhpp", "휴대폰결제", "Mobile payment"),
	PAYPAL("7", "paypal", "페이팔", "Paypal"),
	KAKAOPAY_V2("8", "kakaopay_v2", "카카오페이", "Kakaopay");
	private String code;
	private String name;
	private String alias;
    private String alias_EN;

	PayType(String code, String name, String alias, String alias_EN) {
		this.code = code;
		this.name = name;
		this.alias = alias;
        this.alias_EN = alias_EN;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

    public String getAlias() { return alias;}

    public String getAlias_EN() { return alias_EN;}

    public static PayType getPayType(PaymentGateway pg) {
		switch (pg) {
			case INICIS:
			case INICIS_MOBILE:
				return ONLY_CARD;
			case PAYPAL:
				return PAYPAL;
			case KAKAOPAY:
				return KAKAOPAY_V2;
		}
		return null;
	}

	public static PayType get(String code) {
		for (PayType type : PayType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}
}
