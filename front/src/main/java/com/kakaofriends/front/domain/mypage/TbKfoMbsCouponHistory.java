package com.kakaofriends.front.domain.mypage;

import com.kakaofriends.front.domain.Friends;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import java.util.Date;

/**
 * Created by layla.rae 2017.10.26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbKfoMbsCouponHistory {
    //GiftCardMaster.GCM_CODE
    private String CPH_GCMCODE;
    //쿠폰번호
    private String CPH_CODE;
    //쿠폰금액
    private int CPH_PRICE;
    //쿠폰금액 (USD)
    private double CPH_PRICE_EXCHANGE;
    //내용
    private String CPH_NAME;
    //내용 (영어)
    private String CPH_ENAME;
    //사용기한 시작일
    private Date CPH_SDATE;
    //사용기한 종료일
    private Date CPH_EDATE;
    //사용상태(1:사용전,2:사용중지,3:사용완료,4:온라인쿠폰등록완료,5:사용자삭)
    private String CPH_USE;
    //사용 날짜(주문)
    private Date CPH_USEDATE;
    //사용 날짜(지류)
    private Date CPH_REGISTDATE;
    //등록날짜
    private Date REG_DTTM;
    //수정날짜
    private Date UPD_DTTM;
    //등록아이디
    private String REG_USER;
    //수아이디
    private String UPD_USER;
    //주문번호
    private String CPH_OMNUM;
    //온라인쿠폰 보유 사용자ID
    private String CPH_USERID;
    //쿠폰구분(1:즉시,2:예약,3:별도,4:주문) + 5.포인트,6.온라인쿠폰,7.온라인지류
    private String CPH_TYPE;
    //(W)elcome 일반사용자, (V) VIP
    private String CPH_LEVEL;
    //A : 금액, D : 배송, C : 카테고리
    private String CPH_OPTION_TYPE;
    //값(최소금액 등 조건)
    private String CPH_OPTION_VALUE;
    //고유번호
    private String CPH_SEQ;
    //값(카테고리 ID)
    private int CPH_OPTION_CATEGORY;
    //중복 / 일반 쿠폰 구분
    private String CPH_DUPLICATION;
    //카테고리 있을 시 카테고리 이름
    private String CT_NAME;
    //카테고리 있을 시 카테고리 영어이름
    private String CT_ENAME;
    //기간
    private String CPH_TERM;
    //적립, 사용, 만료
    private String CPH_ROW_GUBUN;
    //쿠폰 이용내역 - 주문
    private String CPH_TITLE;
    //쿠폰 이용내역 - 주문 (영어)
    private String CPH_ETITLE;
    //주문에 따른 상품 카운트
    private int OMCOUNT;

    private String CPH_TYPE_NM;
    private String CPH_OPTION_TYPE_NM;

    @Data
    public static class Request extends Friends {
        private String gcCode;
        private String gcUserId;
        private String gcUse;
        private String gcOmnum;
    }

    public Boolean getIsUsePeriodBefore() {
        LocalDate startDate = new LocalDate(CPH_SDATE);
        LocalDate today = new LocalDate();
        return today.isBefore(startDate) && CPH_SDATE != null;
    }

    public Boolean getIsUsePeriodAfter() {
        LocalDate endDate = new LocalDate(CPH_EDATE);
        LocalDate today = new LocalDate();
        return today.isAfter(endDate) && CPH_EDATE != null;
    }
    
}
