package com.kakaofriends.front.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberAuth {
    private Long id;

    private String authService;

    private String authMethod;

    private int authDepth;

    private String use;

    private String name;

    private String email;

    private String countryCode;

    private String countryNumber;

    private String receiver;

    private String authNumber;

    private String result;

    private LocalDateTime expireDate;

    private LocalDateTime createDate;
}
