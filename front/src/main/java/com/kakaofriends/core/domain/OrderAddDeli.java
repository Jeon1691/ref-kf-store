package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by seott on 2016-10-26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderAddDeli implements Serializable {
    private Integer odOsSeq;            // OrderAddDeli 시퀀스      (CS)
    private String odOmNum;             // 해당 상품 OrderNumber    (CS) SELECT
    private Integer odOsSerial;         // 해당 상품 OderSubSerial  (CS)
    private String odPgTid;             // X
    private String odType;              // R : 반품 회수비       (CS)
    private Integer odReqMoney;         // 회수비 요청 금액      (CS)
    private String odReqMoneyUnit;      // 회수비 요청 금액 단위 (CS)
    private Integer odAccountMoney;     // 이니시스 계좌이체 금액 (결제 시 입력)
    private Integer odCardMoney;        // 이니시스 카드결제 금액 (결제 시 입력)
    private Integer odLaterMoney;       // X
    private OrderStatusType odStatus;   // 상태값 - 100000000=미결제,200000000=회수완료,40000,50000/400000,500000=결제완료,300000=취소완료 (CS) SELECT
    private String odEtc1;              // 회수시 1개의 결제 타입 외 개수
    private String odEtc2;              // 회수비 결제 완료된 금액 합계
    private String odEtc3;              // X
    private Integer odEtc4;             // X
    private String odEtc5;              // 회수비결제오류코드
    private String odEtc6;              // 회수비결제오류메시지
    private String odMoId;              // 수정한 세션 아이디 (결제 시 입력)
    private String odInId;              // 입력한 아이디 (CS)
    private Date odMoDate;              // 수정한 날짜 (결제 시 입력)
    private Date odInDate;              // 입력한 날짜 (CS)
    private String odOdNum;             // OrderAddDeli 고유 번호 (결제 시 입력)
    private String odOdPgTid;           // PG 결제 번호 (결제 시 입력)
    private String odCreditCardNum;     // 결제 카드 번호 (결제 시 입력)
    private String odCreditCardCode;    // ???
    private String odAccountBankCode;   // ???
    private PayType odPayType;           // 결제 타입 (결제 시 입력) 카카오페이, 카드, 모바일
    private Date odPayInDate;           // 결제 시간 (결제 시 입력)
    private String odCardType;          // X
    private String odOdType;            // X
    private String odPrName;            // 상품 이름 (CS)
    private String odPrCode;            // 상품 코드 (CS)
    private String odOwnerId;           // 구매자 세션 ID (CS)
    private String odPrName1;           // 상품명 영문이름?? (CS)
    private String odPrName2;           // X
    private Integer odKakaoMoney;       // 카카오페이 결제 금액 (결제 시 입력)
    private Integer odPhoneMoney;       // 모바일 결제 금액 X
    private Date odDuzonDate;           // 더존 (CS)
    private String odDuzonFlag;         // 더존 (CS)
    private String odExchangeDeliNum;   // 송장 번호 (CS)
    private PayType odReqPayType;       // 결제 완료한 회수비 결제 타입
}
