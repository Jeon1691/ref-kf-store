package com.kakaofriends.front.service.order.cancel;

import com.kakaofriends.front.common.exception.OrderManageException;

import javax.servlet.http.HttpServletRequest;

public interface OrderCancelProcessService {

	// 회원
	boolean orderCancelToOrderSubList(HttpServletRequest httpServletRequest, String ownerId, String oId) throws OrderManageException;

	// 비회원
	boolean orderCancelToOrderSubListForNonMember(HttpServletRequest httpServletRequest, String ownerId, String ownerName, String oId, String orderMail) throws OrderManageException;

	void orderRefund(String memberId, String orderId) throws Exception;
}