package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.PromotionExpansion;
import com.kakaofriends.front.repository.PromotionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.FRIENDS_CATEGORY_THEME_CODE;

/**
 * PromotionServiceTest
 * <p>
 * Author  layla
 * Date    2018. 6. 20.
 */
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class PromotionServiceTest {

	@Autowired
	private PromotionRepository promotionRepository;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	@Test
	public void select() {
		PromotionExpansion promotionExpansion = promotionRepository.findByPrmSeq((long)126);
		promotionExpansion.getSuggestedProducts().stream().forEach(i -> {
			i.getProductLevelPrice().setExchangeDiscountPrice(getExchangePrice(i.getProductLevelPrice().getPrlpDiscountprice1()));
			i.getProductLevelPrice().setExchangePrice(getExchangePrice(i.getProductLevelPrice().getPrlpSaleprice1()));
		});

		//System.out.println(promotionExpansion.getSuggestedProducts());
	}

	private double getExchangePrice(double price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
	}
}
