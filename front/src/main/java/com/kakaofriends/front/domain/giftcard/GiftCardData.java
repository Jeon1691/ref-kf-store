package com.kakaofriends.front.domain.giftcard;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GiftCardData : DAO of giftCard table
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@Data
public class GiftCardData {
    private String gcGcmCode;
    private String gcCode;
    private BigDecimal gcPrice;
    private LocalDateTime gcSDate;
    private LocalDateTime gcEDate;
    private String gcPhone;
    private String gcUse;
    private int gcExtCnt;
    private String gcName;
    private String gcEmail;
    private LocalDateTime gcUseDate;
    private LocalDateTime gcInDate;
    private LocalDateTime gcMoDate;
    private String gcInId;
    private String gcMoId;
    private String gcOmNum;
    private String gcCal;
    private String gcReason;
    private int gcResetCnt;
    private LocalDateTime gcExtDate;
    private LocalDateTime gcStopDate;
    private String gcUserId;

    /*
        사용하지 않음
    private int gcMmsCnt;
    private LocalDateTime gcRegistDate;
     */
}