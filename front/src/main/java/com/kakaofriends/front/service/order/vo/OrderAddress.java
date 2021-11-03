package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.service.order.constants.OrderAddressType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 주문 주소 정보에 대한 VO
 */
@Data
public class OrderAddress {
	private String sequence;
	private String orderNumber;
	private String memberId;
	// receiver information
	private Country country;
	private String name;
	private String address1;
	private String address2;
	private String address3;
	private DeliInOutType deliveryType;
	private String zipCode;
	private String phone;
	private String email;
	private String deliveryMemo;
	// buyer information
	private String buyerName;
	private String buyerPhone;
	private String buyerEmail;
	private Country buyerCountry;

	private OrderAddressType type;
	private Usable use;
	private String modifiedId;
	private String insertedId;
	private LocalDateTime modifiedDate;
	private LocalDateTime insertedDate;

	public OrderAddress() {
		this.use = Usable.USE;
	}
}