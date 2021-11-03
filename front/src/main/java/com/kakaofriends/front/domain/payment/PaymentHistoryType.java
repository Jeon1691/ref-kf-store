package com.kakaofriends.front.domain.payment;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import lombok.extern.slf4j.Slf4j;

/**
 * PaymentHistoryType : 결제 이력의 종류 enum
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@Slf4j
public enum PaymentHistoryType {
    ORDER,
    EXCHANGE,
    REFUND;

    /**
     * 주문 상태에 맞는 이력 타입를 반환한다.
     *
     * @param orderStatusType 주문 상태 정보
     * @return 주문 상태에 맞는 이력 종류
     */
    public static PaymentHistoryType converts(OrderStatusType orderStatusType) {
        switch (orderStatusType) {
            case PARTIAL_RETURN_APPLICATION:
            case RETURN_APPLICATION:
                return REFUND;
            case PARTIAL_EXCHANGE_APPLICATION:
            case EXCHANGE_APPLICATION:
                return EXCHANGE;
            default:
                log.debug("### Found Other OrderStatusType = {}", orderStatusType);
                return null;
        }
    }
}
