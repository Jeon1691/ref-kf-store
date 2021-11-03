package com.kakaofriends.core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Config {
	private Long cfSeq;
	private String cfId;
	private String cfName;
	private Integer cfValue;
	private String cfEtc1;
	private String cfEtc2;
	private String cfEtc3;
	private String cfEtc4;
	private String cfEtc5;
	private String cfEtc6;
	private String cfLevel;
	private String cfType;
	private String cfUse;
	private String cfMoid;
	private String cfInid;
	private Date cfModate;
	private Date cfIndate;
}