package com.kakaofriends.front.service.order.sub;

import com.kakaofriends.front.service.order.vo.PreOrderSub;

import java.util.List;

/**
 * PreOrderSubService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface PreOrderSubService {
    List<PreOrderSub> getList(String orderNumber);

    void addList(List<PreOrderSub> preOrderSubList);

    void edit(PreOrderSub preOrderSub);
}