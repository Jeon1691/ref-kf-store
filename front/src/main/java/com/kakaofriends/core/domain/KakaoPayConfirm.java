package com.kakaofriends.core.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class KakaoPayConfirm {
	private Long kpcSeq;
	private String kpcNum;
	private String kpcType;
	private String kpcSpu1;
	private String kpcSpu2;
	private String kpcSpuSignToken1;
	private String kpcSpuSignToken2;
	private String kpcMpayPub1;
	private String kpcMpayPub2;
	private String kpcNonrepToken1;
	private String kpcNonrepToken2;
	private String kpcEtc1;
	private String kpcEtc2;
	private String kpcEtc3;
	private String kpcInId;
	private Date kpcIndate;
}