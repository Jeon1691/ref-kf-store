package com.kakaofriends.front.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * StockData
 *
 * Author  layla
 * Date    2018. 01. 31.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockData {
    private String productId;
    private boolean domestic;
    private int availableStock;
    private int orderStock;
    private int badStock;
    private boolean alert;
    private int alertStock;
    private String updateId;
    private String createId;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;

    private String productName;
}