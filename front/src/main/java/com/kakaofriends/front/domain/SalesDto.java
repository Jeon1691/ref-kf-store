package com.kakaofriends.front.domain;

import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.core.domain.Sales;

/**
 * Created by seott on 2016-10-20.
 */
public class SalesDto {
    public static class initializeDomains{
        // 구매 확정 시 매출 등록 할 경우 Sales 초기화
        public static Sales initializeSales(String ownerId, OrderSub orderSub) {
            return Sales.builder()
                    .ssSeq(null)
                    .ssOmNum(orderSub.getOsOmNum())
                    .ssOsSerial(orderSub.getOsSerial())
                    .ssScpCode(orderSub.getOsScpCode())
                    .ssBcpCode(orderSub.getOsBcpCode())
                    .ssMbId(orderSub.getOsMoId())
                    .ssAccountMoney(orderSub.getOsAccountMoney())
                    .ssCardMoney(orderSub.getOsCardMoney())
                    .ssKakaoMoney(orderSub.getOsKakaoMoney())
                    .ssPhoneMoney(orderSub.getOsPhoneMoney())
                    .ssCouponMoney(orderSub.getOsCouponMoney())
                    .ssOriginalMoney(orderSub.getOsOriginalMoney())
                    .ssSaleMoney(orderSub.getOsSaleMoney())
                    .ssTotOriginalMoney(orderSub.getOsTotOriginalMoney())
                    .ssTotSaleMoney(orderSub.getOsTotSaleMoney())
                    .ssDpCode(orderSub.getOsBdpCode())
                    .ssMoneyUnit(orderSub.getOsAccessType().equals("1") || orderSub.getOsAccessType().equals("5") ? "won" : "dollar")
                    .ssCalculateBUse("N")
                    .ssCalculateSUse("N")
                    .ssMoId(ownerId)
                    .ssInId(ownerId)
                    .build();
        }
    }
}
