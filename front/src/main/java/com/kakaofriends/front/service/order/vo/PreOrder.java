package com.kakaofriends.front.service.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * PreOrder
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Data
@AllArgsConstructor
public class PreOrder {
    private PreOrderMain orderMain;
    private List<PreOrderSub> orderSubList;
    private PreOrderAddress orderAddress;

    public void setOrderNumber(String orderNumber) {
        this.orderMain.setOrderNumber(orderNumber);
        this.orderAddress.setOrderNumber(orderNumber);
        for (PreOrderSub orderSub : this.orderSubList) {
            orderSub.setOrderNumber(orderNumber);
        }
    }
}
