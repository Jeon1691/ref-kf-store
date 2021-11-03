package com.kakaofriends.front.service.mypage;

import com.kakaofriends.front.domain.OrderTracking;

import java.util.List;

/**
 * Created by Dave on 2017. 5. 12..
 */
public interface OrderTrackingService {
    List<OrderTracking> getTrakingBoxInfoByOrderNum(String orderNum);

    List<OrderTracking> getTrakingBoxDetailInfoByBoxPk(String boxPk);
}
