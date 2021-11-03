package com.kakaofriends.front.service.giftcard.history.vo;

import com.kakaofriends.front.service.giftcard.vo.GiftCardMasterOptionType;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMasterType;
import com.kakaofriends.front.service.giftcard.vo.GiftCardStatus;
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
public class GiftCardHistory {
    private Long sequence;
    private Long memberId;
    private String giftCardMasterCode;
    private String giftCardCode;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private GiftCardStatus status;
    private LocalDateTime usedDate;
    private String orderNumber;
    private GiftCardMasterType type;
    private String level;
    private GiftCardMasterOptionType optionType;
    private String optionValue;
    private String name;
    private String nameEnglish;
    private Long optionCategory;
    private String title;
    private boolean duplication;
    private LocalDateTime registeredDate;
    private LocalDateTime updatedDate;
    private String registeredId;
    private String updatedId;
}