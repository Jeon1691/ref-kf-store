package com.kakaofriends.front.service.order.address;

import com.kakaofriends.front.service.order.vo.OrderAddress;

/**
 * OrderAddressService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface OrderAddressService {
    OrderAddress get(String orderNumber);

    void add(OrderAddress orderAddress);
}
