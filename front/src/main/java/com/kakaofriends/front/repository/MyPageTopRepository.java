package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 마이페이지 상단 정보조회 layla.rae 2017.10.25
 */
@Repository
@PrimaryMapper
public interface MyPageTopRepository {

    Map<String, Object> myPageTopData(@Param("userId") String userId, @Param("getShippingCount") OrderStatusType[] getShippingCount, @Param("getCancelingCount") OrderStatusType[] getCancelingCount); // 마이페이지 상단정보 한번에 가져오기
}
