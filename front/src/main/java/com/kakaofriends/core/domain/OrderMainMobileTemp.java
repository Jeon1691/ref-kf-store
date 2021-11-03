package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderMainMobileTemp {
	private Long ommtSeq;
	private String ommtNum;
	private String ommtPgtid;
	private String ommtOwnerid;
	private String ommtOwnername;
	private BigDecimal ommtAccountmoney;
	private Long ommtCouponmoney;
	private Long ommtSavemoney;
	private BigDecimal ommtCardmoney;
	private BigDecimal ommtLatermoney;
	private BigDecimal ommtVirtualaccountmoney;
	private BigDecimal ommtOriginalmoney;
	private BigDecimal ommtSalemoney;
	private Long ommtNewsavemoney;
	private BigDecimal ommtDeliverymoney;
	private Long ommtStatus;
	private String ommtActivestatus;
	private String ommtEtc1;
	private String ommtEtc2;
	private String ommtEtc3;
	private String ommtEtc4;
	private String ommtEtc5;
	private String ommtEtc6;
	private String ommtLevel;
	private String ommtType;
	private String ommtUse;
	private String ommtCppaytype;
	private String ommtEscrowuse;
	private String ommtEscrowstatus;
	private String ommtDepositaccount;
	private String ommtDepositaccountbank;
	private String ommtDepositaccountname;
	private String ommtRefundaccount;
	private String ommtRefundaccountbank;
	private String ommtRefundaccountname;
	private String ommtDelitype;
	private String ommtDelipaytype;
	private String ommtDelimoenyuse;
	private String ommtDelimemo;
	private String ommtDelinum;
	private Short ommtDeliboxea;
	private Short ommtPccseq;
	private String ommtAccesstype;
	private String ommtDeliinouttype;
	private String ommtCardtype;
	private String ommtMoid;
	private String ommtInid;
	private Date ommtModate;
	private Date ommtIndate;
	private Long ommtPointmoney;
	private String ommtDepositaccountinname;
	private String ommtDepositaccountindate;
	private String ommtDepositaccountintime;
	private String ommtCreditcardnum;
	private String ommtCreditcardcode;
	private String ommtAccountbankcode;
	private String ommtPaytype;
	private String ommtActadminid;
	private String ommtGiftprcode;
	private String ommtGiftprname;
	private String ommtGiftprname1;
	private String ommtGiftprname2;
	private String ommtSendmailyn1;
	private String ommtSendmailyn2;
	private BigDecimal ommtKakaomoney;
	private BigDecimal ommtPhonemoney;
	private String ommtPhonenum;
	private String ommtCoupon;
}