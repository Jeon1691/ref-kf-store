package com.kakaofriends.core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
	private Long adSeq;
	private String adAddr1;
	private String adAddr2;
	private String adZipcode;
	private String adTel;
	private String adFax;
	private String adPhone;
	private String adEmail;
	private String adOwnerid;
	private String adOwnername;
	private String adZonecode;
	private String adEtc2;
	private String adEtc3;
	private String adEtc4;
	private String adEtc5;
	private String adEtc6;
	private String adLevel;
	private String adType;
	private String adUse;
	private String adMoid;
	private String adInid;
	private Date adModate;
	private Date adIndate;
}