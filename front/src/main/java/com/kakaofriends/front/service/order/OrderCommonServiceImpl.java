package com.kakaofriends.front.service.order;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.kakaofriends.front.domain.order.OrderCommonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
/**
 * OrderCommonServiceImpl
 *
 * Author  layla
 * Date    2018. 01. 11.
 */
@Slf4j
@Service
@EnableAsync
public class OrderCommonServiceImpl implements OrderCommonService {

	@Value("${mail.smtp.sender.name}")
	private String kakaoFriendsOnlineStore;

	@Value("${pgKakaopay.merchantId}")
	private String pgKakaopayMerchantId;
	@Value("${pgKakaopay.merchantUrl}")
	private String pgKakaopayMerchantUrl;
	@Value("${pgKakaopay.webPath}")
	private String pgKakaopayWebPath;
	@Value("${pgKakaopay.msgName}")
	private String pgKakaopayMsgName;
	@Value("${pgKakaopay.merchantEncKey}")
	private String pgKakaopayMerchantEncKey;
	@Value("${pgKakaopay.merchantHashKey}")
	private String pgKakaopayMerchantHashKey;

	@Value("${paypal.button.mode}")
	private String paypalButton;

	@Override
	public OrderCommonVO getOrderCommonData(UserAgent userAgent, String freidnsLocale) {
		OrderCommonVO orderCommonVo = new OrderCommonVO();
		orderCommonVo.setUserAgent(userAgent);
		orderCommonVo.setFriendsLocale(freidnsLocale);
		orderCommonVo.setKakaoFriendsOnlineStore(kakaoFriendsOnlineStore);
		orderCommonVo.setPgKakaopayMerchantId(pgKakaopayMerchantId);
		orderCommonVo.setPgKakaopayMerchantUrl(pgKakaopayMerchantUrl);
		orderCommonVo.setPgKakaopayWebPath(pgKakaopayWebPath);
		orderCommonVo.setPgKakaopayMsgName(pgKakaopayMsgName);
		orderCommonVo.setPgKakaopayMerchantEncKey(pgKakaopayMerchantEncKey);
		orderCommonVo.setPgKakaopayMerchantHashKey(pgKakaopayMerchantHashKey);
		orderCommonVo.setPaypalButton(paypalButton);
		return orderCommonVo;
	}
}