package com.kakaofriends.front.domain.sales;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by eunduck on 2018. 3. 13..
 */
@Data
public class KfoSalesData {
    private String id;
    private String status;
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
}