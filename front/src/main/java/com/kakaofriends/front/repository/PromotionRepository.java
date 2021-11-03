package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.PromotionExpansion;
import org.springframework.stereotype.Repository;

@PrimaryMapper
@Repository
public interface PromotionRepository {

	PromotionExpansion findByPrmSeq(Long prmSeq);

}
