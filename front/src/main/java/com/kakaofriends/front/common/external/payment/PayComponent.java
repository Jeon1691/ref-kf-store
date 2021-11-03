package com.kakaofriends.front.common.external.payment;

import com.kakaofriends.front.domain.payment.PayCancel;
import com.kakaofriends.front.domain.payment.PayCancelResultData;
import com.kakaofriends.front.domain.payment.PayMethodType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PayComponent {

	List<PayMethodType> getPayMethodType();

	PayCancelResultData cancelProcessing(HttpServletRequest httpServletRequest, PayCancel payCancel);
}