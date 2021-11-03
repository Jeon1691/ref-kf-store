package com.kakaofriends.front.domain.giftcard;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GiftCardData : DAO of TB_KFO_MBS_COUPON_HISTORY table
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@Data
public class CouponHistoryData {
    private Long cphSeq;
    private Long cphUserId;
    private String cphGcmCode;
    private String cphCode;
    private BigDecimal cphPrice;
    private LocalDateTime cphSDate;
    private LocalDateTime cphEDate;
    private String cphUse;
    private LocalDateTime cphUseDate;
    private String cphOmNum;
    private String cphType;
    private String cphLevel;
    private String cphOptionType;
    private String cphOptionValue;
    private String cphName;
    private String cphEName;
    private Long cphOptionCategory;
    private String cphTitle;
    private String cphDuplication;
    private LocalDateTime regDttm;
    private LocalDateTime updDttm;
    private String regUser;
    private String updUser;
}