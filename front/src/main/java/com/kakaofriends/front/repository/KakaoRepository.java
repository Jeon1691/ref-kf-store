package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Friend;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.SessionInfo;
import com.kakaofriends.front.domain.SessionLimit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@PrimaryMapper
@Repository
public interface KakaoRepository {

	List<Friend> findFrontIndexProductList();

	@Results({
			@Result(property = "siId", column = "SI_ID"),
			@Result(property = "siIp", column = "SI_IP"),
			@Result(property = "siAgent", column = "SI_AGENT")
	})
	@Select("SELECT SI_ID, SI_IP, SI_AGENT FROM SESSIONINFO")
	List<SessionInfo> findAllSessionInfo();

	@Select("SELECT SI_ID FROM SESSIONINFO")
	List<String> findAllSessionInfoForSessionId();

	@Insert("INSERT INTO SESSIONINFO (SI_ID, SI_IP, SI_AGENT, SI_INDATE) VALUES (#{siId}, #{siIp}, #{siAgent}, #{siIndate})")
	void insertSessionInfo(SessionInfo sessionInfo);

	@Results({@Result(property = "slCount", column = "SL_COUNT")})
	@Select("SELECT SL_COUNT FROM SESSIONLIMIT")
	SessionLimit findSessionLimit();

	@Delete("DELETE FROM SESSIONINFO WHERE SI_ID = #{sessionId}")
	int deleteBySessionId(String sessionId);

	void findFriendsMain(Map<String, Object> map);
}