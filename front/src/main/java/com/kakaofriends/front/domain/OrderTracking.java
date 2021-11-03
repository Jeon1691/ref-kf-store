package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dave on 2017. 5. 12..
 */
@Data
public class OrderTracking {
    private String boxPk;
    private String omNum;
    private int boxSeq;
    private String hawbNo;
    private String osStatus;
    private String trackingStatusKr;
    private String trackingStatus;
    private String trackingOrder;
    private Date trackingDate;
    private Date createDate;
    private String itemName;
    private String trackingTime;
}
