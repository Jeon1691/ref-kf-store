package com.kakaofriends.core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ProductOption {
	private Long proSeq;
	private String proPrcode;
	private String proPrcodearr;
	private String proName;
	private String proValue;
	private String proEtc1;
	private String proEtc2;
	private String proEtc3;
	private String proEtc4;
	private String proEtc5;
	private String proEtc6;
	private String proLevel;
	private String proType;
	private String proUse;
	private String proMoid;
	private String proInid;
	private Date proModate;
	private Date proIndate;
}