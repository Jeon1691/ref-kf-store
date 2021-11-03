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
public class Member {
	private String mbId;
	private Long mbSeq;
	private String mbName;
	private String mbPswd;
	private String mbCpcode;
	private String mbDpcode;
	private String mbJumin1;
	private String mbJumin2;
	private String mbIpin;
	private String mbCompanyname;
	private String mbBiznum;
	private String mbTongsinbiznum;
	private String mbUptai;
	private String mbUpjong;
	private String mbCeoname;
	private String mbPosition;
	private String mbApprovalid1;
	private String mbApprovalid2;
	private String mbBankname;
	private String mbAccountholder;
	private String mbAccountnumber;
	private String mbAdminmemo;
	private String mbBirth;
	private String mbRecommender;
	private String mbLoginip;
	private Long mbSavemoney;
	private Long mbPointmoney;
	private String mbBelong;
	private String mbBuytype;
	private String mbYeartype;
	private String mbEmailuse;
	private String mbSmsuse;
	private Long mbLoginfailcount;
	private Date mbPswddate;
	private Date mbLogindate;
	private String mbBiztype;
	private String mbEtc1;
	private String mbEtc2;
	private String mbEtc3;
	private String mbEtc4;
	private String mbEtc5;
	private String mbEtc6;
	private String mbLevel;
	private String mbType;
	private String mbUse;
	private String mbMoid;
	private String mbInid;
	private Date mbModate;
	private Date mbIndate;
	private String mbSavetype;
	private String mbAdtype;
	private String mbWorktype;
	private String mbOutlookname;
	private String mbRealdpname;
	private String mbFirstidnumber;
	private String mbCurrentidnumber;
	private String mbPositioncode;
	private String mbUpdatedate;
	private String mbEtc;
	private String mbEnfirstname;
	private String mbEnlastname;
	private String mbCnname;
	private String mbStartdate;
	private String mbEnddate;
	private String mbAdregister;
	private String mbWebdropuse;
	private String mbFirstloginuse;
	private String mbRealcpcode;
	private String mbRealdpcode;
	private String mbRealcpname;
	private String mbAduse;
	private Long mbLoginsuccesscount;
	private String mbRefundaccountcode;
	private String mbRefundaccountname;
	private String mbRefundaccount;
	private String mbRefundaccountusername;
	private String mbAmtype;
	private Date mbLevelindate;
	private String mbPrelevel;
	private Date mbPrelevelindate;
	private String mbSalesmember;
	private String mbProfileImage;
}