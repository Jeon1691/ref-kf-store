package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.EventDto;
import com.kakaofriends.front.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by eunduck on 2017. 11. 22..
 */
@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    public EventDto findEvent(String orderType, String eventType, double orderPirce, String useYn, Date eventDate) {
        return eventRepository.findEvent(orderType, eventType, orderPirce, useYn, eventDate);
    }

    @Override
    @Transactional(readOnly = true)
    public EventDto getCurrentEvent(String orderType, String eventType, double orderPrice) {
        return this.findEvent(orderType, eventType, orderPrice, "Y", new Date());
    }
}
