package com.kakaofriends.front.service.order.sub;


import com.kakaofriends.front.service.order.vo.OrderSub;

import java.util.List;

/**
 * OrderSubService
 *
 * Author  april
 * Date    2017. 12. 26.
 */
public interface OrderSubService {
    OrderSub get(long sequence);

    OrderSub get(String orderNumber, int serial);

    List<OrderSub> getList(String orderNumber);

    List<OrderSub> getList(OrderSub orderSub);

    void addList(List<OrderSub> orderSubList);
}
