package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderInfo;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.repository.MyOrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MyOrderedServiceImpl implements MyOrderedService {

	@Autowired
	MyOrderedRepository myOrderedRepository;

	@Override
	public int findByMyOrderListAllCount(String userId) {
		return myOrderedRepository.findByMyOrderListAllCount(userId);
	}

	@Override
	public List<OrderInfo> findByMyOrderListAll(String userId, PaginationInfo pagination) {
		return myOrderedRepository.findByMyOrderListAll(userId, pagination);
	}

	@Override
	public int findByMyCancelListAllCount(String userId, OrderStatusType[] cancelListViewConditionArr) {
		return myOrderedRepository.findByMyCancelListAllCount(userId, cancelListViewConditionArr);
	}

	@Override
	public List<OrderInfo> findByMyCancelListAll(String userId, Map<String, OrderStatusType[]> cancelListViewConditionMap, PaginationInfo pagination) {
		return myOrderedRepository.findByMyCancelListAll(userId, cancelListViewConditionMap, pagination);
	}

	@Override
	public OrderShippingInfo findOrderShippingInfoByUserIdAndOrderNumber(String userId, String orderNumber) {
		return myOrderedRepository.findOrderShippingInfoByUserIdAndOrderNumber(userId, orderNumber);
	}

	@Override
	public OrderShippingInfo findOrderShippingInfoByNonmemberNameAndOrderNumber(String nonmemberName, String orderNumber, String orderMail) {
		return myOrderedRepository.findOrderShippingInfoByNonmemberNameAndOrderNumber(nonmemberName, orderNumber, orderMail);
	}

	@Override
	public OrderShippingInfo findOrderShippingInfoByOwnerNameAndOrderNumberForComplete(String ownerName, String orderNumber) {
		return myOrderedRepository.findOrderShippingInfoByOwnerNameAndOrderNumberForComplete(ownerName, orderNumber);
	}

	@Override
	public List<OrderAddressDto.request> findRecentOrderAddress(String userId) {
		return myOrderedRepository.findRecentOrderAddress(userId);
	}

	@Override
	public OrderSubDto.OrderSubShipping findOrderSubWithPrImageByOrderSubSequence(Integer orderSequence) {
		return myOrderedRepository.findOrderSubWithPrImageByOrderSubSequence(orderSequence);
	}
}
