package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.core.domain.OrderSubHistory;

import java.util.List;
import java.util.stream.Collectors;

public class OrderSubHistoryDto {
    public static class initializeDomains{
        // 주문 취소시 OrderSubHistory 생성 후 초기화
        public static List<OrderSubHistory> initializeOrderSubHistoryForOrderCancel(String ownerId, List<OrderSubDto.OrderSubShipping> myOrderSubList, OrderStatusType orderStatusType) {
            return myOrderSubList.stream().map(e ->
                    OrderSubHistory.builder()
                            .oshSeq(null)
                            .oshOmNum(e.getOrderSub().getOsOmNum())
                            .oshOsSerial(e.getOrderSub().getOsSerial())
                            .oshMemo(orderStatusType.getName())
                            .oshOsStatus(orderStatusType)
                            .oshMoId(ownerId)
                            .oshInId(ownerId)
                            .oshMoDate(null)
                            .oshInDate(null)
                            .build()
            ).collect(Collectors.toList());
        }

        // 구매 확정, 반품, 교환 시 OrderSubHistory 초기화
        public static OrderSubHistory initializeOrderSubHistoryByOrderStatus(String ownerId, OrderSub orderSub, OrderStatusType orderStatusType) {
            return OrderSubHistory.builder()
                    .oshSeq(null)
                    .oshOmNum(orderSub.getOsOmNum())
                    .oshOsSerial(orderSub.getOsSerial())
                    .oshMemo(orderStatusType.getName())
                    .oshOsStatus(orderStatusType)
                    .oshMoId(ownerId)
                    .oshInId(ownerId)
                    .oshMoDate(null)
                    .oshInDate(null)
                    .build();
        }

        // 부분반품, 교환, 부분교환 시 OrderSubHistory 초기화
        public static OrderSubHistory initializeOrderSubHistoryByOrderStatus(String ownerId, OrderSub orderSub, OrderStatusType orderStatusType, int osSerial) {
            return OrderSubHistory.builder()
                    .oshSeq(null)
                    .oshOmNum(orderSub.getOsOmNum())
                    .oshOsSerial(osSerial)
                    .oshMemo(orderStatusType.getName())
                    .oshOsStatus(orderStatusType)
                    .oshMoId(ownerId)
                    .oshInId(ownerId)
                    .oshMoDate(null)
                    .oshInDate(null)
                    .build();
        }
    }
}
