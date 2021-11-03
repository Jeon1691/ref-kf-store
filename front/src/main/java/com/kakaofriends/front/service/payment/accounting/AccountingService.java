package com.kakaofriends.front.service.payment.accounting;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;

import java.util.List;

/**
 * AccountingService
 *
 * Author  april
 * Date    2018. 3. 9.
 */
public interface AccountingService {
    /**
     * 회계정보 목록을 조회한다.
     *
     * @param orderNumber 주문 번호
     * @return 회계정보 목록
     */
    List<Accounting> getList(String orderNumber, PaymentAction paymentAction);

    /**
     * 회계 정보를 입력한다.
     *
     * @param accounting
     */
    void add(Accounting accounting);

    /**
     * 회계 정보를 입력한다.
     *
     * @param payType 결제 수단
     * @param paymentAction 결제 행위 (결제/취소)
     * @param orderSubList 주문 상세 정보 리스트
     */
    void addList(PayType payType, PaymentAction paymentAction, List<OrderSub> orderSubList);
}
