package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.EventDto;

import java.util.Date;

/**
 * Created by eunduck on 2017. 11. 22..
 */
public interface EventService {

    EventDto findEvent(String orderType, String eventType, double orderPirce, String useYn, Date eventDate);

    /**
     * 현재 진행중인 이벤트를 조회한다.
     * @param orderType 주문 타입
     * @param eventType 이벤트 타입
     * @param orderPrice 주문 금액
     *
     * @return 현재 사용중인 이벤트
     */
    EventDto getCurrentEvent(String orderType, String eventType, double orderPrice);
}
