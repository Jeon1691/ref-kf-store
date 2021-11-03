package com.kakaofriends.front.service.product.stock.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * StockHistory
 *
 * Author  april
 * Date    2018. 03. 26.
 */
@Data
public class StockHistory {
    private String id;
    private String orderId;
    private String productId;
    private boolean domestic; //해외 : 0 / 국내 : 1
    private String action;
    private int quantity;
    private String createId;
    private LocalDateTime createDate;

    public static final String NON_MEMBER = "-1";
}