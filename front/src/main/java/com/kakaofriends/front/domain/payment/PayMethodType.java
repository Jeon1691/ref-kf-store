package com.kakaofriends.front.domain.payment;

import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;

import java.util.Arrays;

public enum PayMethodType {
	// Old KakaoPay
	KAKAOPAY("kakaopay", "카카오페이", "cnspay", PayType.KAKAOPAY, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	// New KakaoPay
	KAKAOPAY_V2("kakaopay_v2", "카카오페이", "kakaopay_v2", PayType.KAKAOPAY_V2, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	PAYPAL("paypal", "페이팔", "paypal", PayType.PAYPAL, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	ONLYDBANK("onlydbank", "이니시스계좌이체", "inipay", PayType.ONLY_DBANK, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN}),
	ONLYCARD("onlycard", "이니시스신용카드", "inipay", PayType.ONLY_CARD, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	M_ONLYDBANK("mobileOnlydbank", "이니시스모바일계좌이체", "inimobiledbank", PayType.ONLY_DBANK, new OrderAccessType[] {OrderAccessType.MOBILE}),

	// Old KakaoPay
	KAKAOPAY_ADD("kakaopayAdd", "카카오페이환불배송료", "cnspayAdd", PayType.KAKAOPAY, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	// New KakaoPay
	KAKAOPAY_ADD_V2("kakaopayAdd_v2", "카카오페이환불배송료", "kakaopayAdd", PayType.KAKAOPAY_V2, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	ONLYDBANK_ADD("onlydbank", "이니시스계좌이체", "inipayAdd", PayType.ONLY_DBANK, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN}),
	ONLYCARD_ADD("onlycard", "이니시스신용카드", "inipayAdd", PayType.ONLY_CARD, new OrderAccessType[] {OrderAccessType.KR, OrderAccessType.EN, OrderAccessType.MOBILE}),
	M_ONLYDBANK_ADD("mobileOnlydbank", "이니시스모바일계좌이체", "inimobiledbankAdd", PayType.ONLY_DBANK, new OrderAccessType[] {OrderAccessType.MOBILE});

	private String code;
	private String name;
	private String path;
	private PayType payType;
	private OrderAccessType[] orderAccessTypes;


	PayMethodType(String code, String name, String path, PayType payType, OrderAccessType[] orderAccessTypes) {
		this.code = code;
		this.name = name;
		this.path = path;
		this.payType = payType;
		this.orderAccessTypes = orderAccessTypes;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public PayType getPayType() { return payType;}

	public OrderAccessType[] getOrderAccessTypes() {return orderAccessTypes;}

	public static PayMethodType findPayMethodTypeByOrderPayTypeAndOrderAccessType(PayType payType, OrderAccessType orderAccessType){
		return Arrays.asList(PayMethodType.values()).stream().filter(e -> e.getPayType().equals(payType)).filter(i -> Arrays.asList(i.getOrderAccessTypes()).contains(orderAccessType)).findFirst().get();
	}
}