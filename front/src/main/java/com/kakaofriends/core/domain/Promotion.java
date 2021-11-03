package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion {
	private Long prmSeq;
	private String prmLanguage;
	private String prmName;
	private String prmImage1;
	private String prmImage2;
	private String prmCommentUse;
	private String prmCheckDay;
	private String prmEtc2;
	private String prmEtc3;
	private String prmEtc4;
	private String prmEtc5;
	private String prmEtc6;
	private String prmLevel;
	private String prmType;
	private String prmUse;
	private String prmMoid;
	private String prmInid;
	private String prmOgTitle;
	private String prmOgImage;
	private Date prmModate;
	private Date prmIndate;
	private String prmSdate;
	private String prmEdate;
	private String prmContent;
}