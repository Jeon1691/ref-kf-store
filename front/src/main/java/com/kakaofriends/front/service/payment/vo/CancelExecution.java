package com.kakaofriends.front.service.payment.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * CancelExecution : 취소 실행
 *
 * Author  april
 * Date    2018. 2. 23.
 */
@Data
public class CancelExecution {
    private String tid;
    private BigDecimal price;
    private String currency;
    private String message;
    private CancelType cancelType;

    // 이니시스 필수 값
    private BigDecimal remainPrice;
}
