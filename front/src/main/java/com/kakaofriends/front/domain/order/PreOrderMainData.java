package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * PreOrderMainData : DAO of TB_KRO_ORDER_MAIN table
 *
 * Author  april
 * Date    2018. 3. 16.
 */
@Data
public class PreOrderMainData {
    private String orderId;
    private Boolean use;
    private String pgTid;
    private String memberId;
    private String memberName;
    private String paymentType;
    private String paymentStatus;
    private BigDecimal paymentAmount;
    private BigDecimal couponAmount;
    private BigDecimal pointAmount;
    private BigDecimal deliveryAmount;
    private String currency;
    private BigDecimal exchangeRate;
    private Boolean domestic;
    private String couponCodes;
    private String deliveryMemo;
    private String deliveryType;
    private String accessType;
    private String language;
    private String createId;
    private String updateId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void setCouponCodes(String couponCodes) {
        this.couponCodes = couponCodes;
    }

    public void setCouponCodes(List<String> couponCodeList) {
        if (couponCodeList != null && !couponCodeList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < couponCodeList.size(); i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(couponCodeList.get(i));
            }
            this.couponCodes = stringBuilder.toString();
        } else {
            this.couponCodes = null;
        }
    }
}