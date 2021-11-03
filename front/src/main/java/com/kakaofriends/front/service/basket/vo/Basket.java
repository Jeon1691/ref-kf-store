package com.kakaofriends.front.service.basket.vo;

import com.kakaofriends.front.common.constants.Usable;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Basket : 장바구니
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Data
public class Basket {
    private Long sequence;
    private String memberId;
    private String productCode;
    private String productOption;
    private int ea;

    private Long categorySequence;
    private String type;
    private Usable use;
    private String modifiedId;
    private String insertedId;
    private LocalDateTime modifiedDate;
    private LocalDateTime insertedDate;
    private String direct;

    public Basket() {
        this.use = Usable.USE;
    }
}
