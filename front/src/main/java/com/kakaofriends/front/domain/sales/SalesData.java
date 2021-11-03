package com.kakaofriends.front.domain.sales;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * SalesData
 *
 * Author  april
 * Date    2018. 1. 4.
 */
@Data
public class SalesData {
    private Long ssSeq;
    private String ssOmNum;
    private Integer ssOsSerial;
    private String ssScpCode;
    private String ssBcpCode;
    private String ssMbId;
    private BigDecimal ssCardMoney;
    private BigDecimal ssKakaoMoney;
    private BigDecimal ssPhoneMoney;
    private BigDecimal ssCouponMoney;
    private BigDecimal ssLaterMoney;
    private BigDecimal ssBudgetMoney;
    private BigDecimal ssSaveMoney;
    private BigDecimal ssPointMoney;
    private BigDecimal ssVirtualAccountMoney;
    private BigDecimal ssOriginalMoney;
    private BigDecimal ssSaleMoney;
    private BigDecimal ssTotOriginalMoney;
    private BigDecimal ssTotSaleMoney;
    private String ssCcNumB;
    private String ssCcNumS;
    private String ssCalculateBUse;
    private String ssCalculateSUse;
    private String ssType;
    private String ssMoId;
    private String ssInId;
    private LocalDateTime ssMoDate;
    private LocalDateTime ssInDate;
    private BigDecimal ssAccountMoney;
    private String ssMoneyUnit;
    private Long ssTxSeq;
    private String ssDpCode;
    private Date ssDuzonDate;
    private String ssDuzonFlag;
    private BigDecimal ssPaypalMoney;
}
