package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 주문 상세 정보에 대한 DAO : ORDERSUB Table
 */
@Data
public class OrderSubData {
	private Long osSeq;
	private String osOmNum;
	private Integer osSerial;
	private String osPgtId;
	private String osPrCode;
	private String osScpCode;
	private String osBcpCode;
	private String osBdpCode;
	private String osOwnerId;
	private String osOwnerName;
	private BigDecimal osAccountMoney;
	private BigDecimal osCardMoney;
	private BigDecimal osCouponMoney;
	private BigDecimal osPointMoney;

	private BigDecimal osOriginalMoney;
	private BigDecimal osSaleMoney;
	private BigDecimal osTotOriginalMoney;
	private BigDecimal osTotSaleMoney;
	private BigDecimal osKakaoMoney;
	private BigDecimal osPaypalMoney;

	private int osEa;
	private int osOutEa;
	private int osInEa;
	private String osMemo;
	private String osDeliType;
	private String osDeliMoenyUse;
	private String osDeliMemo;
	private String osDeliNum;
	private Integer osPccSeq;
	private int osStatus;
	private String osEtc3;
	private String osType;
	private String osUse;
	private String osMoId;
	private String osInId;
	private LocalDateTime osMoDate;
	private LocalDateTime osInDate;
	private String osAccessType;
	private String osDeliInOutType;
	private Long osCtSeq;
	private String osCancelReason;

	private String osEtc7;
	private BigDecimal osExchangeRate;
	private String osPaypalSaleId;
	private Integer osCjFlag;

	public OrderSubData() {
		this.osAccountMoney = BigDecimal.ZERO;
		this.osCardMoney = BigDecimal.ZERO;
		this.osCouponMoney = BigDecimal.ZERO;
		this.osPointMoney = BigDecimal.ZERO;
		this.osOriginalMoney = BigDecimal.ZERO;
		this.osSaleMoney = BigDecimal.ZERO;
		this.osTotOriginalMoney = BigDecimal.ZERO;
		this.osTotSaleMoney = BigDecimal.ZERO;
		this.osKakaoMoney = BigDecimal.ZERO;
		this.osPaypalMoney = BigDecimal.ZERO;
	}

	/*
		  현재 사용하지 않음
	private Integer osLaterMoney;
	private Integer osBudgetMoney;
	private Integer osSaveMoney;
	private Integer osVirtualAccountMoney;
	private Integer osSaveMoneyPercentage;
	private Integer osNewPrSaveMoney;
	private Integer osBgiSeq;
	private String osReleaseNum;
	private String osOptionName;
	private String osRefundAccount;
	private String osRefundAccountBank;
	private String osRefundAccountName;
	private String osRefundStatus; default 2
	private String osCpPayType; default 1
	private String osVatUse;
	private String osEscRowUse;
	private String osEscRowStatus;
	private String osPartCancelUse;
	private String osBuyCalculate; default 'N'
	private String osSupplyCalculate; default 'N'
	private String osDeliPayType; default 2
	private Integer osDeliBoxEa;
	private String osEtc1;
	private String osEtc2;
	private String osEtc4;
	private String osEtc5;
	private String osEtc6;
	private String osLevel;
	private String osDepositAccount;
	private String osDepositAccountBank;
	private String osDepositAccountName;
	private Integer osMinusAccountMoney;
	private Integer osMinusCardMoney;
	private Integer osMinusCouponMoney;
	private Integer osMinusLaterMoney;
	private Integer osMinusBudgetMoney;
	private Integer osMinusSaveMoney;
	private Integer osMinusPointMoney;
	private Integer osMinusVirtualAccountMoney;
	private String osCardType;
	private String osDepositAccountInName;
	private String osDepositAccountInDate;
	private String osDepositAccountInTime;
	private String osCreditCardNum;
	private String osParentPrCode;
	private String osActAdminId;
	private Integer osPhoneMoney;
	private BigDecimal osNewSaveMoney;
	 */
}