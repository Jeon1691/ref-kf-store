package com.kakaofriends.front.service;

import com.kakaofriends.core.domain.Friend;
import com.kakaofriends.front.domain.SessionInfo;
import com.kakaofriends.front.domain.SessionLimit;
import com.kakaofriends.front.repository.KakaoRepository;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KakaoServiceImpl implements KakaoService {

	@Autowired
	private KakaoRepository friendsRepository;

	@Override
	public List<Friend> findFrontIndexProductList() {
		return friendsRepository.findFrontIndexProductList();
	}

	@Override
	public List<SessionInfo> findAllSessionInfo() {
		return friendsRepository.findAllSessionInfo();
	}

	@Override
	public void insertSessionInfo(SessionInfo sessionInfo) {
		friendsRepository.insertSessionInfo(sessionInfo);
	}

	@Override
	public List<String> findAllSessionInfoForSessionId() {
		return friendsRepository.findAllSessionInfoForSessionId();
	}

	@Override
	public SessionLimit findSessionLimit() {
		return friendsRepository.findSessionLimit();
	}

	@Override
	public int deleteBySessionId(String sessionId) {
		return friendsRepository.deleteBySessionId(sessionId);
	}

	@Override
    public Map<String, Object> findFriendsMain(String lang, String ownerId) {
        Map<String,Object> map = new HashedMap();
        map.put("lang", lang);
        map.put("ownerId", ownerId);
	    friendsRepository.findFriendsMain(map);
	    return map;
    }
}