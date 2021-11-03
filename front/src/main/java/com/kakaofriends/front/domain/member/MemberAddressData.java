package com.kakaofriends.front.domain.member;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 회원 주소 정보에 대한 DAO
 */
@Data
public class MemberAddressData {
    /**
     * 고유번호
     */
    private Long id;

    /**
     * 사용자 고유 번호
     */
    private Long userId;

    /**
     * 이름
     */
    private String name;

    /**
     * 주소1
     */
    private String addr1;

    /**
     * 주소2
     */
    private String addr2;

    /**
     * 주소 3
     */
    private String addr3;

    /**
        * 우편번호
     */
    private String zoneCode;

    /**
     * 핸드폰 번호
     */
    private String phone;

    /**
     * 이메일
     */
    private String email;
    /**
     * 국가 코드
     */
    private String countryCode;
    /**
     * 수정자 아이디
     */
    private Long updUser;

    /**
     * 등록자 아이디
     */
    private Long regUser;

    /**
     * 변경일
     */
    private LocalDateTime updDttm;

    /**
     * 등록일
     */
    private LocalDateTime regDttm;
}
