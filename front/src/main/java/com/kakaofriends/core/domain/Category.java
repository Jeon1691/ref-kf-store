package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	private Long ctSeq;
	private Long ctCode;
	private String ctName;
	private Long ctPcode;
	private Long ctGroupnum1;
	private Long ctGroupnum2;
	private Long ctGroupnum3;
	private Long ctStep;
	private String ctTitleimage;
	private String ctBrseq;
	private Short ctSort;
	private String ctImage1;
	private String ctImage2;
	private String ctImage3;
	private String ctImage4;
	private String ctImage5;
	private String ctImage6;
	private String ctEtc6;
	private Long ctLevel;
	private String ctType;
	private String ctUse;
	private String ctMoid;
	private String ctInid;
	private Date ctModate;
	private Date ctIndate;
	private String ctEname;
	private String ctColor;
}