package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.repository.MyPageTopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 마이페이지 상단 정보조회 layla.rae 2017.10.25
 */
@Slf4j
@Service
public class MyPageTopServiceImpl implements MyPageTopService {

    @Autowired
    private MyPageTopRepository myPageTopRepository;

    /**
     * 마이페이지 상단 - 적립포인트(+사용가능포인트), 배송중, 취소 및 교환, 쿠폰
     * @param userId, orderStatus, getCancelingCount
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> myPageTopData(String userId, OrderStatusType[] getShippingCount, OrderStatusType[] getCancelingCount) {
        return myPageTopRepository.myPageTopData(userId, getShippingCount, getCancelingCount);
    }
}
