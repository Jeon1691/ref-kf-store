package com.kakaofriends.front.service.product.stock.vo;

import com.kakaofriends.front.domain.order.OrderAction;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Stock
 *
 * Author  layla
 * Date    2018. 02. 27.
 */
@Data
public class Stock {
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
    private String orderNumber;
    private String memberId;
    private OrderAction orderAction;

}