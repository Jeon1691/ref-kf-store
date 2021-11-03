package com.kakaofriends.front.controller.order.vo;

import lombok.Data;

/**
 * InicisPayment
 *
 * Author  april
 * Date    2018. 1. 16.
 */
@Data
public class InicisPayment {
    private String uid;
    private String ini_certid;
    private String buyername;
    private String buyertel;
    private String buyeremail;
    private String cardcode;
    private String paymethod;
    private String encrypted;
    private String sessionkey;
}
