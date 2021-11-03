package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Deprecated
public class OrderSub implements Cloneable {
	private Integer osSeq;
	private String osOmNum;
	private Integer osSerial;
	private String osPgtId;
	private String osPrCode;
	private String osScpCode;
	private String osBcpCode;
	private String osBdpCode;
	private String osOwnerId;
	private String osOwnerName;
	private Integer osAccountMoney;
	private Integer osCardMoney;
	private Integer osCouponMoney;
	private Integer osLaterMoney;
	private Integer osBudgetMoney;
	private Integer osSaveMoney;
	private Integer osPointMoney;
	private Integer osVirtualAccountMoney;
	private Integer osSaveMoneyPercentage;
	private Integer osNewSaveMoney;
	private Integer osNewPrSaveMoney;
	private Integer osOriginalMoney;
	private Integer osSaleMoney;
	private Integer osTotOriginalMoney;
	private Integer osTotSaleMoney;
	private Integer osEa;
	private Integer osOutEa;
	private Integer osInEa;
	private Integer osBgiSeq;
	private String osReleaseNum;
	private String osOptionName;
	private String osMemo;
	private String osRefundAccount;
	private String osRefundAccountBank;
	private String osRefundAccountName;
	private String osRefundStatus;
	private String osCpPayType;
	private String osVatUse;
	private String osEscRowUse;
	private String osEscRowStatus;
	private String osPartCancelUse;
	private String osBuyCalculate;
	private String osSupplyCalculate;
	private String osDeliType;
	private String osDeliPayType;
	private String osDeliMoenyUse;
	private String osDeliMemo;
	private String osDeliNum;
	private Integer osDeliBoxEa;
	private Integer osPccSeq;
	private OrderStatusType osStatus;
	private String osEtc1;
	private String osEtc2;
	private String osEtc3;
	private String osEtc4;
	private String osEtc5;
	private String osEtc6;
	private String osLevel;
	private String osType;
	private String osUse;
	private String osMoId;
	private String osInId;
	private Date osMoDate;
	private Date osInDate;
	private String osDepositAccount;
	private String osDepositAccountBank;
	private String osDepositAccountName;
	private String osAccessType;
	private Integer osMinusAccountMoney;
	private Integer osMinusCardMoney;
	private Integer osMinusCouponMoney;
	private Integer osMinusLaterMoney;
	private Integer osMinusBudgetMoney;
	private Integer osMinusSaveMoney;
	private Integer osMinusPointMoney;
	private Integer osMinusVirtualAccountMoney;
	private String osDeliInOutType;
	private String osCardType;
	private String osDepositAccountInName;
	private String osDepositAccountInDate;
	private String osDepositAccountInTime;
	private String osCreditCardNum;
	private String osParentPrCode;
	private Integer osCtSeq;
	private String osCancelReason;
	private String osActAdminId;
	private Integer osKakaoMoney;
	private Integer osPhoneMoney;
	private String osEtc7;
	private Product product;
	private float osPaypalMoneyUSD;
	private float osPaypalMoney;
	private String osPaypalSaleId;
	private String osPaypalPaymentId;
	private double osExchangeRate = 1;
	private double exchangeSaleMoney;
	private double exchangeCouponMoney;
	private double exchangePointMoney;
	private Integer osPrTotCnt;
	private String osPrName;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
