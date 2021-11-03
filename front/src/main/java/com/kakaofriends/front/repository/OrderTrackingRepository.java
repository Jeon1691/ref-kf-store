package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.OrderTracking;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dave on 2017. 5. 12..
 */

@PrimaryMapper
@Repository
public interface OrderTrackingRepository {
    List<OrderTracking> getTrakingBoxInfoByOrderNum(String orderNum);

    List<OrderTracking> getTrakingBoxDetailInfoByBoxPk(String boxPk);
}
