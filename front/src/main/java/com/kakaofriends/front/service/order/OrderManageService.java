package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderSubDto;

import javax.servlet.http.HttpServletRequest;

public interface OrderManageService {

    OrderSub findOrderSubByUserIdAndOrderSubSequence(String userId, int orderSubSequence);    // OrderSub SELECT

    boolean updateOrderAddressByOrderNumber(OrderAddressDto.request orderAddressRequest, String sessionOwnerName, String sessionOId, String sessionOrderMail) throws OrderManageException;                                            // 배송지 변경

    boolean updateOrderBuyerInfo(HttpServletRequest request, OrderAddressDto.request orderAddressRequest, String sessionOwnerName, String sessionOId, String sessionOrderMail) throws OrderManageException;

    // 회원

    boolean purchaseFinalizedToOrderSub(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;      // 구매 확정

    boolean orderSubReturnRequestAll(String ownerId, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 전체 반품 신청

    boolean orderSubReturnRequest(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 반품 신청

    boolean orderSubExchangeRequest(String ownerId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 교환 신청

    // 비회원

    boolean purchaseFinalizedToOrderSubForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;      // 구매 확정

    boolean orderSubReturnRequestAllForNonMember(String ownerId, String sessionOwnerName, String sessionOId, String sessionOrderMail, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 전체 반품 신청

    boolean orderSubReturnRequestForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 반품 신청

    boolean orderSubExchangeRequestForNonMember(String ownerId, String sessionOwnerName, String sessionOId, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException;            // 교환 신청

    void purchaseFinalizedToPoint(OrderSub myOrderSub) ;

    boolean processCompleteOrderForPoint(OrderSub ordersub ) throws OrderManageException;

    boolean stockCheckForProductIdByOrderSub(Integer osSequence, int exchangeEa); //ordersub seq를 통해 조회한 상품코드로 재고체크
}