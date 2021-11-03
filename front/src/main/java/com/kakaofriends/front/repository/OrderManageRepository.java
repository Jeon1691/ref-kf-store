package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.*;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderSubDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface OrderManageRepository {

    int updateOrderAddressByOrderNumber(OrderAddressDto.request orderAddressRequest);

    void updateOrderAddressBuyerInfo(@Param("buyerName") String buyerName, @Param("buyerEmail") String buyerEmail, @Param("oaOmNum") String oaOmNum);

    OrderAddress findOrderAddressByOrderNumber(String orderNumber);				// 주문 번호로 주소지 SELECT

    int updateGiftCardForOrderCancel(@Param("orderNumber") String orderNumber, @Param("giftCard") GiftCard giftCard);

    int insertOrderSubHistoryForOrderCancel(@Param("orderSubHistoryList") List<OrderSubHistory> orderSubHistoryList);

    int updateOrderSubForOrderCancel(@Param("orderSubShippingList") List<OrderSubDto.OrderSubShipping> orderSubShippingList);

    int updateOrderSubForReturnRequestAll(@Param("orderSubShippingList") List<OrderSubDto.OrderSubShipping> orderSubShippingList);

    int updateOrderSubDeliveryForOrderCancel(@Param("orderNumber") String orderNumber, @Param("moId") String moId, @Param("cancelStatus") String cancelStatus);

    int updateOrderSubByOrderStatus(OrderSub myOrderSub);

    int insertOrderSubHistorByOrderStatus(OrderSubHistory orderSubHistory);

    @Select("SELECT OM_COUPONMONEY FROM ORDERMAIN WHERE OM_NUM = #{orderNumber}")
    int findCouponMoneyByUserIdAndOrderNumberToOrderMain(@Param("orderNumber") String orderNumber);

    int insertSales(Sales sales);

    void updateOrderSubForPartition(OrderSub orderSub);

    int insertOrderSubForPartition(OrderSub orderSub);

    int getNonCompleteStatusCnt(OrderSub orderSub);

    int getTotalPaymentByOmnum(OrderSub orderSub);

    //inner join 으로 멤버 확인
    List<OrderSub> getPriceListByAllOrderSubStatus();// 모든 상태값이 완료인 주문 정보 리스트 (주문번호 결제금액)

    int getPurchaseMoneyByPrcodeStatus(OrderSub myOrderSub);

    String getProductIdByOrderSub(Integer osSequence); ////ordersub seq를 통해 상품코드 SELECT
}