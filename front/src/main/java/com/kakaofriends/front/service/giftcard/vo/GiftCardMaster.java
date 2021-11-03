package com.kakaofriends.front.service.giftcard.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * GiftCardMaster
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@Data
public class GiftCardMaster {
    private String code;
    private String name;
    private String description;
    private String descriptionEnglish;
    private int ea;
    private String message;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Short price;
    private GiftCardMasterType type;
    private LocalDateTime insertedDate;
    private LocalDateTime modifiedDate;
    private String insertedId;
    private String modifiedId;
    private LocalDateTime reservedIssueTime;
    private String memo;
    private String level;
    private GiftCardMasterOptionType optionType;
    private String optionValue;
    private String optionCategory;
    private Boolean duplication;

    public boolean isDuplication() {
        return duplication;
    }
}
