package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by ben on 2017. 11. 15..
 */
@Data
@Deprecated
public class MemberAddress {
    /**
     * 고유번호
     */
    private int id;

    /**
     * 사용자 고유 번호
     */
    private String userId;

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
     * 수정자 아이디
     */
    private String updUser;

    /**
     * 등록자 아이디
     */
    private String regUser;

    /**
     * 변경일
     */
    private Date updDttm;

    /**
     * 등록일
     */
    private Date regDttm;

    /**
     * 모바일 이니시스 결재시 사용됨. 주문 번호.
     */
    private String omNum;

    /**
     * 기본 배송지 저장 삭제 타입
     */
    private String defaultAddressType;

    /**
     * 지역 코드
     */
    private String countryCode;

    /**
     * 기본배송지 저장
     */
    public static String MEMBER_DEFAULT_ADDRESS_SAVE = "S";

    /**
     * 기본배송지 삭제
     */
    public static String MEMBER_DEFAULT_ADDRESS_DELETE = "D";
}
