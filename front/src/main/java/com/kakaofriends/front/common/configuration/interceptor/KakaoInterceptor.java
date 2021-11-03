/*
package com.kakaofriends.front.common.configuration.interceptor;

import com.kakaofriends.front.service.KakaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class KakaoInterceptor extends HandlerInterceptorAdapter {

	@Value("${kakaoFriends.info.url}")
	private String kakaoFriendsInfoUrl;

	@Value("${kakaoFriends.max.session}")
	private Integer kakaoFriendsMaxSession;

	@Autowired
	private KakaoService kakaoService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		List<String> sessionInfoForSessionId = kakaoService.findAllSessionInfoForSessionId();
//		SessionLimit sessionLimit = kakaoService.findSessionLimit();
//		String ip = getIp(request);
//		UserAgent userAgent = getUserAgent(request);
//
//		//결제 관련 IP 하용
//		if (PAYMENT_ALLOW_IP.contains(ip)) {
//			return true;
//		}

//		if (sessionInfoForSessionId.size() == 0 || (!sessionInfoForSessionId.contains(request.getSession().getId()) && sessionLimit.getSlCount() > sessionInfoForSessionId.size())) {
//			kakaoService.insertSessionInfo(SessionInfo.builder().siId(request.getSession().getId()).siIp(ip).siAgent(userAgent.getPlatform()).siIndate(new Date()).build());
//		}

//		if (!sessionInfoForSessionId.contains(request.getSession().getId()) && sessionLimit.getSlCount() <= sessionInfoForSessionId.size()) {
//			response.sendRedirect(kakaoFriendsInfoUrl);
//			return false;
//		}

		return true;
	}
}*/
