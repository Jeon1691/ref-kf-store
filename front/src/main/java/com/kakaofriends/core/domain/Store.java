package com.kakaofriends.core.domain;


import com.kakaofriends.core.common.configuration.persistence.type.BusinessDayType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Store {
	private Long stSeq;
	private String stCode;
	private String stName;
	private String stUse;
	private String stImg;
	private String stSimg;
	private String stImg1;
	private String stImg2;
	private String stImg3;
	private String stImg4;
	private String stImg5;
	private String stImg6;
	private String stMbname;
	private String stMbphone;
	private String stTel;
	private String stFax;
	private String stAddr1;
	private String stAddr2;
	private String stZipcode;
	private String stZonecode;
	private String stMapx;
	private String stMapy;
	private String stMapaddr;
	private BusinessDayType stDay;
	private String stOpentime;
	private String stClosetime;
	private String stHoliday;
	private String stArea;
	private String stGungu;
	private String stDong;
	private String stUrl;
	private String stStpe;
	private String stInfo;
	private Timestamp stModate;
	private Timestamp stIndate;
	private StoreArea storeArea;
}