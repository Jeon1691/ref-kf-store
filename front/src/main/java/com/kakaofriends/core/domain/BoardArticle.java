package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.BoardReplyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardArticle {
	private Long rNum;
	private Long bdaSeq;
	private String bdaBdid;
	private Long bdaBdcseq;
	private String bdaName;
	private String bdaPswd;
	private String bdaFile1;
	private String bdaFile2;
	private String bdaOwnerid;
	private String bdaOwnername;
	private String bdaCpcode;
	private String bdaPhone;
	private String bdaEmail;
	private String bdaReplyyn;
	private Long bdaGroupnum;
	private Long bdaLevelnum;
	private Long bdaStepnum;
	private Integer bdaCmcount;
	private Long bdaStatus;
	private String bdaPrcode;
	private String bdaLanguage;
	private BoardReplyType bdaEtc3;
	private String bdaEtc4;
	private String bdaEtc5;
	private String bdaEtc6;
	private String bdaLevel;
	private String bdaType;
	private String bdaUse;
	private String bdaMoid;
	private String bdaInid;
	private Date bdaModate;
	private Date bdaIndate;
	private String bdaContent;
}