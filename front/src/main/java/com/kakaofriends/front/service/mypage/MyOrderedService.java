package com.kakaofriends.front.service.mypage;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderInfo;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;

import java.util.List;
import java.util.Map;

public interface MyOrderedService {

    int findByMyOrderListAllCount(String userId);   // 주문 내역 Count

    List<OrderInfo> findByMyOrderListAll(String userId, PaginationInfo pagination); // 주문 내역 List

    int findByMyCancelListAllCount(String userId, OrderStatusType[] cancelListViewConditionArr);    // 취소 내역 Count

    List<OrderInfo> findByMyCancelListAll(String userId, Map<String, OrderStatusType[]> cancelListViewConditionMap, PaginationInfo pagination); // 취소 내역 List

    OrderShippingInfo findOrderShippingInfoByUserIdAndOrderNumber(String userId, String orderNumber);   // 주문 상세 - Where : userId, orderNumber

    OrderShippingInfo findOrderShippingInfoByNonmemberNameAndOrderNumber(String nonmemberName, String orderNumber, String orderMail); // 주문 상세 - Where : nonmember, orderNumber

    OrderShippingInfo findOrderShippingInfoByOwnerNameAndOrderNumberForComplete(String ownerName, String orderNumber);

    List<OrderAddressDto.request> findRecentOrderAddress(String userId);

    OrderSubDto.OrderSubShipping findOrderSubWithPrImageByOrderSubSequence(Integer orderSequence);  // 주문 단일 품목 상세 - Where : orderSubSequence
}
