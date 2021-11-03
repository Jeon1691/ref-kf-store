package com.kakaofriends.core.common.configuration.persistence.type;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatusType {
	// 주문취소 및 배송지 변경 가능
	APPLICATION_DENIED(-1, "신청반려", "Request declined"),
	SECONDARY_AWAITING_APPROVAL(1, "1차승인대기", "Pending 1st level approval"),
	PRIMARY_AWAITING_APPROVAL(2, "2차승인대기", "Pending 2nd level approval"),
	PAYMENT_WAITING(3, "입금대기", "Pending transfer"),
	RECEIVING_ORDER(4, "주문접수", "Order received"),

	// 주문취소 및 배송지 변경 불가능
	SHIPPING_PREPARATION(5, "배송준비", "Preparing to ship"),
	INPUT_INVOICES(6, "송장입력", "Tracking number updated"),
	IN_SHIPPING(7, "배송중", "En route"),

	// 구매확정, 반품신청, 교환신청 가능
	COMPLETION_DISPATCH(8, "배송완료", "Delivery complete"),

	// 구매확정, 반품신청, 교환신청 불가능
	PURCHASE_FINALIZED(9, "구매확정", "Proceed to checkout"),
	PARTIAL_CANCEL_APPLICATION(300, "부분취소신청", "Request a partial cancelation"),
	CANCEL_APPLICATION(3000, "취소신청", "Request a cancellation"),
	PARTIAL_RETURN_APPLICATION(400, "부분반품신청", "Request a partial return"),
	RETURN_APPLICATION(4000, "반품신청", "Request a return"),
	PARTIAL_EXCHANGE_APPLICATION(500, "부분교환신청", "Request a partial exchange"),
	EXCHANGE_APPLICATION(5000, "교환신청", "Request an exchange"),

	PRIMARY_APPROVAL_CANCELLATION_COMPLETED(100000, "1차승인취소완료", "First cancellation approved"),
	SECONDARY_APPROVAL_CANCELLATION_COMPLETED(200000, "2차승인취소완료","Second cancellation approved"),
	PARTIAL_CANCEL_COMPLETED(30000, "부분취소완료", "Partial cancellation complete"),
	CANCEL_COMPLETED(300000, "취소완료", "Cancellation complete"),
	PARTIAL_RETURN_COMPLETED(40000, "부분반품완료", "Partial return complete"),
	RETURN_COMPLETED(400000, "반품완료", "Return complete"),
	PARTIAL_EXCHANGE_COMPLETED(50000, "부분교환완료", "Partial exchange complete"),
	EXCHANGE_COMPLETED(500000, "교환완료", "Return complete"),
	RECOVERY_WAITING(100000000, "회수대기", "Pending withdrawal"),
	COMPLETE_RECOVERY(200000000, "회수완료", "Withdrawal complete");

	private Integer code;
	private String name;
	private String name_EN;

	OrderStatusType(Integer code, String name, String name_EN) {
		this.code = code;
		this.name = name;
		this.name_EN = name_EN;
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

	public static OrderStatusType getOrderStatusType(Integer code) {
		for (OrderStatusType type : OrderStatusType.values()) {
			Integer typeCode = type.getCode();
			if (typeCode.equals(code)) {
				return type;
			}
		}
		return null;
	}

}