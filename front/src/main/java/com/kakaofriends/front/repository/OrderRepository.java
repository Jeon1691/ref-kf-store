package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface OrderRepository {

    String getPaypalSaleIdByTid(String tid);

	List<OrderSheetExpansion> findByOrderSheetCodeListFromBasketSeq(@Param("orderSheetBsSeqList") List<Long> orderSheetBsSeqList, @Param("ownerId") String ownerId, @Param("exchangeRate") double exchangeRate, @Param("domestic") boolean domestic);
}