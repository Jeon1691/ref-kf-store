package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * PreOrderSubData : DAO of TB_KFO_ORDER_SUB table
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Data
public class PreOrderSubData {
    private String orderId;
    private Integer serial;
    private Boolean use;
    private Integer parentSerial;
    private String pgTid;
    private String productId;
    private String orderType;
    private String memberId;
    private String memberName;
    private String paymentType;
    private String paymentStatus;
    private BigDecimal paymentAmount;
    private BigDecimal couponAmount;
    private BigDecimal pointAmount;
    private BigDecimal productAmount;
    private BigDecimal salesAmount;
    private Integer quantity;
    private BigDecimal totalProductAmount;
    private BigDecimal totalSalesAmount;
    private Boolean domestic;
    private String deliveryNumber;
    private String memo;
    private Long categoryId;
    private String cancelReason;
    private String customMessage;
    private BigDecimal exchangeRate;
    private Integer cjFlag;
    private String createId;
    private String updatedId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}