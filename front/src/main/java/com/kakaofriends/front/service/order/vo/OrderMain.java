package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.core.common.configuration.persistence.type.*;
import com.kakaofriends.front.common.constants.Usable;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * OrderMain : 주문 주 정보
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Data
public class OrderMain {
    private Long sequence;
    private String orderNumber;
    private String pgTid;
    private String memberId;
    private String memberName;

    // 할인액
    private BigDecimal couponMoney;
    private BigDecimal pointMoney;

    // 실제로 결제한 금액의 총액
    private BigDecimal accountMoney;
    private BigDecimal cardMoney;
    private BigDecimal kakaoMoney;
    private BigDecimal paypalMoney;

    private BigDecimal deliveryMoney;

    private OrderStatusType status;
    private DeliveryType deliveryType;
    private Usable deliveryMoneyUse;
    private String deliveryMemo;
    private OrderAccessType accessType;
    private DeliInOutType deliveryInOutType;

    private String modifiedId;
    private String insertedId;
    private LocalDateTime modifiedDate;
    private LocalDateTime insertedDate;

    private PayType payType;

    private BigDecimal exchangeRate; // default 1

    @Deprecated
    private String paypalSaleId;
    private String language;
    private String referer; // 유입경로

    public OrderMain() {
        this.couponMoney = new BigDecimal(0);
        this.pointMoney = new BigDecimal(0);
        this.accountMoney = new BigDecimal(0);
        this.cardMoney = new BigDecimal(0);
        this.kakaoMoney = new BigDecimal(0);
        this.paypalMoney = new BigDecimal(0);
        this.deliveryMoney = new BigDecimal(0);
        this.exchangeRate = new BigDecimal(1);
    }

    /**
     * 주문 시 실제로 결제한 금액을 설정한다.
     *
     * @param payType 결제 수단
     * @param price 결제 금액
     */
    public void setOrderMainPrice(PayType payType, BigDecimal price) {
        switch (payType) {
            case ONLY_CARD:
                this.setCardMoney(price);
                break;
            case PAYPAL:
                this.setPaypalMoney(price);
                break;
            case KAKAOPAY:
            case KAKAOPAY_V2:
                this.setKakaoMoney(price);
                break;
        }
    }

    /**
     * Paytype 에 따라 알맞는 주문 금액을 반환한다.
     *
     * @return 주문 결제 금액
     */
    public BigDecimal getPrice() {
        switch (this.payType) {
            case KAKAOPAY_V2:
            case KAKAOPAY:
                return this.getKakaoMoney();
            case ONLY_CARD:
                return this.getCardMoney();
            case PAYPAL:
                return this.getPaypalMoney();
            default:
                return this.getCardMoney();
        }
    }

    public Usable getDeliveryMoneyUse() {
        if (deliveryMoney.compareTo(BigDecimal.ZERO) > 0 ) {
            return Usable.USE;
        }
        return Usable.NOT_USE;
    }
}
