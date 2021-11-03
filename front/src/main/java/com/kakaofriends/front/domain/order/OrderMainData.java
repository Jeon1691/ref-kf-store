package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 주문 주요 정보에 대한 DAO
 */
@Data
public class OrderMainData {
	private Long omSeq;
	private String omNum;
	private String omPgtId;
	private String omOwnerId;
	private String omOwnerName;
	private BigDecimal omAccountMoney;
	private BigDecimal omCouponMoney;
	private BigDecimal omCardMoney;

	private BigDecimal omDeliveryMoney;
	private BigDecimal omPointMoney;
	private BigDecimal omKakaoMoney;
	private BigDecimal omPaypalMoney;

	private Integer omStatus;
	private String omDeliType; // 1 or 6
	private String omDeliMoenyUse; // Y or N
	private String omDeliMemo;
	private String omAccessType;
	private String omDeliInOutType;

	private String omMoId;
	private String omInId;
	private LocalDateTime omMoDate;
	private LocalDateTime omInDate;

	private String omPayType;

	private BigDecimal omExchangeRate; // default 1

	private String omPaypalSaleId;
	private String language;
	private String referer; // 유입경로

	public OrderMainData() {
		this.omAccountMoney = new BigDecimal(0);
		this.omCouponMoney = new BigDecimal(0);
		this.omCardMoney = new BigDecimal(0);
		this.omDeliveryMoney = new BigDecimal(0);
		this.omPointMoney = new BigDecimal(0);
		this.omKakaoMoney = new BigDecimal(0);
		this.omPaypalMoney = new BigDecimal(0);
	}

	/*
	현재 사용하지 않는 컬럼들
		private String omActiveStatus; default 1
		private String omEtc1; default 1
		private String omDeliPayType; default 2
		private String omUse; default 'Y'
		private String omCpPayType; default 1
		private Integer omSaveMoney;
		private float omLaterMoney;
		private float omVirtualAccountMoney;
		private float omOriginalMoney;
		private float omSaleMoney;
		private String omEtc2;
		private String omEtc3;
		private String omEtc4;
		private String omEtc5;
		private String omEtc6;
		private String omLevel;
		private String omType;
		private String omEscrowUse;
		private String omEscrowStatus;
		private String omDepositAccount;
		private String omDepositAccountBank;
		private String omDepositAccountName;
		private String omRefundAccount;
		private String omRefundAccountBank;
		private String omRefundAccountName;
		private String omDeliNum;
		private Short omDeliBoxEa;
		private Short omPccSeq;
		private String omCardType;
		private String omDepositAccountInName;
		private String omDepositAccountInDate;
		private String omDepositAccountInTime;
		private String omCreditCardNum;
		private String omCreditCardCode;
		private String omAccountBankCode;
		private String omActAdminId;
		private String omGiftPrCode;
		private String omGiftPrName;
		private String omGiftPrName1;
		private String omGiftPrName2;
		private String omSendMailYn1;
		private String omSendMailYn2;
		private float omPhoneMoney;
		private String omPhoneNum;
		private String omCoupon;
		private BigDecimal omNewSaveMoney;
	 */
}