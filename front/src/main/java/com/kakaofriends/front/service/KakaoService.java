package com.kakaofriends.front.service;

import com.kakaofriends.core.domain.Friend;
import com.kakaofriends.front.domain.SessionInfo;
import com.kakaofriends.front.domain.SessionLimit;

import java.util.List;
import java.util.Map;

public interface KakaoService {

	List<Friend> findFrontIndexProductList();

	List<SessionInfo> findAllSessionInfo();

	void insertSessionInfo(SessionInfo build);

	List<String> findAllSessionInfoForSessionId();

	SessionLimit findSessionLimit();

	int deleteBySessionId(String sessionId);

	Map<String, Object> findFriendsMain(String lang, String ownerId);
}