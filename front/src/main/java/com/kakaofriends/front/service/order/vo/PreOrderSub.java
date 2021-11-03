package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * PreOrderSubData
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Data
public class PreOrderSub {
    private String orderNumber;
    private Integer serial;
    private Boolean use;
    private Integer parentSerial;
    private String pgTid;
    private String productCode;
    private OrderSubType orderType;
    private String memberId;
    private String memberName;
    private PayType paymentType;
    private PaymentStatus paymentStatus;
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
    private Long categorySequence;
    private String cancelReason;
    private String customMessage;
    private BigDecimal exchangeRate;
    private Integer cjFlag;
    private String createId;
    private String updatedId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public PreOrderSub() {
        this.use = Boolean.TRUE;
        this.paymentStatus = PaymentStatus.PREPARATION;
        this.paymentAmount = BigDecimal.ZERO;
        this.couponAmount = BigDecimal.ZERO;
        this.pointAmount = BigDecimal.ZERO;
        this.productAmount = BigDecimal.ZERO;
        this.salesAmount = BigDecimal.ZERO;
        this.totalProductAmount = BigDecimal.ZERO;
        this.totalSalesAmount = BigDecimal.ZERO;
    }
}