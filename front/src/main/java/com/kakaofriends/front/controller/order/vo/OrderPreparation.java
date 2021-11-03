package com.kakaofriends.front.controller.order.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * OrderPreparation : 주문 준비 request value object
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Data
public class OrderPreparation implements Serializable {
    @NotNull
    private List<Long> basketSequenceList;

    private List<String> giftCardCodeList;

    private BigDecimal pointUsedPrice;

    @NotNull
    private String buyerCountry;
    @NotNull
    private String buyerName;
    @NotNull
    private String buyerEmail;
    @NotNull
    private String buyerPhone;

    @NotNull
    private String receiverCountry;
    @NotNull
    private String receiverName;
    @NotNull
    private String receiverPhone;
    @NotNull
    private String receiverZipCode;

    private String receiverState;
    @NotNull
    private String receiverAddress;
    @NotNull
    private String receiverDetailAddress;
    @NotNull
    private String deliveryMemo;

    @NotNull
    private boolean defaultAddress;

    private boolean saveDefaultAddress;

    //회수비 결제시 필요
    private String orderNumber;
}