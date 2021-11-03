package com.kakaofriends.front.common.filter;

import com.daumcorp.commons.useragentutil.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getUserAgent;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.KAKAO_BYE_IE_PATH;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.KAKAO_HELLO_IE_VERSION;

@Slf4j
public class ConFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		UserAgent userAgent = getUserAgent(httpServletRequest);
		log.info(userAgent.getBrowser().getName());
		if (userAgent.getBrowser().getName().equals("msie") && !httpServletRequest.getServletPath().equals(KAKAO_BYE_IE_PATH)) {
			log.info("IE VERSION = " + userAgent.getBrowser().getVersion());
			if (Float.valueOf(userAgent.getBrowser().getVersion()) < KAKAO_HELLO_IE_VERSION) {
				log.info("IE BYE BYE = " + Float.valueOf(userAgent.getBrowser().getVersion()));
				httpServletResponse.sendRedirect(KAKAO_BYE_IE_PATH);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}