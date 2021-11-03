package com.kakaofriends.front.controller.order;

import com.kakaofriends.front.service.giftcard.GiftCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/{language}")
public class OrderRestController {
	@Autowired
	private GiftCardService giftCardService;

	@Value("#{orderValidator}")
	private Validator orderValidator;

	// 유효 쿠폰 확인
	@RequestMapping(value = "/order/applyGiftCard")
	public Object confirmGiftCard(@PathVariable("language") String language, String couponNum, int totalAmt, int totalAmtNoDeli) {
		return giftCardService.confirmGiftCardNumber(language, couponNum, totalAmt, totalAmtNoDeli);
	}
}