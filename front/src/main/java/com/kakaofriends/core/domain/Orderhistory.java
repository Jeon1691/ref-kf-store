package com.kakaofriends.core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Orderhistory {
	private Long ohSeq;
	private String ohOmnum;
	private Short ohOsserial;
	private String ohMemo;
	private Long ohOsstatus;
	private String ohLevel;
	private String ohType;
	private String ohUse;
	private String ohMoid;
	private String ohInid;
	private Date ohModate;
	private Date ohIndate;
}