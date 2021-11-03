package com.kakaofriends.front.service.sales.vo;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.service.sales.constants.SalesStatus;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by eunduck on 2018. 3. 13..
 */
@Data
public class KfoSales {
    private String id;
    private SalesStatus status;
    private String orderNumber;
    private int orderSerial;
    private Boolean domestic;
    private PaymentAction paymentAction;
    private String productCode;
    private int quantity;
    private BigDecimal price;
    private Currency currency;
    private PayType paymentMethod;
    private BigDecimal paymentAmount;
    private BigDecimal pointAmount;
    private BigDecimal couponAmount;
}