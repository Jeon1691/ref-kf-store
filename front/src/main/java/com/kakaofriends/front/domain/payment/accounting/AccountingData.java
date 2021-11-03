package com.kakaofriends.front.domain.payment.accounting;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * AccountingData : DAO OF TB_KFO_ACCOUNTING table
 *
 * Author  april
 * Date    2018. 3. 9.
 */
@Data
public class AccountingData {
    private String id;
    private String orderId;
    private int orderSerial;
    private Boolean domestic;
    private String action;
    private String productId;
    private int quantity;
    private BigDecimal price;
    private String currency;
    private String paymentMethod;
    private BigDecimal paymentAmount;
    private BigDecimal point;
    private BigDecimal coupon;
    private LocalDateTime createDate;
}