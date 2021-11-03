package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.front.domain.payment.PayResultData;

public interface OrderTempService {

	OrderMain orderMainMobileTempSelect(PayResultData payResultData);

}
