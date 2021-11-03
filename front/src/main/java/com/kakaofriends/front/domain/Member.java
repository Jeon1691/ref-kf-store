package com.kakaofriends.front.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Member implements Serializable {
    private Long id;                    // 회원 Sequence. seq_member_id

    private String status;              // 상태. MEMBER-회원, DORMANCY-휴면, WITHDRAW-탈퇴

    @Autowired

    @NotNull
    @Email
    private String email;               // email
    private String oldEmail;

    @NotBlank(message = "공백일 수 없다.")
    private String password;            // 비밀번호. bcrypt 64byte

    @NotBlank(message = "공백일 수 없다.")
    private String name;                // 이름.

    @Digits(integer = 11, fraction = 0, message = "숫자 넣어라.")
    private String phoneNumber;         // 전화번호.

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private String birthyear;           // 생년 yyyy

    @NotNull
    private String birthday;            // 생일 mmdd

    private String birthString;         // 생일 yyyy. M. d

    @NotNull
    private String gender;              // 성별. M-남성 F-여성

    @NotNull
    private String country;             // 2자리 국가코드

    private String countryName;         // 국가명

    private String countryNumber;       // 국가번호

    private String providerId;          // 소셜 서비스 아이디. kakao 등..

    private String providerUserId;      // 소셜 유저 아이디

    @NotNull
    private String barcode;             // 회원 바코드 번호

    @NotNull
    private String barcodeUrl;          // 회원 바코드 이미지 URL

    private boolean phoneAuth;          // 폰 인증 여부. 0-미인증, 1-인증완료

    private boolean emailAuth;          // 이메일 인증 여부. 0-미인증, 1-인증완료

    private LocalDateTime passwordDate; // 비밀번호 수정일시

    private LocalDateTime createDate;   // 회원 생성일시

    private LocalDateTime updateDate;   // 회원 수정일시

    private String mbCpcode = "b2cgroup";

    private String mbDpcode = "b2cpart";

    /**
     * getFriendsMemberId()
     */
    private String friendsMemberId;




}

