package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.core.common.configuration.persistence.type.*;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 주문 상세 정보에 대한 value object
 */
@Data
public class OrderSub {
	private Long sequence;
	private String orderNumber;
	private Integer serial;
	private String pgTid;
	private String productCode;
	private String supplyCompanyCode;
	private String businessGroupCode;
	private String businessPartCode;
	private String memberId;
	private String memberName;

	// 할인액
	private BigDecimal couponMoney;
	private BigDecimal pointMoney;

	// 본 상품 금액
	private BigDecimal originalMoney;
	private BigDecimal saleMoney;
	private BigDecimal totalOriginalMoney;
	private BigDecimal totalSaleMoney;

	// 실제로 결제된 금액
	private BigDecimal kakaoMoney;
	private BigDecimal paypalMoney;
	private BigDecimal accountMoney;
	private BigDecimal cardMoney;

	private int ea;
	private int outEa;
	private int inEa;
	private String memo;
	private DeliveryType deliveryType;
	private Usable deliveryMoneyUse;
	private String deliveryMemo;
	private String deliveryNumber;
	private Integer deliveryCompanySequence;
	private OrderStatusType status;
	private String superSerial;
	private OrderSubType type;
	private Usable use;
	private String modifiedId;
	private String insertedId;
	private LocalDateTime modifiedDate;
	private LocalDateTime insertedDate;
	private OrderAccessType accessType;
	private DeliInOutType deliveryInOutType;
	private Long categorySequence;
	private String cancelReason;

	private String customMessage;
	private BigDecimal exchangeRate;
	@Deprecated
	private String paypalSaleId;
	private Integer cjFlag;

	public OrderSub() {
		this.use = Usable.USE;
		this.couponMoney = new BigDecimal(0);
		this.pointMoney = new BigDecimal(0);
		this.originalMoney = new BigDecimal(0);
		this.saleMoney = new BigDecimal(0);
		this.totalOriginalMoney = new BigDecimal(0);
		this.totalSaleMoney = new BigDecimal(0);
		this.kakaoMoney = new BigDecimal(0);
		this.paypalMoney = new BigDecimal(0);
		this.accountMoney = new BigDecimal(0);
		this.cardMoney = new BigDecimal(0);
		this.exchangeRate = new BigDecimal(1);
	}

	/**
	 * 주문 시 상품별 실제로 결제된 금액을 설정한다.
	 * @param payType 결제 수단
	 * @param price 결제 금액
	 */
	public void setOrderSubPrice(PayType payType, BigDecimal price) {
		switch (payType) {
			case KAKAOPAY:
			case KAKAOPAY_V2:
				this.setKakaoMoney(price);
				break;
			case PAYPAL:
				this.setPaypalMoney(price);
				break;
			case ONLY_CARD:
				this.setCardMoney(price);
				break;
		}
	}

}