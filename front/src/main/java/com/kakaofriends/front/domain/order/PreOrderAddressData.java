package com.kakaofriends.front.domain.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * PreOrderAddressData : DAO of TB_KFO_ORDER_ADDRESS table
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Data
public class PreOrderAddressData {
    private String orderId;
    private Boolean use;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String zipCode;
    private String phone;
    private String email;
    private String country;
    private Boolean domestic;
    private String deliveryMemo;
    private String buyerName;
    private String buyerPhone;
    private String buyerEmail;
    private String buyerCountry;
    private String addressType;
    private String createId;
    private String updateId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}