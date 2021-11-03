package com.kakaofriends.front.domain.basket;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * BasketData : 장바구니 Data access object
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Data
public class BasketData {
    private Long bsSeq;
    private String bsOwnerId;
    private String bsPrCode;
    private String bsPrOption;
    private int bsEa;

    private Long bsCtSeq;
    private String bsType;
    private String bsUse;
    private String bsMoId;
    private String bsInId;
    private LocalDateTime bsMoDate;
    private LocalDateTime bsInDate;
    private String bsDirect;

/*
        현재 사용하지 않음
    private String bsEtc1;
    private String bsEtc2;
    private String bsEtc3;
    private String bsEtc4;
    private String bsLevel;
 */
}
