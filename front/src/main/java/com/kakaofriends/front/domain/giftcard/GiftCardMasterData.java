package com.kakaofriends.front.domain.giftcard;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * GiftCardMasterData : DAO of giftCardMaster table
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@Data
public class GiftCardMasterData {
    private String gcmCode;
    private String gcmName;
    private String gcmGoal;
    private int gcmEa;
    private LocalDateTime gcmSDate;
    private LocalDateTime gcmEDate;
    private Short gcmPrice;
    private String gcmType;
    private LocalDateTime gcmInDate;
    private LocalDateTime gcmMoDate;
    private String gcmInId;
    private String gcmMoId;
    private LocalDateTime gcmTime;
    private String gcmMemo;
    private String gcmLevel;
    private String gcmOptionType;
    private String gcmOptionValue;
    private String gcmOptionCategory;
    private String gcmEGoal;
    private String gcmDuplication;

//    사용하지 않음
//    private String gcmMsg;
}
