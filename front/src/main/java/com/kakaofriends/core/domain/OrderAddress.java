package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Deprecated
public class OrderAddress {
	private String oaSeq;
	private String oaOmNum;
	private String oaOsSerial;
	private String oaName;
	private String oaAddr1;
	private String oaAddr2;
	private String oaAddr3;
	private String oaCountryCode;
	private String oaCountryName;
	private String oaPhone;
	private String oaTel;
	private String oaFax;
	private String oaEmail;
	private String oaLevel;
	private String oaZoneCode;
	private String oaZipCode;
	private String oaDeliMemo = "";
	private String oaUse;
	private String oaMoId;
	private String oaInId;
	private Date oaMoDate;
	private Date oaInDate;
	private DeliInOutType oaType;
	private String oaDeliName;
	private String oaOrderErTel;
	private String oaOrderErEmail = "";
	private String userId;
	private String orderNumber;
	private String oaAddressType;

	private String oaBuyerName;
	private String oaBuyerPhone;
	private String oaBuyerEmail;
	private String oaBuyerCountryCode;
	private String oaBuyerCountryName;

    /**
     * 기본 배송지 타입
     */
	public static String OA_DEFAULT_ADDRESS_TYPE = "D";

    /**
     * 신규 배송지 타입
     */
	public static String OA_NEW_ADDRESS_TYPE = "N";
}
