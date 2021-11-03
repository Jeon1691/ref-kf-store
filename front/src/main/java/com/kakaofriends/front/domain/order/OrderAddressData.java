package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 주문 주소 정보에 대한 DAO
 */
@Data
public class OrderAddressData {
	private String oaSeq;
	private String oaOmNum;
	private String oaName;
	private String oaAddr1;
	private String oaAddr2;
	private String oaAddr3;
	private String oaCountryCode;
	private String oaCountryName;
	private String oaPhone;
	private String oaEmail;
	private String oaType;
	private String oaZoneCode;
	private String oaZipCode;
	private String oaDeliMemo;
	private String oaUse;
	private String oaMoId;
	private String oaInId;
	private LocalDateTime oaMoDate;
	private LocalDateTime oaInDate;

	private String oaOrdererTel;
	private String oaOrdererEmail;
	private String oaAddressType;

	private String oaBuyerName;
	private String oaBuyerPhone;
	private String oaBuyerEmail;
	private String oaBuyerCountryCode;
	private String oaBuyerCountryName;
}
