package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by Dave on 2017. 5. 12..
 */

@Data
public class OrderTrackingDetail {
    private String titleDate;
    private List<OrderTracking> orderTrackingList;

    public OrderTrackingDetail(String titleDate, List<OrderTracking> orderTrackingList) {
        this.titleDate = titleDate;
        this.orderTrackingList = orderTrackingList;
    }
}
