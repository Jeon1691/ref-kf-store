package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EventDto {

    private int seq;

    /**
     * 주문 구분 D 국내 G 해외 A 모두
     */
    private String orderType;

    /**
     * 이벤트 타입 D 배송비 무료, P 포인트 지급, C 쿠폰 지급
     */
    private String eventType;

    /**
     * 가격 이상 기준값
     */
    private double orverPrice;

    /**
     * 가격 이하 기준값
     */
    private double belowPrice;

    /**
     * 가격 비교값 ( 사용자 입력값 )
     */
    private double orderPrice;

    /**
     * 조회 결과값
     */
    private double paymentPrice;

    /**
     * 이벤트 시작일
     */
    private Date eventStartDate;

    /**
     * 이벤트 종료일
     */
    private Date eventEndDate;

    /**
     * 이벤트 비교일
     */
    private Date eventDate;

    /**
     * 사용 여부
     */
    private String useYn;

    /**
     * 수정자
     */
    private String updUser;

    /**
     * 등록자
     */
    private String regUser;

    /**
     * 수정일
     */
    private Date updDttm;

    /**
     * 등록일
     */
    private Date regDttm;

    /**
     * 이벤트 사용여부
     */
    public static String EVENT_USE_FLAG = "Y";

    /**
     * 이벤트 타이틀
     */
    private String eventTitle;

    /**
     * 이벤트 타이틀 (EN)
     */
    private String eventTitleEn;
}
