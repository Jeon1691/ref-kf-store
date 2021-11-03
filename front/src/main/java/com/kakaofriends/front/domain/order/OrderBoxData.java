package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * OrderBoxData 주문 상자에 대한 DAO
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Data
public class OrderBoxData {
    private String boxPk;
    private String boxOmnum;
    private int boxSeq;
    private LocalDateTime boxCreatedDate;
    private LocalDateTime boxUpdatedDate;
    private int boxSize;
    private BigDecimal boxAmt;
    private int boxStatus;
    private String boxItemName;
}