package com.kakaofriends.front.service.product.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductCategory {
    private Long sequence;
    private String productCode;
    private Long categorySequence;
    private String modifiedId;
    private String insertedId;
    private LocalDateTime modifiedDate;
    private LocalDateTime insertedDate;
}