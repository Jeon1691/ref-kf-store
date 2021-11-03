package com.kakaofriends.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvisionAgreement {
    private Long memberId;                  // 회원번호

    private String provisionCountry;        // 약관 국가

    private String provisionCode;           // 약관 코드

    private int provisionVersion;           // version

    private boolean necessary;              // 필수여부

    private boolean agreement;              // 동의여부.
}
