package com.kakaofriends.front.service.giftcard.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GiftCard
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@Data
public class GiftCard {
    private String code;
    private String giftCardMasterCode;
    private BigDecimal price;

    private GiftCardStatus status;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String orderNumber;
    private LocalDateTime usedDate;

    private Long memberId;
    private String memberPhone;
    private String memberName;
    private String memberEmail;

    private String calculateStatus;
    private int resetCount;
    private int extensionCount;
    private LocalDateTime extensionDate;
    private LocalDateTime stopDate;
    private String stopReason;

    private LocalDateTime insertedDate;
    private LocalDateTime modifiedDate;
    private String insertedId;
    private String modifiedId;

    private GiftCardMaster giftCardMaster;
}
