package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Deprecated
public class Basket {
	private Long bsSeq;
	@JsonIgnore private String bsOwnerId;
	private String bsPrCode;
	private String bsPrOption;
	private Long bsEa;
	private String bsEtc1;
	private String bsEtc2;
	private String bsEtc3;
	private String bsEtc4;
	private String bsEtc5;
	private Long bsCtSeq;
	private String bsLevel;
	private String bsType;
	private String bsUse = "Y";
	private String bsMoid;
	private String bsInid;
	private Date bsModate;
	private Date bsIndate;
	private String bsDirect = "N";
	private Long displayGoodsId; //2018.08.22 전시상품ID 추가
	private String addonType;	//2018.08.30 추가

	private boolean isGiftBag; //2018.01.16 추가

	private String oaCountryCode;
}