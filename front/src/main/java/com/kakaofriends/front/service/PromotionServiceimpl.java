package com.kakaofriends.front.service;

import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.PromotionExpansion;
import com.kakaofriends.front.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PromotionServiceimpl implements PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	@Override
	public PromotionExpansion findByPrmSeq(Long prmSeq) {
		PromotionExpansion promotionExpansion = promotionRepository.findByPrmSeq(prmSeq);
		promotionExpansion.getSuggestedProducts().stream().forEach(i -> {
			i.getProductLevelPrice().setExchangeDiscountPrice(getExchangePrice(i.getProductLevelPrice().getPrlpDiscountprice1()));
			i.getProductLevelPrice().setExchangePrice(getExchangePrice(i.getProductLevelPrice().getPrlpSaleprice1()));
		});
		return promotionExpansion;
	}

	private double getExchangePrice(double price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
	}
}
