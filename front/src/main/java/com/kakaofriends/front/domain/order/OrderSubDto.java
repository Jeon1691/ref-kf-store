package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.event.DomesticEvent;
import com.kakaofriends.front.common.event.GlobalEmsEvent;
import com.kakaofriends.front.domain.Friends;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

public class OrderSubDto implements Serializable {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
	public static class OrderSubShipping implements Serializable {
		private String prName;
		private String prName1;
		private String prImage1;
		private String prImage12;
		private String prType;
		private String ctName;
		private OrderSub orderSub;
		private String pccUrl;
		private Boolean isCustomProduct;
		private Boolean isEventProduct;
		private Boolean isDiscountPeriod;
		private Boolean isEmsGiftProduct;
		private Boolean isDomesticEvent;

		public Boolean getIsCustomProduct(){
			return getPrType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
		}

		public Boolean getIsEventProduct(){
			return getPrType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
		}

		public Boolean getIsDiscountPeriod() {
			//2018.01.26 추가 layla
			if (orderSub.getProduct() == null) {
				return false;
			}

			if (orderSub.getProduct().getPrDiscountsDate() == null || orderSub.getProduct().getPrDiscounteDate() == null) {
				return false;
			}
			LocalDate startDate = new LocalDate(orderSub.getProduct().getPrDiscountsDate()).minusDays(1);
			LocalDate endDate = new LocalDate(orderSub.getProduct().getPrDiscounteDate()).plusDays(1);
			LocalDate today = new LocalDate();
			return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(orderSub.getProduct().getPrDiscountsDate()) && StringUtils.isNotEmpty(orderSub.getProduct().getPrDiscounteDate());
		}

		// 사은품 이벤트 : 사은품인지 체크
		public Boolean getIsEmsGiftProduct(){
			GlobalEmsEvent globalEmsEvent = new GlobalEmsEvent();
			return globalEmsEvent.isEventProduct(orderSub.getOsPrCode());
		}

		// 3, 5 사은품 이벤트 : 사은품인지 체크
		public Boolean getIsDomesticEvent() {
            DomesticEvent domesticEvent = new DomesticEvent();
            return domesticEvent.isEventProduct(orderSub.getOsPrCode());
        }
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class OrderSubShippingRequest extends Friends implements Serializable{
		private String orderNumber;
		private String ownerName;
		private Integer orderSubSequence;
		private String osCancelReason;
		private Integer requestEa;
	}

	public static class initializeDomains{
		// 주문 취소시 OrderSub 초기화
		public static List<OrderSubShipping> initializeOrderSubListForOrderCancel(String ownerId, List<OrderSubDto.OrderSubShipping> orderSubList, OrderStatusType orderStatusType) {
			orderSubList.forEach(e -> {
				e.getOrderSub().setOsTotOriginalMoney(0);
				e.getOrderSub().setOsTotSaleMoney(0);
				e.getOrderSub().setOsInEa(e.getOrderSub().getOsOutEa());
				e.getOrderSub().setOsOutEa(0);
				e.getOrderSub().setOsStatus(orderStatusType);
				e.getOrderSub().setOsMoId(ownerId);
			});
			return orderSubList;
		}

		// 전체 반품 시 OrderSub 초기화
		public static List<OrderSubShipping> initializeOrderSubListForReturnRequestAll(String ownerId, List<OrderSubDto.OrderSubShipping> orderSubList, OrderStatusType orderStatusType, String cancelReason) {
			orderSubList.forEach(e -> {
				e.getOrderSub().setOsStatus(orderStatusType);
				e.getOrderSub().setOsCancelReason(cancelReason == null ? "" : cancelReason);
				e.getOrderSub().setOsMoId(ownerId);
			});
			return orderSubList;
		}

