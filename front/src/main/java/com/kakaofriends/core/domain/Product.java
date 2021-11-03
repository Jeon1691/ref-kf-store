package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class Product {
	private Long prSeq;
	private String prCode;
	private String prbPrCode;
	private String prsPrCode;
	private String prName;
	private String prName1;
	private String prName2;
	private String prScpType;
	private String prScpCode;
	private String prBundleprcode;
	private String prItemname1;
	private String prItemname2;
	private String prItemname3;
	private String prStockcode;
	private String prBarcode;
	private String prEtccode1;
	private String prEtccode2;
	private String prVatYn;
	private String prViewType;
	private Long prSavemoney;
	private String prStandard;
	private String prStandard1;
	private String prStandard2;
	private String prBrseq;
	private String prModel;
	private String prUnit;
	private String prUnitea;
	private String prManufacture;
	private String prCountry;
	private Integer prMinbuyea;
	private Integer prSaleavea;
	private String prBuyeamulti;
	private Long prStock;
	private String prForeigndeliyn;
	private Integer prVolume1;
	private Integer prVolume2;
	private Integer prVolume3;
	private double prWeight;
	private String prPcpcode1;
	private String prPcpcode2;
	private String prPcpcode3;
	private String prPcpcode4;
	private String prLcpcode1;
	private String prLcpcode2;
	private String prLcpcode3;
	private String prLcpcode4;
	private Short prDeliterm;
	private String prFreebieprcode;
	private String prAsname;
	private String prAsphone;
	private String prDelimemo;
	private String prColor;
	private String prImage1;
	private String prImage2;
	private String prImage3;
	private String prImage4;
	private String prImage5;
	private String prImage6;
	private String prImage7;
	private String prImage8;
	private String prImage9;
	private String prImage10;
	private String prImage11;
	private String prImage12;
	private String prInfo;
	private String prInfo1;
	private String prInfo2;
	private String prView1;
	private String prView2;
	private String prView3;
	private String prView4;
	private String prView5;
	private String prView6;
	private String prContent;
	private String prContent1;
	private String prContent2;
	private String prDelipolicy;
	private String prSearchword;
	private String prTimeSalesDate;
	private String prTimeSaleeDate;
	private Integer prBuyea1;
	private Integer prBuyea2;
	private Integer prBuyea3;
	private Short prStatus;
	private String prDiscountsDate;
	private String prDiscounteDate;
	private String prNew;
	private String prHot;
	private Long prOrder;
	private String prKrview;
	private String prEnview;
	private String prChview;
	private String prEtc6;
	private String prLevel;
	private String prType;
	private String prUse;
	private String prMoid;
	private String prInid;
	private Date prModate;
	private Date prIndate;
	private String prSetea;
	private String prSetprice;
	private String prSetprcode;
	private String prSetprname;
	private double prHeight;
	private double prWidth;
	private double prDepth;

	//캐릭터별추천상품조회용
	private Long recSeq;
	private String categoryCode;
	private int ordernum;

	private Long ctCode;

	private String defaultPrcode; //2018.08.24 전시상품의 대표상품코드
}
