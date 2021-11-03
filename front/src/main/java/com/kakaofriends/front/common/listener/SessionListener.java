package com.kakaofriends.front.common.listener;

import com.kakaofriends.front.service.KakaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
public class SessionListener implements HttpSessionListener {

	@Autowired
	private KakaoService kakaoService;

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		log.info("Session Created : "+ httpSessionEvent.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
//		kakaoService.deleteBySessionId(httpSessionEvent.getSession().getId());
		log.info("Session Destroyed : " + httpSessionEvent.getSession().getId());
	}
}