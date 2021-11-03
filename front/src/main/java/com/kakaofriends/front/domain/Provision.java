package com.kakaofriends.front.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Provision {
    private String country;                 // 약관 국가

    private String code;                    // 약관 코드

    private int version;                    // version

    private boolean use;                    // 사용여부

    private boolean necessary;              // 필수여부

    private boolean readMore;               // 자세히보기 여부

    private String title;                   // 제목

    private String content;                 // 약관 내용

    private LocalDateTime applicationDate;  // 적용 일시

    private LocalDateTime updateDate;       // 수정 일시

    private LocalDateTime createDate;       // 생성 일시

    private boolean agreement;
}
