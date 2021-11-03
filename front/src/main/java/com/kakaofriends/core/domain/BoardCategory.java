package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCategory {
	private Long bdcSeq;
	private Long bdcBdseq;
	private String bdcName;
	private String bdcEname;
	private String bdcCname;
	private String bdcEtc3;
	private String bdcEtc4;
	private String bdcEtc5;
	private String bdcEtc6;
	private String bdcLevel;
	private String bdcType;
	private String bdcUse;
	private String bdcMoid;
	private String bdcInid;
	private Date bdcModate;
	private Date bdcIndate;
}