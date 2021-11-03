package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface OrderAddDeliRepository {
	OrderAddDeli findOrderAddDeliListByOrderNumberAndOrderStatus(@Param("orderNumber") String orderNumber, @Param("orderStatus") OrderStatusType orderStatus);

	List<OrderAddDeli> findOrderAddDeliListByPaymentEndOrderNumberAndOrderStatus(@Param("orderNumber") String orderNumber, @Param("orderStatus") OrderStatusType orderStatus);

	OrderAddDeli findOrderAddDeliByOrderNumberAndOrderSubSeq(@Param("orderNumber") String orderNumber, @Param("orderSubSeq") int orderSubSeq, @Param("orderSubSerial") int orderSubSerial);

	int updateOrderAddDeliByPayment(OrderAddDeli orderAddDeli);

	int updateOrderAddDeliByError(OrderAddDeli orderAddDeli);

	int updateLeftProduct(OrderAddDeli orderAddDeli);
}