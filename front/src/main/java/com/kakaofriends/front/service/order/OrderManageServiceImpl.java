package com.kakaofriends.front.service.order;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import com.kakaofriends.core.domain.Config;
import com.kakaofriends.core.domain.GiftCard;
import com.kakaofriends.core.domain.OrderAddress;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.event.DomesticEvent;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.domain.order.OrderSubHistoryDto;
import com.kakaofriends.front.repository.ConfigRepository;
import com.kakaofriends.front.repository.MyOrderedRepository;
import com.kakaofriends.front.repository.OrderManageRepository;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.isAnonymousUser;
import static com.kakaofriends.front.utils.OrderUtil.*;

@Slf4j
@Service
@EnableAsync
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    OrderManageRepository orderManageRepository;

    @Autowired
    MyOrderedRepository myOrderedRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConfigRepository configRepository;


    @Autowired
    MyPointService myPointService;

    @Autowired
    private DomesticEvent domesticEvent;

    @Autowired
    StockService stockService;

    @Override
    public OrderSub findOrderSubByUserIdAndOrderSubSequence(String userId, int orderSubSequence) {
        return myOrderedRepository.findOrderSubByUserIdAndOrderSubSequence(userId, orderSubSequence);
    }

    /**배송지 변경(회원/비회원)**/
    @Override
    public boolean updateOrderAddressByOrderNumber(OrderAddressDto.request orderAddressRequest, String sessionOwnerName, String sessionOId, String sessionOrderMail) throws OrderManageException {
        boolean checkOrderInfo = validOrderRequest(orderAddressRequest, sessionOwnerName, sessionOId, sessionOrderMail);
        if(!checkOrderInfo) {
            return false;
        }

        orderManageRepository.updateOrderAddressByOrderNumber(orderAddressRequest);
        return true;
    }

    /** 구매자 정보 변경(회원/비회원)**/
    @Override
    public boolean updateOrderBuyerInfo(HttpServletRequest request, OrderAddressDto.request orderAddressRequest, String sessionOwnerName, String sessionOId, String sessionOrderMail) throws OrderManageException {
        boolean checkOrderInfo = validOrderRequest(orderAddressRequest, sessionOwnerName, sessionOId, sessionOrderMail);
        if(!checkOrderInfo) {
            return false;
        }
        String buyerName = request.getParameter("buyerName");
        String buyerEmail = request.getParameter("buyerEmail");

        orderManageRepository.updateOrderAddressBuyerInfo(buyerName, buyerEmail, orderAddressRequest.getOaOmNum());
        return true;
    }

    /**구매 확정(회원)**/
    @Override
    @Transactional
    public boolean purchaseFinalizedToOrderSub(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByUserIdAndOrderSubSequence(ownerId, shippingRequest.getOrderSubSequence());

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 회원 - 구매 확정 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        isValidOwnerId(myOrderSub.getOsOwnerId(), OrderStatusType.PURCHASE_FINALIZED);  // 유효한 계정인지 확인
        purchaseFinalizedToOrderSubProcess(ownerId, shippingRequest, myOrderSub);  // OrderSub 구매 확정으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    /**전체 반품 신청(회원)**/
    @Override
    @Transactional
    public boolean orderSubReturnRequestAll(String ownerId, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {// 회원 전체 반품 신청
        OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByUserIdAndOrderNumber(ownerId, sessionOId);    // 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )

        int orderSubMaxCode = getMaxOrderSubByOrderSubList(orderShippingInfo).getCode();
        if(orderStatusValidateCheckForShippingStatus(orderSubMaxCode, ShippingStatusType.SHIPPING_COMPLETE)){
            log.info("### 회원 - 전체 반품 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderStatusMax : {}", orderShippingInfo.getOrderInfo().getOmOwnerId(), orderShippingInfo.getOrderAddressRequest().getOaName(), orderShippingInfo.getOrderInfo().getOmNum(), orderSubMaxCode);
            return false;
        }

        isValidOwnerId(orderShippingInfo.getOrderInfo().getOmOwnerId(), OrderStatusType.CANCEL_COMPLETED); // 유효한 계정인지 확인
        orderSubReturnRequestAllProcess(ownerId, orderShippingInfo, shippingRequest);
        return true;
    }

    /**반품 신청(회원)**/
    @Override
    @Transactional
    public boolean orderSubReturnRequest(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {       // 회원 반품 신청
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByUserIdAndOrderSubSequence(ownerId, shippingRequest.getOrderSubSequence());

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 회원 - 반품 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        log.info("### 반품 신청 : Before : 회원 주문정보 : oId : {}, userId : {}, userName : {}, orderStatus_Cd : {}, orderStatus_Nm : {}", myOrderSub.getOsOmNum(), myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsStatus().getCode(), myOrderSub.getOsStatus().getName());

        isValidOwnerId(myOrderSub.getOsOwnerId(), OrderStatusType.RETURN_APPLICATION);  // 유효한 계정인지 확인
        orderSubReturnRequestProcess(ownerId, shippingRequest, myOrderSub); // OrderSub 반품 신청으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    /**교환 신청(회원)**/
    @Override
    @Transactional
    public boolean orderSubExchangeRequest(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {      // 회원 교환 신청
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByUserIdAndOrderSubSequence(ownerId, shippingRequest.getOrderSubSequence());

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 회원 - 교환 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        log.info("### 교환 신청 : Before : 회원 주문정보 : oId : {}, userId : {}, userName : {}, orderStatus_Cd : {}, orderStatus_Nm : {}", myOrderSub.getOsOmNum(), myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsStatus().getCode(), myOrderSub.getOsStatus().getName());

        isValidOwnerId(myOrderSub.getOsOwnerId(), OrderStatusType.EXCHANGE_APPLICATION); // 유효한 계정인지 확인
        orderSubExchangeRequestProcess(ownerId, shippingRequest, myOrderSub); // OrderSub 교환 신청으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    /**구매 확정(비회원)**/
    @Override
    @Transactional
    public boolean purchaseFinalizedToOrderSubForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {   // 비 회원 구매 확정
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByOwnerNameAndOrderSubSequence(sessionOwnerName, shippingRequest.getOrderSubSequence());

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 비회원 - 구매 확정 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        isValidOwnerName(sessionOwnerName, myOrderSub.getOsOwnerName(), sessionOId, myOrderSub.getOsOmNum(), OrderStatusType.PURCHASE_FINALIZED);
        purchaseFinalizedToOrderSubProcess(ownerId, shippingRequest, myOrderSub);  // OrderSub 구매 확정으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    /**전체 반품 신청(비회원)**/
    @Override
    @Transactional
    public boolean orderSubReturnRequestAllForNonMember(String ownerId, String sessionOwnerName, String sessionOId, String sessionOrderMail, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {     // 비 회원 전체 반품
        OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByNonmemberNameAndOrderNumber(sessionOwnerName, sessionOId, sessionOrderMail);    // 비 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )
        int orderSubMaxCode = getMaxOrderSubByOrderSubList(orderShippingInfo).getCode();
        if(orderStatusValidateCheckForShippingStatus(orderSubMaxCode, ShippingStatusType.SHIPPING_COMPLETE)){
            log.info("### 비회원 - 전체 반품 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderStatusMax : {}", orderShippingInfo.getOrderInfo().getOmOwnerId(), orderShippingInfo.getOrderAddressRequest().getOaName(), orderShippingInfo.getOrderInfo().getOmNum(), orderSubMaxCode);
            return false;
        }

        isValidOwnerName(sessionOwnerName, orderShippingInfo.getOrderAddressRequest().getOaName(), sessionOId, orderShippingInfo.getOrderInfo().getOmNum(), OrderStatusType.RETURN_APPLICATION);
        orderSubReturnRequestAllProcess(ownerId, orderShippingInfo, shippingRequest);
        return true;
    }

    /**반품 신청(비회원)**/
    @Override
    @Transactional
    public boolean orderSubReturnRequestForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {     // 비 회원 반품 신청
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByOwnerNameAndOrderSubSequence(sessionOwnerName, shippingRequest.getOrderSubSequence());

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 비회원 - 반품 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        log.info("### 반품 신청 : Before : 비회원 주문정보 : oId : {}, userId : {}, userName : {}, orderStatus_Cd : {}, orderStatus_Nm : {}", myOrderSub.getOsOmNum(), myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsStatus().getCode(), myOrderSub.getOsStatus().getName());
        isValidOwnerName(sessionOwnerName, myOrderSub.getOsOwnerName(), sessionOId, myOrderSub.getOsOmNum(), OrderStatusType.RETURN_APPLICATION);
        orderSubReturnRequestProcess(ownerId, shippingRequest, myOrderSub); // OrderSub 반품 신청으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    /**교환 신청(비회원)**/
    @Override
    @Transactional
    public boolean orderSubExchangeRequestForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {       // 비 회원 교환 신청
        OrderSub myOrderSub = myOrderedRepository.findOrderSubByOwnerNameAndOrderSubSequence(sessionOwnerName, shippingRequest.getOrderSubSequence());
        isValidOwnerName(sessionOwnerName, myOrderSub.getOsOwnerName(), sessionOId, myOrderSub.getOsOmNum(), OrderStatusType.EXCHANGE_APPLICATION);

        if(orderStatusValidateCheckForOrderManage(myOrderSub.getOsStatus())){
            log.info("### 비회원 - 교환 신청 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderSequence : {}, orderSerial : {}, orderStatus : {}", myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsOmNum(), myOrderSub.getOsSerial(), myOrderSub.getOsSerial(), myOrderSub.getOsStatus().getCode());
            return false;
        }

        log.info("### 교환 신청 : Before : 비회원 주문정보 : oId : {}, userId : {}, userName : {}, orderStatus_Cd : {}, orderStatus_Nm : {}", myOrderSub.getOsOmNum(), myOrderSub.getOsOwnerId(), myOrderSub.getOsOwnerName(), myOrderSub.getOsStatus().getCode(), myOrderSub.getOsStatus().getName());

        orderSubExchangeRequestProcess(ownerId, shippingRequest, myOrderSub); // OrderSub 교환 신청으로 플래그 변경 및 OrderSubHistory 등록
        return true;
    }

    private void purchaseFinalizedToOrderSubProcess(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest, OrderSub myOrderSub) {
        Config config = configRepository.findByCfId("CALCULATE_DIV");
        OrderSub initializeOrderSub = OrderSubDto.initializeDomains.initializeOrderSubByOrderStatus(ownerId, shippingRequest.getOsCancelReason(), myOrderSub, OrderStatusType.PURCHASE_FINALIZED);
        if (config.getCfValue() == 9) {
            orderManageRepository.insertSales(SalesDto.initializeDomains.initializeSales(ownerId, myOrderSub));    // SALES INSERT
        }
        orderManageRepository.updateOrderSubByOrderStatus(initializeOrderSub);  // ORDERSUB STATUS UPDATE
        orderManageRepository.insertOrderSubHistorByOrderStatus(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryByOrderStatus(ownerId, myOrderSub, OrderStatusType.PURCHASE_FINALIZED));   // ORDERSUBHISTORY INSERT

        //회원이 구매확정하는 경우
        if((!isAnonymousUser()) && myOrderSub.getOsStatus().getCode() == OrderStatusType.COMPLETION_DISPATCH.getCode() ){
            //구매 확정한 상품의 포인트 부여
            purchaseFinalizedToPoint(myOrderSub);
            processCompleteOrderForPoint(myOrderSub);
        }
    }

    private void orderSubReturnRequestAllProcess(String ownerId, OrderShippingInfo orderShippingInfo, OrderSubDto.OrderSubShippingRequest shippingRequest) {
        orderManageRepository.updateGiftCardForOrderCancel(orderShippingInfo.getOrderInfo().getOmNum(), GiftCard.builder().gcUse("1").gcOmNum("1").gcResetCnt(1).build());    // 기프트카드 사용전으로 초기화
        List<OrderSubDto.OrderSubShipping> myOrderSubList = OrderSubDto.initializeDomains.initializeOrderSubListForReturnRequestAll(ownerId, orderShippingInfo.getOrderSubList(), OrderStatusType.RETURN_APPLICATION, shippingRequest.getOsCancelReason());    // orderSub SELECT & 필요 값으로 초기화
        orderManageRepository.updateOrderSubForReturnRequestAll(myOrderSubList);  // ORDERSUB UPDATE
        orderManageRepository.insertOrderSubHistoryForOrderCancel(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryForOrderCancel(ownerId, myOrderSubList, OrderStatusType.RETURN_APPLICATION)); // ORDERSUBHISTORY INSERT
    }

    private void orderSubReturnRequestProcess(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest, OrderSub myOrderSub) throws OrderManageException {
        if (orderManageRepository.findCouponMoneyByUserIdAndOrderNumberToOrderMain(shippingRequest.getOrderNumber()) > 0) {    // 쿠폰 사용 금액 있을 경우
            log.error("쿠폰 적용 상품은 반품 불가. 주문번호 : {}", shippingRequest.getOrderNumber());
            throw new OrderManageException("쿠폰 적용 상품은 반품 불가.");
        }
        if (shippingRequest.getRequestEa() >= myOrderSub.getOsOutEa()) {        // 반품 신청
            OrderSub initializeMyOrderSub = OrderSubDto.initializeDomains.initializeOrderSubByOrderStatus(ownerId, shippingRequest.getOsCancelReason(), myOrderSub, OrderStatusType.RETURN_APPLICATION);
            orderManageRepository.updateOrderSubByOrderStatus(initializeMyOrderSub);    // ORDERSUB STATUS UPDATE
            orderManageRepository.insertOrderSubHistorByOrderStatus(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryByOrderStatus(ownerId, myOrderSub, OrderStatusType.RETURN_APPLICATION));   // ORDERSUBHISTORY INSERT
            log.info("### 반품 신청(회원/비회원) : 전체 반품 Stauts Update END :: status_cd : {}, status_nm : {}", OrderStatusType.RETURN_APPLICATION.getCode(), OrderStatusType.RETURN_APPLICATION.getName());

        } else {        // 부분 반품 신청
            orderManageRepository.updateOrderSubForPartition(OrderSubDto.initializeDomains.initializeUpdateOrderSubForPartition(ownerId, myOrderSub, shippingRequest));
            OrderSub orderSubPartition = OrderSubDto.initializeDomains.initializeNewOrderSubForPartition(ownerId, myOrderSub, shippingRequest, OrderStatusType.PARTIAL_RETURN_APPLICATION);
            orderManageRepository.insertOrderSubForPartition(orderSubPartition);
            orderManageRepository.insertOrderSubHistorByOrderStatus(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryByOrderStatus(ownerId, myOrderSub, OrderStatusType.PARTIAL_RETURN_APPLICATION, orderSubPartition.getOsSerial()));
            log.info("### 반품 신청(회원/비회원) : 부분 반품 Stauts Update END :: status_cd : {}, status_nm : {}", OrderStatusType.PARTIAL_RETURN_APPLICATION.getCode(), OrderStatusType.PARTIAL_RETURN_APPLICATION.getName());
        }
    }

    private void orderSubExchangeRequestProcess(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest, OrderSub myOrderSub) {

        if (shippingRequest.getRequestEa() >= myOrderSub.getOsOutEa()) {        // 교환 신청

            OrderSub initializeMyOrderSub = OrderSubDto.initializeDomains.initializeOrderSubByOrderStatus(ownerId, shippingRequest.getOsCancelReason(), myOrderSub, OrderStatusType.EXCHANGE_APPLICATION);
            // ORDERSUB STATUS UPDATE
            orderManageRepository.updateOrderSubByOrderStatus(initializeMyOrderSub);
            // ORDERSUBHISTORY INSERT
            orderManageRepository.insertOrderSubHistorByOrderStatus(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryByOrderStatus(ownerId, myOrderSub, OrderStatusType.EXCHANGE_APPLICATION));

            log.info("### 교환 신청(회원/비회원) : 전체 교환 Stauts Update END :: status_cd : {}, status_nm : {}", OrderStatusType.EXCHANGE_APPLICATION.getCode(), OrderStatusType.EXCHANGE_APPLICATION.getName());
        } else {        // 부분 교환 신청
            orderManageRepository.updateOrderSubForPartition(OrderSubDto.initializeDomains.initializeUpdateOrderSubForPartition(ownerId, myOrderSub, shippingRequest));
            OrderSub orderSubPartition = OrderSubDto.initializeDomains.initializeNewOrderSubForPartition(ownerId, myOrderSub, shippingRequest, OrderStatusType.PARTIAL_EXCHANGE_APPLICATION);
            orderManageRepository.insertOrderSubForPartition(orderSubPartition);
            orderManageRepository.insertOrderSubHistorByOrderStatus(OrderSubHistoryDto.initializeDomains.initializeOrderSubHistoryByOrderStatus(ownerId, myOrderSub, OrderStatusType.PARTIAL_EXCHANGE_APPLICATION, orderSubPartition.getOsSerial()));

            log.info("### 교환 신청(회원/비회원) : 부분 교환 Stauts Update END :: status_cd : {}, status_nm : {}", OrderStatusType.PARTIAL_EXCHANGE_APPLICATION.getCode(), OrderStatusType.PARTIAL_EXCHANGE_APPLICATION.getName());
        }
    }

    private boolean validOrderRequest(OrderAddressDto.request orderAddressRequest, String sessionOwnerName, String sessionOId, String sessionOrderMail) throws OrderManageException {
        int orderSubMaxCode;
        if (isAnonymousUser()) {
            OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByNonmemberNameAndOrderNumber(sessionOwnerName, sessionOId, sessionOrderMail);    // 비 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )

            orderSubMaxCode = getMaxOrderSubByOrderSubList(orderShippingInfo).getCode();
            if(orderStatusValidateCheckForShippingStatus(orderSubMaxCode, ShippingStatusType.ORDER_COMPLETE)){
                log.info("### 비회원 - 배송지 변경 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderStatusMax : {}", orderShippingInfo.getOrderInfo().getOmOwnerId(), orderShippingInfo.getOrderAddressRequest().getOaName(), orderShippingInfo.getOrderInfo().getOmNum(), orderSubMaxCode);
                return false;
            }

            isValidOwnerName(sessionOwnerName, orderAddressRequest.getOaBuyerName(), sessionOId, orderAddressRequest.getOaOmNum());
        } else {
            OrderAddress orderAddress = orderManageRepository.findOrderAddressByOrderNumber(orderAddressRequest.getOaOmNum());
            OrderShippingInfo orderShippingInfo = myOrderedRepository.findOrderShippingInfoByUserIdAndOrderNumber(getFriendsMemberId(), sessionOId);    // 회원 주문 정보 가져오기 ( SELECT ORDERMAIN )

            orderSubMaxCode = getMaxOrderSubByOrderSubList(orderShippingInfo).getCode();
            if(orderStatusValidateCheckForShippingStatus(orderSubMaxCode, ShippingStatusType.ORDER_COMPLETE)){
                log.info("### 회원 - 배송지 변경 실패 (상태값 다름) ::: userId : {}, userName : {}, orderNumber : {}, orderStatusMax : {}", orderShippingInfo.getOrderInfo().getOmOwnerId(), orderShippingInfo.getOrderAddressRequest().getOaBuyerName(), orderShippingInfo.getOrderInfo().getOmNum(), orderSubMaxCode);
                return false;
            }

            isValidOwnerId(orderShippingInfo.getOrderInfo().getOmOwnerId()); // 유효한 계정인지 확인
        }

        return true;
    }

    /*
    포인트 적립
     */
    public void purchaseFinalizedToPoint(OrderSub myOrderSub) {
        int nonCnt = orderManageRepository.getNonCompleteStatusCnt(myOrderSub);

        //한 상품에 대해서 더이상 처리할 주문건수가 없는 경우
        if( nonCnt <= 0 ){
            int totpayment = orderManageRepository.getTotalPaymentByOmnum(myOrderSub);

            if( totpayment > 0 ) {
                TbKfoMbsPoint tb_po = new TbKfoMbsPoint();
                tb_po.setMP_OSSEQ(myOrderSub.getOsSeq());
                tb_po.setMP_OMNUM(myOrderSub.getOsOmNum());
                tb_po.setMP_USERID(myOrderSub.getOsOwnerId());
                tb_po.setMP_AMOUNT(totpayment);
                tb_po.setMP_TYPE(MyPointCode.ORDER.getCode());
                myPointService.modifyPointProcess(tb_po);
            }
        }
    }

    /**
     * 구매 확정시 모든 상태값 비교 후 포인트 부여
     * @return
     * @param myOrderSub
     */
    public boolean processCompleteOrderForPoint(OrderSub myOrderSub) {
        myOrderSub.setOsPrCode(null);   //전체 비교 시 prcode 제거 (이후 getAvailableEvent() 에 prcode 사용 안 한다.)
        int nonCnt = orderManageRepository.getNonCompleteStatusCnt(myOrderSub);

        //더이상 처리할 주문건수가 없는 경우
        if( nonCnt <= 0 ){
            TbKfoMbsPoint tb_po = new TbKfoMbsPoint();
            int totpayment = orderManageRepository.getTotalPaymentByOmnum(myOrderSub);

            if( totpayment > 0 ){
                myOrderSub.setOsTotSaleMoney(totpayment);
                getAvailableEvent(myOrderSub);
            }
        }
        return true;
    }

    @Override
    public boolean stockCheckForProductIdByOrderSub(Integer osSequence, int exchangeEa) {
        String productId = orderManageRepository.getProductIdByOrderSub(osSequence);
        Stock stockData = stockService.get(productId, Country.isDomestic(Country.Korea));
        return stockData.getAvailableStock() < exchangeEa;
    }

    private boolean getAvailableEvent(OrderSub myOrderSub) {
        String codeDG = EventOrderType.DOMESTIC.getCode(); //D국내, G해외
        if(!myOrderSub.getOsDeliInOutType().equals(DeliInOutType.DOMESTIC.getCode())){
            codeDG = EventOrderType.GLOBAL.getCode();
        }
        //국내이벤트
        EventDto eventDto = new EventDto();
        eventDto.setOrderType(codeDG);
        eventDto.setEventType(EventType.POINT.getCode());
        eventDto.setOrderPrice(myOrderSub.getOsTotSaleMoney());
        eventDto.setEventDate(myOrderSub.getOsInDate());
        //구매정보에 대한 지급될 포인트 조회
        eventDto = domesticEvent.getAddPointEvent(eventDto);
        if( eventDto != null && eventDto.getPaymentPrice() > 0 ){
            TbKfoMbsPoint tb_po = new TbKfoMbsPoint();
            tb_po.setMP_OMNUM(myOrderSub.getOsOmNum());
            tb_po.setMP_USERID(myOrderSub.getOsOwnerId());
            tb_po.setMP_AMOUNT((int)eventDto.getPaymentPrice());
            tb_po.setMP_TYPE(MyPointCode.GIFT.getCode());
            tb_po.setMP_TITLE(eventDto.getEventTitle());
            tb_po.setMP_ETITLE(eventDto.getEventTitleEn());
            myPointService.modifyPointProcess(tb_po);
        }
        return true;
    }
}