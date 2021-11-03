package com.kakaofriends.front.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCancelInfo implements Serializable {
    private OrderInfo orderInfo;
    private int cancelSubmitCnt;
    private int returnSubmitCnt;
    private int exchangeSubmitCnt;
    private int cancelCompleteCnt;
    private int returnCompleteCnt;
    private int exchangeCompleteCnt;
}
