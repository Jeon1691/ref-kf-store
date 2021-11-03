package com.kakaofriends.front.service.order.api;

import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.vo.PreOrder;

/**
 * PreOrderService
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public interface PreOrderService {

    PreOrder get(String orderNumber);

    /**
     * 결제 전 데이터를 입력한다.
     *
     * @param preOrder 결제 정보
     */
    void add(PreOrder preOrder);

    /**
     * 결제 상태를 수정한다.
     *
     * @param orderNumber 주문 번호
     * @param paymentStatus 변경될 결제 상태
     */
    void editPaymentStatus(String orderNumber, PaymentStatus paymentStatus);
}
