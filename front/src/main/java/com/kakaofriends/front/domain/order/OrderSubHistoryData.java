package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * OrderSubHistoryData 주문 상세 이력에 대한 DAO
 *
 * Author  april
 * Date    2017. 12. 20.
 */
@Data
public class OrderSubHistoryData {
    private Long oshSeq;
    private String oshOmNum;
    private Integer oshOsSerial;
    private String oshMemo;
    private Integer oshOsStatus;
    private String oshMoId;
    private String oshInId;
    private LocalDateTime oshMoDate;
    private LocalDateTime oshInDate;
    /*
     현재 사용하지 않음
    private String oshLevel;
    private String oshType;
    private String oshUse;
     */
}