package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.KakaoTalkProfile;
import org.springframework.social.kakao.api.TalkOperation;
import org.springframework.web.client.RestTemplate;

public class TalkTemplate extends AbstractKakaoOperations implements TalkOperation {
	private final RestTemplate restTemplate;
	
	public TalkTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiUrl) {
		super(isAuthorized, apiUrl);
		this.restTemplate = restTemplate;
	}

	public KakaoTalkProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/talk/profile"), KakaoTalkProfile.class);
	}
}
