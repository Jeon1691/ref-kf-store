package com.kakaofriends.front.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BasketVO
 *
 * Author  layla
 * Date    2018. 01. 10.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasketVO implements Serializable {
    private long basketAccount;
    private double exchangeBasketAccount;

    private long deliveryCharge;
    private long paymentAccount;
    private long paymentAccountNotDeli;
    private double exchangeDeliveryCharge;
    private double exchangePaymentAccount;

    private boolean hasForeigndelin;
    private ArrayList<BoxItem> boxList;
    private String bsSeqList;
    private String paymentDate;
    private List<OrderSheetExpansion> orderSheetExpansions;
    private String ownerId;
    private double totalWeight;

    //complete, shipping
    private boolean isCustomProductFlag;
    private boolean isEventProductFlag;
    private boolean isGlobalOrder;

    private String errMsg;

    private boolean isFreeDelivery;
    private EventDto globalEvent;
}
