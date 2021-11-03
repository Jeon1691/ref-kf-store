package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import lombok.Data;

import java.util.Date;

@Data
public class Banner {
	private Long bnSeq;
	private String bnLanguage;
	private String bnOwnerid;
	private String bnImage;
	private String bnArea;
	private BannerType bnAreaType;
	private String bnOrder;
	private String bnArea2order;
	private String bnLink;
	private String bnLinkUse;
	private String bnAlt;
	private String bnTarget;
	private String bnType;
	private String bnUse;
	private String bnMoid;
	private String bnInid;
	private Date bnModate;
	private Date bnIndate;
	private String bnTitle;
    private String bnSubTitle;
	private String bnInfo;
	private String bnColor;
}