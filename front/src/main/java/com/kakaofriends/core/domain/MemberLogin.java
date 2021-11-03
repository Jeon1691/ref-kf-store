package com.kakaofriends.core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberLogin {
	private Short mblSeq;
	private String mblMbId;
	private String mblEtc1;
	private String mblEtc2;
	private String mblEtc3;
	private String mblStatus;
	private String mblType;
	private String mblUse;
	private String mblInId;
	private Date mblIndate;
}