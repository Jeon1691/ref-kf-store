package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * PreOrderMain : 결제 전 정보를 처리하는 데이터
 *
 * Author  april
 * Date    2018. 3. 16.
 */
@Data
public class PreOrderMain {
    private String orderNumber;
    private Boolean use;
    private String pgTid;
    private String memberId;
    private String memberName;
    private PayType paymentType;
    private PaymentStatus paymentStatus;
    private BigDecimal paymentAmount;
    private BigDecimal couponAmount;
    private BigDecimal pointAmount;
    private BigDecimal deliveryAmount;
    private Currency currency;
    private BigDecimal exchangeRate;
    private Boolean domestic;
    private List<String> couponCodeList;
    private String deliveryMemo;
    private DeliveryType deliveryType;
    private OrderAccessType accessType;
    private String language;
    private String createId;
    private String updateId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public PreOrderMain() {
        this.use = Boolean.TRUE;
        this.paymentStatus = PaymentStatus.PREPARATION;
        this.paymentAmount = BigDecimal.ZERO;
        this.couponAmount = BigDecimal.ZERO;
        this.pointAmount = BigDecimal.ZERO;
        this.deliveryAmount = BigDecimal.ZERO;
        this.exchangeRate = BigDecimal.ONE;
    }

    public Usable getDeliveryMoneyUse() {
        if (deliveryAmount.compareTo(BigDecimal.ZERO) > 0 ) {
            return Usable.USE;
        }
        return Usable.NOT_USE;
    }
}