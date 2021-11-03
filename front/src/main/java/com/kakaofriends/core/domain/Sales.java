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
@Deprecated
public class Sales {
    private Long ssSeq;
    private String ssOmNum;
    private Integer ssOsSerial;
    private String ssScpCode;
    private String ssBcpCode;
    private String ssMbId;
    private Integer ssCardMoney;
    private Integer ssKakaoMoney;
    private Integer ssPhoneMoney;
    private Integer ssCouponMoney;
    private Integer ssLaterMoney;
    private Integer ssBudgetMoney;
    private Integer ssSaveMoney;
    private Integer ssPointMoney;
    private Integer ssVirtualAccountMoney;
    private Integer ssOriginalMoney;
    private Integer ssSaleMoney;
    private Integer ssTotOriginalMoney;
    private Integer ssTotSaleMoney;
    private String ssCcNumB;
    private String ssCcNumS;
    private String ssCalculateBUse;
    private String ssCalculateSUse;
    private String ssType;
    private String ssMoId;
    private String ssInId;
    private Date ssMoDate;
    private Date ssInDate;
    private Integer ssAccountMoney;
    private String ssMoneyUnit;
    private Long ssTxSeq;
    private String ssDpCode;
    private Date ssDuzonDate;
    private String ssDuzonFlag;
}