package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SmsAuth {
    private Long id;

    private String authService;

    private String countryCode;

    private Long memberId;

    private String memberName;

    private String phoneNumber;

    private String authNumber;

    private String result;

    private Date expireDate;

    private Date createDate;
}
