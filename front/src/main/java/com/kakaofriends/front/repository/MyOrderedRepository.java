package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderInfo;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@PrimaryMapper
@Repository
public interface MyOrderedRepository {

	List<OrderSub> findOrderSubListByUserIdAndOrderNumber(@Param("userId") String userId, @Param("orderNumber") String orderNumber);

	OrderSub findOrderSubByUserIdAndOrderSubSequence(@Param("userId") String userId, @Param("orderSubSequence") int orderSubSequence);

	List<ProductExpansion> findByOrderProductCode(String productCode);

	int findByMyOrderListAllCount(String userId);

	List<OrderInfo> findByMyOrderListAll(@Param("userId") String userId, @Param("pagination") PaginationInfo Pagination);

	int findByMyCancelListAllCount(@Param("userId") String userId, @Param("cancelListViewConditionArr") OrderStatusType[] cancelListViewConditionArr);

	List<OrderInfo> findByMyCancelListAll(@Param("userId") String userId, @Param("cancelListViewConditionMap") Map<String, OrderStatusType[]> cancelListViewConditionMap, @Param("pagination") PaginationInfo Pagination);

	OrderShippingInfo findOrderShippingInfoByUserIdAndOrderNumber(@Param("userId") String userId, @Param("orderNumber") String orderNumber);

	OrderShippingInfo findOrderShippingInfoByNonmemberNameAndOrderNumber(@Param("nonmemberName") String nonmemberName, @Param("orderNumber") String orderNumber, @Param("orderMail") String orderMail);

	OrderShippingInfo findOrderShippingInfoByOwnerNameAndOrderNumberForComplete(@Param("ownerName") String ownerName, @Param("orderNumber") String orderNumber);

	List<OrderAddressDto.request> findRecentOrderAddress(@Param("userId") String userId);

	OrderSubDto.OrderSubShipping findOrderSubWithPrImageByOrderSubSequence(@Param("orderSubSequence") int orderSubSequence);

	OrderSub findOrderSubByOwnerNameAndOrderSubSequence(@Param("ownerName") String ownerName, @Param("orderSubSequence") int orderSubSequence); // 비회원 OrderSub SELECT, 조건 : ownerName, orderSubSequence
}