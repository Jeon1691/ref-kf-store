package com.kakaofriends.front.service.order.cancel;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import com.kakaofriends.core.domain.GiftCard;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.common.external.payment.PayComponent;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.domain.order.*;
import com.kakaofriends.front.domain.payment.*;
import com.kakaofriends.front.repository.BoxRepository;
import com.kakaofriends.front.repository.MyCouponRepository;
import com.kakaofriends.front.repository.MyOrderedRepository;
import com.kakaofriends.front.repository.OrderManageRepository;
import com.kakaofriends.front.repository.giftcard.GiftCardRepository;
import com.kakaofriends.front.service.MemberService;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.service.order.OrderManageService;
import com.kakaofriends.front.service.order.sub.OrderSubService;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.payment.PaymentHistoryService;
import com.kakaofriends.front.service.payment.accounting.AccountingService;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.kakaofriends.core.domain.GiftCard.GC_TYPE_STATE_USE_RETURN;
import static com.kakaofriends.front.domain.payment.PayMethodType.findPayMethodTypeByOrderPayTypeAndOrderAccessType;
import static com.kakaofriends.front.utils.FriendsUtil.*;
import static com.kakaofriends.front.utils.OrderUtil.*;

@Slf4j
@Service
public class OrderCancelProcessServiceImpl implements OrderCancelProcessService {

	@Autowired
	private List<PayComponent> payComponents;

	@Autowired
	MyOrderedRepository myOrderedRepository;

	@Autowired
	OrderManageRepository orderManageRepository;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	OrderManageService orderManageService;

	@Autowired
	private BoxRepository boxRepository;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MyCouponRepository myCouponRepository;

	@Autowired
	private GiftCardRepository giftCardRepository;

	@Autowired
	private MyPointService myPointService;

	@Autowired
	private PaymentHistoryService paymentHistoryService;

	@Autowired
	private StockService stockService;

	@Autowired
	private OrderSubService orderSubService;

	@Autowired
	private AccountingService accountingService;


	@Override
	@Transactional
	public boolean orderCancelToOrderSubList(HttpServletRequest httpServletRequest, String ownerId, String oId) throws OrderManageException {    // 주문 취소
		OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByUserIdAndOrderNumber(ownerId, oId);    // 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )

		if(orderStatusValidateCheckForShippingStatus(getMaxOrderSubByOrderSubList(orderShippingInfo).getCode(), ShippingStatusType.ORDER_COMPLETE)){
			return false;
		}

		isValidOwnerId(orderShippingInfo.getOrderInfo().getOmOwnerId(), OrderStatusType.CANCEL_COMPLETED); // 유효한 계정인지 확인
		return orderCancelToOrderSubListProcess(ownerId, orderShippingInfo, httpServletRequest);
	}

	@Override
	@Transactional
	public boolean orderCancelToOrderSubListForNonMember(HttpServletRequest httpServletRequest, String ownerId, String ownerName, String oId, String orderMail) throws OrderManageException {// 비회원 주문 취소
		HttpSession httpSession = httpServletRequest.getSession();
		String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
		String sessionOId = (String) httpSession.getAttribute("oId");

		OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByNonmemberNameAndOrderNumber(ownerName, oId, orderMail);    // 비 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )

		if(orderStatusValidateCheckForShippingStatus(getMaxOrderSubByOrderSubList(orderShippingInfo).getCode(), ShippingStatusType.ORDER_COMPLETE)){
			return false;
		}

		isValidOwnerName(sessionOwnerName, orderShippingInfo.getOrderAddressRequest().getOaBuyerName(), sessionOId, orderShippingInfo.getOrderInfo().getOmNum(), OrderStatusType.CANCEL_COMPLETED);
		return orderCancelToOrderSubListProcess(ownerId, orderShippingInfo, httpServletRequest);
	}

