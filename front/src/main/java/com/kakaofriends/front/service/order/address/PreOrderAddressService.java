package com.kakaofriends.front.service.order.address;

import com.kakaofriends.front.service.order.vo.PreOrderAddress;

/**
 * PreOrderAddressService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface PreOrderAddressService {
    PreOrderAddress get(String orderNumber);

    void add(PreOrderAddress orderAddress);
}
