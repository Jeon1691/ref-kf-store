package com.kakaofriends.front.domain.product;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * StockHistoryData
 * DAO of tb_kfo_stock_history table
 *
 * Author  layla
 * Date    2018. 02. 22.
 */
@Data
public class StockHistoryData {
    private String id;
    private String orderId;
    private String productId;
    private boolean domestic; //해외 : 0 / 국내 : 1
    private String action;
    private int quantity;
    private String createId;
    private LocalDateTime createDate;
}