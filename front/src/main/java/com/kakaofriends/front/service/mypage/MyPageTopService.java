package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;

import java.util.Map;

/**
 * 마이페이지 상단 정보조회 layla.rae 2017.10.25
 */
public interface MyPageTopService {

    Map<String, Object> myPageTopData(String userId, OrderStatusType[] getShippingCount, OrderStatusType[] getCancelingCount); // 마이페이지 상단정보 한번에 가져오기
}