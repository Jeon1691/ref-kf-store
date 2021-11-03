package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.repository.OrderAddDeliRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
public class OrderApiServiceImpl implements OrderApiService {

    @Autowired
    private OrderAddDeliRepository orderAddDeliRepository;

    @Override
    public void updateOrderAddDlie(OrderAddDeli orderAddDeli) throws Exception {
        orderAddDeliRepository.updateOrderAddDeliByPayment(orderAddDeli);

        //회수비 결제된 상품과 같은 주문번호를 가진 상품들 회수비 단위 업데이트
        orderAddDeliRepository.updateLeftProduct(orderAddDeli);
    }

}