	private boolean orderCancelToOrderSubListProcess(String ownerId, OrderShippingInfo orderShippingInfo, HttpServletRequest httpServletRequest) {
		PayType payType = orderShippingInfo.getOrderInfo().getOmPayType();
		PayMethodType payMethodType = findPayMethodTypeByOrderPayTypeAndOrderAccessType(payType, orderShippingInfo.getOrderInfo().getOmAccessType());
		PayComponent payComponent = payComponents.stream().filter(e -> e.getPayMethodType().contains(payMethodType)).findAny().get();
		PayCancelResultData payCancelResultData = payComponent.cancelProcessing(httpServletRequest, initializePayCancel(payMethodType, orderShippingInfo.getOrderInfo(), PartialCancelCode.ALL_CANCEL, processMessage(messageSource, "order.cancel.user")));
		if (payCancelResultData.isCancelSuccess()) {
			// 결제이력
			PaymentHistory paymentHistory = new PaymentHistory();
			OrderInfo orderInfo = orderShippingInfo.getOrderInfo();
			if (isAnonymousUser()) {
				paymentHistory.setMemberId(-1);
			} else {
				paymentHistory.setMemberId(Integer.parseInt(ownerId));
			}
			paymentHistory.setOrderId(orderInfo.getOmNum());
			paymentHistory.setPaymentMethod(orderInfo.getOmPayType());
			paymentHistory.setCurrency(Currency.getCurrency(orderInfo.getOmPayType()));
			paymentHistory.setType(PaymentHistoryType.ORDER);
			paymentHistory.setAction(PaymentAction.CANCEL);
			paymentHistory.setPaymentAmount((float) orderInfo.getExchangeItemsMoney());
			paymentHistory.setShippingAmount((float) orderInfo.getExchangeDeliveryMoney());
			paymentHistoryService.add(paymentHistory);
			// ERP
			OrderSub orderSubSearchCondition = new OrderSub();
			orderSubSearchCondition.setOrderNumber(orderInfo.getOmNum());
			List<OrderSub> orderSubList = orderSubService.getList(orderSubSearchCondition);
			accountingService.addList(payType, PaymentAction.CANCEL, orderSubList);
			//재고 정보 update 2018.02.27
			stockService.updateList(setOrderStockList(orderShippingInfo));
			DBHandlerForOrderCancel(ownerId, orderShippingInfo);
		}
		return payCancelResultData.isCancelSuccess();
	}

	private void DBHandlerForOrderCancel(String ownerId, OrderShippingInfo orderShippingInfo) {
		List<OrderSubDto.OrderSubShipping> myOrderSubList = OrderSubDto.initializeDomains.initializeOrderSubListForOrderCancel(ownerId, orderShippingInfo.getOrderSubList(), OrderStatusType.CANCEL_COMPLETED);    // orderSub SELECT & 필요 값으로 초기화
		orderManageRepository.updateOrderSubForOrderCancel(myOrderSubList);  // ORDERSUB UPDATE
		orderManageRepository.updateOrderSubDeliveryForOrderCancel(myOrderSubList.get(0).getOrderSub().getOsOmNum(), myOrderSubList.get(0).getOrderSub().getOsMoId(), String.valueOf(OrderStatusType.CANCEL_COMPLETED.getCode()));
		orderManageRepository.insertOrderSubHistoryForOrderCancel(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryForOrderCancel(ownerId, myOrderSubList, OrderStatusType.CANCEL_COMPLETED)); // ORDERSUBHISTORY INSERT

		// 박스 및 박스아이템 정보 삭제
		String omNum = orderShippingInfo.getOrderInfo().getOmNum();
		boxRepository.orderBoxItemDeleteByOrderNum(omNum);
		boxRepository.orderBoxDeleteByOrderNum(omNum);

		// 기프트카드 사용전으로 초기화 & 히스토리 생성
		int couponUse = orderManageRepository.updateGiftCardForOrderCancel(orderShippingInfo.getOrderInfo().getOmNum(), GiftCard.builder().gcUse("1").gcOmNum("1").gcResetCnt(1).build());

		if(couponUse > 0){
			//List<TbKfoMbsCouponHistory.Request> request = myCouponRepository.myAvailableCouponHistoryInsert(orderShippingInfo.getOrderInfo().getOmNum());
			List<TbKfoMbsCouponHistory> couponList = giftCardRepository.findCouonListByOmnum(orderShippingInfo.getOrderInfo().getOmNum());
			for(int i = 0 ; i < couponList.size() ; i++ ){
				String giftCardCode = couponList.get(i).getCPH_CODE();

				TbKfoMbsCouponHistory.Request request = new TbKfoMbsCouponHistory.Request();
				request.setGcCode(giftCardCode);
				request.setGcOmnum(orderShippingInfo.getOrderInfo().getOmNum());
				request.setGcUse(GC_TYPE_STATE_USE_RETURN);
				request.setGcUserId(getFriendsMemberId());
				myCouponRepository.myAvailableCouponHistoryInsert(request);
			}
		}

		// 포인트 취소 사용전으로 초기화
		if ( orderShippingInfo.getOrderInfo().getOmPointMoney() > 0 ) {
			TbKfoMbsPoint mbsPoint = new TbKfoMbsPoint();
			mbsPoint.setMP_USERID(ownerId);
			mbsPoint.setMP_OMNUM(omNum);
			mbsPoint.setMP_AMOUNT(orderShippingInfo.getOrderInfo().getOmPointMoney());
			mbsPoint.setMP_TYPE(MyPointCode.CANCEL.getCode());
			myPointService.modifyPointProcess(mbsPoint);
		}

	}

