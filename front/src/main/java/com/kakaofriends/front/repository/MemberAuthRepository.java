package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.MemberAuth;
import org.springframework.stereotype.Repository;

@PrimaryMapper
@Repository
public interface MemberAuthRepository {
	int preAuth(MemberAuth memberAuth);

	int insert(MemberAuth memberAuth);

	String auth(MemberAuth memberAuth);

	int afterAuth(MemberAuth memberAuth);

	int getCountSmsAuth(MemberAuth memberAuth);

	int isResendable(MemberAuth memberAuth);

}