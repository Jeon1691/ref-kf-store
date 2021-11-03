package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.ProductDisplayType;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDisplay {
	private Long prdSeq;
	private String prdOwnerid;
	private String prdPrcode;
	private Long prdEtc1;
	private String prdEtc2;
	private String prdEtc3;
	private String prdEtc4;
	private String prdEtc5;
	private String prdEtc6;
	private String prdLevel;
	private ProductDisplayType prdType;
	private String prdUse;
	private String prdMoid;
	private String prdInid;
	private Date prdModate;
	private Date prdIndate;
}