	private void DBHandlerForOrderRefund(String ownerId, OrderShippingInfo orderShippingInfo) {
		List<OrderSubDto.OrderSubShipping> myOrderSubList = OrderSubDto.initializeDomains.initializeOrderSubListForOrderCancel(ownerId, orderShippingInfo.getOrderSubList(), OrderStatusType.RETURN_COMPLETED);    // orderSub SELECT & 필요 값으로 초기화
		orderManageRepository.updateOrderSubForOrderCancel(myOrderSubList);  // ORDERSUB UPDATE
		orderManageRepository.insertOrderSubHistoryForOrderCancel(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryForOrderCancel(ownerId, myOrderSubList, OrderStatusType.RETURN_COMPLETED)); // ORDERSUBHISTORY INSERT

		// 박스 및 박스아이템 정보 삭제
		String omNum = orderShippingInfo.getOrderInfo().getOmNum();
		boxRepository.orderBoxItemDeleteByOrderNum(omNum);
		boxRepository.orderBoxDeleteByOrderNum(omNum);

		// 기프트카드 사용전으로 초기화 & 히스토리 생성
		int couponUse = orderManageRepository.updateGiftCardForOrderCancel(orderShippingInfo.getOrderInfo().getOmNum(), GiftCard.builder().gcUse("1").gcOmNum("1").gcResetCnt(1).build());

		if(couponUse > 0){
			//List<TbKfoMbsCouponHistory.Request> request = myCouponRepository.myAvailableCouponHistoryInsert(orderShippingInfo.getOrderInfo().getOmNum());
			List<TbKfoMbsCouponHistory> couponList = giftCardRepository.findCouonListByOmnum(orderShippingInfo.getOrderInfo().getOmNum());
			for(int i = 0 ; i < couponList.size() ; i++ ){
				String giftCardCode = couponList.get(i).getCPH_CODE();

				TbKfoMbsCouponHistory.Request request = new TbKfoMbsCouponHistory.Request();
				request.setGcCode(giftCardCode);
				request.setGcOmnum(orderShippingInfo.getOrderInfo().getOmNum());
				request.setGcUse(GC_TYPE_STATE_USE_RETURN);
				request.setGcUserId(getFriendsMemberId());
				myCouponRepository.myAvailableCouponHistoryInsert(request);
			}
		}

		// 포인트 취소 사용전으로 초기화
		if ( orderShippingInfo.getOrderInfo().getOmPointMoney() > 0 ) {
			TbKfoMbsPoint mbsPoint = new TbKfoMbsPoint();
			mbsPoint.setMP_USERID(ownerId);
			mbsPoint.setMP_OMNUM(omNum);
			mbsPoint.setMP_AMOUNT(orderShippingInfo.getOrderInfo().getOmPointMoney());
			mbsPoint.setMP_TYPE(MyPointCode.CANCEL.getCode());
			myPointService.modifyPointProcess(mbsPoint);
		}

	}

	private PayCancel initializePayCancel(PayMethodType payMethodType, OrderInfo orderInfo, PartialCancelCode partialCancelCode, String cancelMessage) {
		switch (payMethodType) {
			case KAKAOPAY:
			case KAKAOPAY_V2: // 카카오페이 버전업됨. 사용하는 필드는 같음. 2017.12.26 Breeze
				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmKakaoMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
			case ONLYDBANK:
				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmAccountMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
			case ONLYCARD:
				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmCardMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
			case M_ONLYDBANK:
				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmAccountMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
//			case M_ONLYCARD:
//				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmCardMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
			case PAYPAL:
				return PayCancel.builder().tid(orderInfo.getOmPgtId()).cancelAmt(String.valueOf(orderInfo.getOmPaypalMoney())).partialCancelCode(partialCancelCode).message(cancelMessage).build();
		}
		return null;
	}

	@Override
	@Transactional
	public void orderRefund(String ownerId, String oId) throws Exception {
		OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByUserIdAndOrderNumber(ownerId, oId);
		this.DBHandlerForOrderRefund(ownerId, orderShippingInfo);
	}

	/**
	 * 주문취소에 따른 재고 정보 생성
	 *
	 * @param orderShippingInfo 주문정보
	 * @return
	 */
	private List<Stock> setOrderStockList(OrderShippingInfo orderShippingInfo) {
		List<Stock> stockList = new ArrayList<>();
		for (OrderSubDto.OrderSubShipping orderSub : orderShippingInfo.getOrderSubList()) {
			Stock stock = new Stock();
			stock.setProductId(orderSub.getOrderSub().getOsPrCode());
			stock.setAvailableStock(orderSub.getOrderSub().getOsEa());
			stock.setOrderStock(orderSub.getOrderSub().getOsEa() * (-1));
			stock.setDomestic(orderShippingInfo.getGlobal());
			stock.setOrderNumber(orderShippingInfo.getOrderInfo().getOmNum());
			stock.setMemberId(orderShippingInfo.getOrderInfo().getOmOwnerId());
			stock.setOrderAction(OrderAction.CANCEL);
			stockList.add(stock);
		}
		return stockList;
	}
}