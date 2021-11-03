package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.Friends;
import com.kakaofriends.front.domain.payment.PayMethodType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

public class OrderResultDto implements Serializable {

	@Data
	public static class ResultRequest extends Friends implements Serializable {
		private String oid;
		private String uid;
		private PayMethodType payMethodType;
		private String paymethod;
		private String bsSeqList;
		private String accesstype;

		private String osDeliType = "1";            // 1=택배
		private String osDeliPayType = "2";            // 1=착불,2=선불
		private String osDeliMoenyUse = "Y";        // Y=배송비있음,N=배송비없음
		private DeliInOutType osDeliInOutType = DeliInOutType.DOMESTIC;

		private String giftCardNumber;
		private int giftCardAmount;
		private int deliveryCharge;

		private List<String> prCodes;
		private List<String> parentPrCodes;
		private List<Integer> bsCtSeqs;
		private List<Integer> bsEas;
		private List<String> bsEtc5s;
		private List<Boolean> isDiscountPeriods;
		private List<String> osOptionNames;
		private List<String> osOriginalMoneys;
		private List<String> osSaleMoneys;
		private List<String> osTotOriginalMoneys;
		private List<String> totOnePrMoneys;
		private List<String> prSaveMoneys;

		//주문자 정보
		private String oaBuyerName;
		private String oaBuyerPhone;
		private String oaBuyerEmail;
		private String oaBuyerCountryCode;
		private String oaBuyerCountryName;

		private String oaName;
		private String oaPhone;
		private String oaEmail;
		private String oaZoneCode;
		private String oaAddr1;
		private String oaAddr2;
		private String oaAddr3;
		private String osDeliMemo;
		private String payType;
		private String buyername;
		private String oaAddressType;

		private String encrypted;
		private String cardcode;
		private String sessionkey;
		private String goodname;

		private Long Amt;
		private Integer paymentAmount;
		private Integer GoodsCnt;
		private String GoodsName;
		//private String PayMethod;
		//private String ini_paymethod;
		private String currency;
		private String odOmNum;
		private Integer odOsSeq;

		private String P_STATUS;
		private String P_RMESG1;
		private String P_TID;
		private String P_MID;
		private String P_REQ_URL;
		private String P_NOTI;

		private String EdiDate;
		private String SPU;
		private String SPU_SIGN_TOKEN;
		private String MPAY_PUB;
		private String NON_REP_TOKEN;

		private String oaCountryCode;
		private String oaCountryName;

		//paypal 관련
		private String payaplSaleId;
		private String paypalPaymentId;
		private String paypalPayerId;
		private String paypalPayerEmail;
		private String paypalCreateTime;
		private float exchangeRate;

		private int pointPrice;
		private List<String> giftCardCodes;

        /**
         * 기본 배송지 저장 타입 S 저장
         */
		private String defaultAddressType;

	}

	@Data
	public static class OrderSubInit implements Serializable {
		private Member member;
		private String oid;
		private String tid;
		private String ownerName;
		private String deliMemo;
		private List<String> prCodes;
		private List<Integer> bsCtSeqs;
		private List<Integer> prEa;
		private List<String> bsEtc5s;
		private List<Boolean> isDiscountPeriods;
		private int giftCardAmount;
		private String osDeliType;
		private String osDeliPayType;
		private String osDeliMoneyUse;
		private String osAccessType;
		private String payMethodType;
		private DeliInOutType osDeliInOutType = DeliInOutType.DOMESTIC;
		private float osPaypalMoney;
		private String osPaypalSaleId;
		private double osExchangeRate = 1;
		private int pointPrice;
	}

	@Data
	public static class CouponRequest extends Friends implements Serializable {
		private String couponNum1;
		private String couponNum2;
		private String couponNum3;
		private String couponNum4;
	}
}