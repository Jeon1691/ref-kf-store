package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.KakaoPayConfirm;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.springframework.stereotype.Repository;

@Repository
@PrimaryMapper
public interface KakaoPayConfirmRepository {

	int kakaoPayConfirmInsert(KakaoPayConfirm kakaopayConfirm);
}
