package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.front.domain.payment.PayResultData;
import com.kakaofriends.front.repository.OrderTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTempServiceImpl implements OrderTempService {

	@Autowired
	private OrderTempRepository orderTempRepository;

	@Override
	public OrderMain orderMainMobileTempSelect(PayResultData payResultData) {
		return orderTempRepository.orderMainMobileTempSelect(payResultData);
	}
}
