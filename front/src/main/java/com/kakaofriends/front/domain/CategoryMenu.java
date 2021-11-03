package com.kakaofriends.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryMenu {
	private String gnbFriends;
	private String subKey;
	private String contentClass;
	private Long ctSeq;
	private Long ctRoot;
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
	private Long ctNode;
	private String ctParent;
	private String ctChildren;
	private String ctImage3Link;
	private String ctImage3Alt;
	private String ctImage4Link;
	private String ctImage4Alt;

	public List<String> getCtChidrenList() {
		return Arrays.asList(getCtChildren().split(","));
	}
}