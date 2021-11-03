package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import lombok.Data;

import java.util.Date;

@Data
@Deprecated
public class OrderMain {
	private Long omSeq;
	private String omNum;
	private String omPgtId;
	private String omOwnerId;
	private String omOwnerName;
	private int omAccountMoney;
	private Integer omCouponMoney;
	private Integer omSaveMoney;
	private float omCardMoney;
	private float omLaterMoney;
	private float omVirtualAccountMoney;
	private float omOriginalMoney;
	private float omSaleMoney;
	private Integer omNewSaveMoney;
	private Integer omDeliveryMoney;
	private OrderStatusType omStatus;
	private String omActiveStatus;
	private String omEtc1;
	private String omEtc2;
	private String omEtc3;
	private String omEtc4;
	private String omEtc5;
	private String omEtc6;
	private String omLevel;
	private String omType;
	private String omUse;
	private String omCpPayType;
	private String omEscrowUse;
	private String omEscrowStatus;
	private String omDepositAccount;
	private String omDepositAccountBank;
	private String omDepositAccountName;
	private String omRefundAccount;
	private String omRefundAccountBank;
	private String omRefundAccountName;
	private String omDeliType;
	private String omDeliPayType;
	private String omDeliMoenyUse;
	private String omDeliMemo;
	private String omDeliNum;
	private Short omDeliBoxEa;
	private Short omPccSeq;
	private String omAccessType;
	private String omDeliInOutType;
	private String omCardType;
	private String omMoId;
	private String omInId;
	private Date omMoDate;
	private Date omInDate;
	private Integer omPointMoney;
	private String omDepositAccountInName;
	private String omDepositAccountInDate;
	private String omDepositAccountInTime;
	private String omCreditCardNum;
	private String omCreditCardCode;
	private String omAccountBankCode;
	private PayType omPayType;
	private String omActAdminId;
	private String omGiftPrCode;
	private String omGiftPrName;
	private String omGiftPrName1;
	private String omGiftPrName2;
	private String omSendMailYn1;
	private String omSendMailYn2;
	private float omKakaoMoney;
	private float omPhoneMoney;
	private String omPhoneNum;
	private String omCoupon;
	private float omPaypalMoneyUSD;
	private float omPaypalMoney;
	private String omPaypalSaleId;
	private String omPaypalPaymentId;
	private double omExchangeRate = 1;
	private String language;
	private String referer;
	private float omPointPrice;
}