package com.kakaofriends.front.domain;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.api.PaymentGateway;

/**
 * Currency : 화폐 enum
 *
 * Author  april
 * Date    2017. 12. 18.
 */
public enum Currency {
    KRW,
    USD;

    /**
     * 문자열을 읽어 Currency 를 반환한다.
     *
     * @param currency 화폐 enum
     * @return 기본값은 CURRENCY.KRW, 절대 null을 반환하지 않는다.
     */
    public static Currency getCurrency(String currency) {
        for (Currency one : Currency.values()) {
            if (one.name().equals(currency)) {
                return one;
            }
        }
        return KRW;
    }

    public static Currency getCurrency(PayType payType) {
        switch (payType) {
            case PAYPAL:
                return USD;
            default:
                return KRW;
        }
    }

    public static Currency getCurrency(PaymentGateway pg) {
        switch (pg) {
            case INICIS:
            case KAKAOPAY:
                return KRW;
            case PAYPAL:
                return USD;
            default:
                return KRW;
        }
    }
}
