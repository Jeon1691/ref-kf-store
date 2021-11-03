package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.EventDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Dave on 2017. 4. 27..
 */

@Repository
@PrimaryMapper
public interface EventRepository {
    EventDto findEvent(@Param(value = "orderType") String orderType, @Param(value = "eventType") String eventType, @Param(value = "orderPrice") double orderPrice, @Param(value = "useYn") String useYn, @Param(value = "eventDate") Date eventDate);
}
