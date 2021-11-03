package com.kakaofriends.front.domain.payment;

import com.kakaofriends.core.domain.OrderAddress;
import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.core.domain.OrderSubHistory;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayResultData {
	private Boolean isSuccess;
	private OrderMain orderMain;
	private List<OrderSub> orderSubs;
	private OrderSubHistory orderSubHistory;
	private OrderAddress orderAddress;
	private String oId;
	private String tid;
	private String orderPhone;
	private String orderMail;
	private String orderName;
	private String orderAuthDate;
	private String orderProductName;
	private String bsSeqList;
	private Integer amt;
	private String resultCode;
	private String resultMsg;
	private CnsPayResultData cnsPayResultData;
	private Member member;
	private IniPayResultData iniPayResultData;
	private String odOmNum;
	private Integer odOsSeq;
	private Integer odOsSerial;    // 해당 상품 OderSubSerial  (CS)
	private String payaplSaleId;
	private String paypalPaymentId;
	private String paypalPayerId;
	private String paypalPayerEmail;
	private float exchangeRate;
	private PayPalResultData payPalResultData;
	private String defaultAddressType;
	private MemberAddress memberAddress;
}