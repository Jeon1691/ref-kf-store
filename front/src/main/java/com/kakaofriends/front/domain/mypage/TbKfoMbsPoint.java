package com.kakaofriends.front.domain.mypage;

import lombok.Data;

import java.util.Date;

/**
 * Created by layla.rae 2017.10.16
 */
@Data
public class TbKfoMbsPoint {
    //고유번호
    private int MP_SEQ;
    //사용자 정보 FK - USR_SEQ
    private String MP_USERID;
    //쿠폰 정보 FK - GC_CODE
    private String MP_CODE;
    //주문 정보 FK - OMNUM
    private String MP_OMNUM;

    private long MP_OSSEQ;

    //적립내역 - 내용
    private String MP_TITLE;
    //적립내역 - 내용(영어)
    private String MP_ETITLE;
    //발급일
    private Date MP_SDATE;
    //만료일
    private Date MP_EDATE;
    //100. -100
    private int MP_AMOUNT;
    //포인트 타입
    // U : 사용  / C : 포인트를사용한주문을취소했을때 재적립 / G : 기프트적립 / O : 주문적립 / P : 소멸
    private String MP_TYPE;
    //포인트 타입 다국어
    private String MP_TYPE_NM;
    //적립포인트 사용 후 잔액
    private int MP_REST;


    //전체 상품금액
    private int TOTALMONEY;
    //전체 상품금액 (USD)
    private double TOTALMONEY_EXCHANGE;
    //상품금액 - 결제포인트
    private int PAYMONEY;
    //상품금액 - 결제포인트 (USD)
    private double PAYMONEY_EXCHANGE;
    //결제 쿠폰머니
    private int COUPONMONEY;
    //주문에 따른 상품 카운트
    private int OMCOUNT;
    //등록일
    private Date REG_DTTM;
    //수정일
    private Date UPD_DTTM;
}
