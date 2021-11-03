package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.PromotionExpansion;

public interface PromotionService {

	PromotionExpansion findByPrmSeq(Long promotionSeq);
}
