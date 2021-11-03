package com.kakaofriends.front.service.payment;

import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistory;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.service.order.vo.OrderMain;

/**
 * PaymentHistoryService
 *
 * Author  april
 * Date    2017. 12. 18.
 */
public interface PaymentHistoryService {
    void add(PaymentHistory history);

    void add(PaymentHistoryType type, PaymentAction paymentAction, OrderMain orderMain);
}
