package com.kakaofriends.front.domain.product;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductCategoryData {
    private Long prcSeq;
    private String prcPrCode;
    private Long prcCtSeq;
    private String prcMoId;
    private String prcInId;
    private LocalDateTime prcMoDate;
    private LocalDateTime prcInDate;
}