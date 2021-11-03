package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo implements Serializable {
    private String omNum;
    private String omPgtId;
    private String omOwnerId;
    private Date omInDate;
    private PayType omPayType;
    private OrderAccessType omAccessType;
    private int omCardMoney;
    private int omAccountMoney;
    private int omKakaoMoney;
    private int omPaypalMoney;
    private int totalMoney;
    private int omCouponMoney;
    private int omDeliveryMoney;
    private String omDeliMoneyUse;
    private String omDeliNum;
    private String prName;
    private String prName1;
    private String prImage1;
    private String prImage12;
    private int orderSubPrTotCnt;
    private double exchangeItemsMoney;
    private double exchangeCouponMoney;
    private double exchangeDeliveryMoney;
    private int omPointMoney;
    private double exchangePointMoney;
    private String omDeliinoutType;

    public double getCompleteExchangeProdAmountCharge() {
        double exchangeProdAmountCharge = totalMoney + omCouponMoney + omPointMoney + omDeliveryMoney;
        return (double) exchangeProdAmountCharge;
    }
    public double getCompleteExchangeDiscountMoney() {
        int exchangeDiscountMoney = omCouponMoney + omPointMoney;
        return (double) exchangeDiscountMoney;
    }
    public double getCompleteExchangeDeliveryMoney() {
        return (double) omDeliveryMoney;
    }
    public double getCompleteExchangeTotalMoney() {
        return (double) totalMoney;
    }
}
