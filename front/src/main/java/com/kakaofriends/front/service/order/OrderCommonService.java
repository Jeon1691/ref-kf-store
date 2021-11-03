package com.kakaofriends.front.service.order;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.kakaofriends.front.domain.order.OrderCommonVO;

/**
 * OrderCommonService
 *
 * Author  layla
 * Date    2018. 01. 11.
 */
public interface OrderCommonService {

	OrderCommonVO getOrderCommonData(UserAgent userAgent, String freidnsLocale);
}