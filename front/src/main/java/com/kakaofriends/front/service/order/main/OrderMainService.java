package com.kakaofriends.front.service.order.main;

import com.kakaofriends.front.service.order.vo.OrderMain;

/**
 * OrderMainService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface OrderMainService {
    OrderMain get(String orderNumber);

    void add(OrderMain orderMain);
}
