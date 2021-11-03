package com.kakaofriends.front.service.order.api;

import com.kakaofriends.front.service.order.vo.Order;

/**
 * OrderService
 *
 * Author  april
 * Date    2018. 3. 16.
 */
public interface OrderService {
    Order get(String orderNumber);

    void add(Order order);

    void addByPreOrder(String orderNumber, String pgTid);
}