package com.kakaofriends.front.service.order.main;

import com.kakaofriends.front.service.order.vo.PreOrderMain;

/**
 * PreOrderMainService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface PreOrderMainService {
    PreOrderMain get(String orderNumber);

    void add(PreOrderMain preOrderMain);

    void edit(PreOrderMain preOrderMain);
}