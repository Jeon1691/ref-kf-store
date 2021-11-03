package com.kakaofriends.front.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.web.filter.CharacterEncodingFilter;
import redis.clients.jedis.Jedis;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.ENCODING_IGNORE_PATH;

@Slf4j
public class FriendsCharacterEncodingFilter extends CharacterEncodingFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		if(ENCODING_IGNORE_PATH.contains(request.getServletPath())){
			log.info(request.getServletPath());
			request.setCharacterEncoding("EUC-KR");
			filterChain.doFilter(request, response);
		}

		if(!ENCODING_IGNORE_PATH.contains(request.getServletPath())){
			String encoding = this.getEncoding();
			if(encoding != null) {
				if(this.isForceRequestEncoding() || request.getCharacterEncoding() == null) {
					request.setCharacterEncoding(encoding);
				}

				if(this.isForceResponseEncoding()) {
					response.setCharacterEncoding(encoding);
				}
			}

			/**
			 * 네이버로부터 들어 온 경우 세션에 정보 저장
			 */
			String referer = request.getParameter("referer");
			if (referer != null && !referer.equals("")) {
				request.getSession().setAttribute("referer", referer);
			}

			/**
			 * 세션에 referer 값이 있을 경우 redis에 정보 저장
			 */
			referer = (String)request.getSession().getAttribute("referer");
			if (referer != null && !referer.equals("")) {
				try {
					String hostIP = "localhost";
					Properties prop = System.getProperties();
					String profileStr = (String)prop.get("spring.profiles.active");
					if (profileStr != null && profileStr.equals("production")) {
						hostIP = "10.201.2.191";
					}
					Jedis jedis = new Jedis(hostIP);
					if (profileStr != null && profileStr.equals("production")) {
						jedis.auth("kfmaster");
					}
					LocalDateTime dateTime = LocalDateTime.now();
					String keyStr = String.valueOf(request.getSession().getId()+"|"+dateTime.getYear())+"-"+String.valueOf(dateTime.getMonthValue())+"-"+String.valueOf(dateTime.getDayOfMonth());

					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sessionId", request.getSession().getId());
					jsonObject.put("path", request.getServletPath());

					jedis.set(keyStr, jsonObject.toJSONString());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			filterChain.doFilter(request, response);
		}
	}
}
