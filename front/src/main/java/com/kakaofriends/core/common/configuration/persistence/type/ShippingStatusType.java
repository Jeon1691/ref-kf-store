package com.kakaofriends.core.common.configuration.persistence.type;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ShippingStatusType {
	ORDER_COMPLETE(1, "주문접수", "receiving order", Lists.newArrayList(4)),
	SHIPPING_READY(2, "배송준비", "Shipping soon", Lists.newArrayList(5, 6)),
	WHILE_SHIPPING(3, "배송중", "in transit", Lists.newArrayList(7)),
	SHIPPING_COMPLETE(4, "배송완료", "delivered", Lists.newArrayList(8)),
	PURCHASE_COMPLETE(5, "구매완료", "receipt", Lists.newArrayList(9, 300, 3000, 400, 4000, 500, 5000, 40000, 400000, 50000, 500000, 100000000, 200000000)),
	CANCEL_COMPLETED(6, "주문취소", "cancel completed", Lists.newArrayList(30000, 300000));

	private Integer code;
	private String name;
	private String name_EN;
	private List<Integer> orderStatusTypeCodes;

	ShippingStatusType(Integer code, String name, String name_EN, List<Integer> orderStatusTypeCodes) {
		this.code = code;
		this.name = name;
		this.name_EN = name_EN;
		this.orderStatusTypeCodes = orderStatusTypeCodes;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getName_EN() {
		return name_EN;
	}

	public List<Integer> getOrderStatusTypeCodes() {
		return orderStatusTypeCodes;
	}
}
