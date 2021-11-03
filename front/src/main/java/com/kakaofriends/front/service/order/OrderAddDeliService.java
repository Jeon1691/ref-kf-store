package com.kakaofriends.front.service.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.domain.OrderAddDeli;

import java.util.List;

public interface OrderAddDeliService {
    OrderAddDeli findOrderAddDeliListByOrderNumberAndOrderStatus (String orderNumber, OrderStatusType orderStatusType);

    List<OrderAddDeli> findOrderAddDeliListByPaymentEndOrderNumberAndOrderStatus (String orderNumber, OrderStatusType orderStatusType);

    OrderAddDeli findOrderAddDeliByOrderNumberAndOrderSubSeq(String orderNumber, int OrderSubSeq, int OrderSubSerial);

    int updateOrderAddDeliByPayment(OrderAddDeli orderAddDeli);

    int updateOrderAddDeliByError(OrderAddDeli orderAddDeli);

    int updateLeftProduct(OrderAddDeli orderAddDeli);
}
