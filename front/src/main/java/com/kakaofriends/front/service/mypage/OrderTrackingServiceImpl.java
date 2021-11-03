package com.kakaofriends.front.service.mypage;

import com.kakaofriends.front.domain.OrderTracking;
import com.kakaofriends.front.repository.OrderTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dave on 2017. 5. 12..
 */
@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

    @Autowired
    private OrderTrackingRepository orderTrackingRepository;

    @Override
    public List<OrderTracking> getTrakingBoxInfoByOrderNum(String orderNum) {
        return orderTrackingRepository.getTrakingBoxInfoByOrderNum(orderNum);
    }

    @Override
    public List<OrderTracking> getTrakingBoxDetailInfoByBoxPk(String boxPk) {
        return orderTrackingRepository.getTrakingBoxDetailInfoByBoxPk(boxPk);
    }
}
