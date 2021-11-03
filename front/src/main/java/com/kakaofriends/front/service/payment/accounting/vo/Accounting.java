package com.kakaofriends.front.service.payment.accounting.vo;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Accounting
 *
 * Author  april
 * Date    2018. 3. 9.
 */
@Data
public class Accounting {
    private String id;
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
    private LocalDateTime createDate;

    public static final String DELIVERY_PRODUCT_CODE = "DELIVERY";
    public static final String RETURN_DELIVERY_PRODUCT_CODE = "RETURN_DELIVERY";

    public Accounting() {
        this.price = new BigDecimal(0);
        this.paymentAmount = new BigDecimal(0);
        this.pointAmount = new BigDecimal(0);
        this.couponAmount = new BigDecimal(0);
    }
}