		// 구매 확정, 반품, 교환 시 OrderSub 초기화
		public static OrderSub initializeOrderSubByOrderStatus(String ownerId, String cancelReason, OrderSub orderSub, OrderStatusType orderStatusType) {
			return OrderSub.builder()
					.osOmNum(orderSub.getOsOmNum())
					.osSeq(orderSub.getOsSeq())
					.osStatus(orderStatusType)
					.osCancelReason(cancelReason == null ? "" : cancelReason)
					.osScpCode(SUPPLY_COMPANY_CODE)
					.osMoId(ownerId)
					.build();
		}

		// 부분 반품, 부분 교환 시 OrderSub 초기화
		public static OrderSub initializeUpdateOrderSubForPartition(String ownerId, OrderSub myOrderSub, OrderSubDto.OrderSubShippingRequest shippingRequest) {
			OrderSub orderSub = new OrderSub();
			try {
				orderSub = (OrderSub) myOrderSub.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			Integer remainderMoney = orderSub.getOsSaleMoney() * shippingRequest.getRequestEa();

			if (0 < orderSub.getOsCardMoney() && 0 < remainderMoney) {
				orderSub.setOsCardMoney(orderSub.getOsCardMoney() - remainderMoney);
			}

			if (0 < orderSub.getOsKakaoMoney() && 0 < remainderMoney) {
				orderSub.setOsKakaoMoney(orderSub.getOsKakaoMoney() - remainderMoney);
			}

			if (0 < orderSub.getOsAccountMoney() && 0 < remainderMoney) {
				orderSub.setOsAccountMoney(orderSub.getOsAccountMoney() - remainderMoney);
			}

			orderSub.setOsTotOriginalMoney(myOrderSub.getOsOriginalMoney() * (myOrderSub.getOsOutEa() - shippingRequest.getRequestEa()));
			orderSub.setOsTotSaleMoney(myOrderSub.getOsSaleMoney() * (myOrderSub.getOsOutEa() - shippingRequest.getRequestEa()));
			orderSub.setOsOutEa(myOrderSub.getOsOutEa() - shippingRequest.getRequestEa());
			orderSub.setOsInEa(myOrderSub.getOsInEa() + shippingRequest.getRequestEa());
			orderSub.setOsMoId(ownerId);

			return orderSub;
		}

		// 부분 반품, 부분 교환 시 새로운 OrderSub 생성 후 초기화
		public static OrderSub initializeNewOrderSubForPartition(String ownerId, OrderSub myOrderSub, OrderSubDto.OrderSubShippingRequest shippingRequest, OrderStatusType orderStatusType) {
			OrderSub orderSub = new OrderSub();
			try {
				orderSub = (OrderSub) myOrderSub.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			Integer remainderMoney = orderSub.getOsSaleMoney() * shippingRequest.getRequestEa();

			System.out.println("카드 차감 : " + remainderMoney);
			if (0 < orderSub.getOsCardMoney() && 0 < remainderMoney) {
				orderSub.setOsCardMoney(remainderMoney);
			}

			System.out.println("카카오페이 차감 : " + remainderMoney);
			if (0 < orderSub.getOsKakaoMoney() && 0 < remainderMoney) {
				orderSub.setOsKakaoMoney(remainderMoney);
			}

			System.out.println("계좌이체 차감 : " + remainderMoney);
			if (0 < orderSub.getOsAccountMoney() && 0 < remainderMoney) {
				orderSub.setOsAccountMoney(remainderMoney);
			}

			orderSub.setOsEtc3(String.valueOf(myOrderSub.getOsSerial()));
			orderSub.setOsSerial(null);
			orderSub.setOsTotOriginalMoney(orderSub.getOsOriginalMoney() * shippingRequest.getRequestEa());
			orderSub.setOsTotSaleMoney(orderSub.getOsSaleMoney() * shippingRequest.getRequestEa());
			orderSub.setOsEa(shippingRequest.getRequestEa());
			orderSub.setOsOutEa(shippingRequest.getRequestEa());
			orderSub.setOsInEa(0);
			orderSub.setOsStatus(orderStatusType);
			orderSub.setOsMoId(ownerId);
			orderSub.setOsCancelReason(shippingRequest.getOsCancelReason());
			return orderSub;
		}
	}
}
