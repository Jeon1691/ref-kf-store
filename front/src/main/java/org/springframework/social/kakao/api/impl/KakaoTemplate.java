package org.springframework.social.kakao.api.impl;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.kakao.api.*;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class KakaoTemplate extends AbstractOAuth2ApiBinding implements Kakao {
	private UserOperation userOperation;
	private StoryOperation storyOperation;
	private TalkOperation talkOperation;
	private PushOperation pushOperation;
	private PlusFriendOperation plusFriendOperation;

	private String adminKey;
	private String apiUrl;
	private RestTemplate adminRestTemplate;

	public KakaoTemplate() {
		initialize();
	}

	public KakaoTemplate(String accessToken, String adminKey, String apiUrl) {
		super(accessToken);
		this.adminKey = adminKey;
		this.apiUrl = apiUrl;
		initialize();
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	public UserOperation userOperation() {
		return userOperation;
	}

	public StoryOperation storyOperation() {
		return storyOperation;
	}

	public TalkOperation talkOperation() {
		return talkOperation;
	}

	public PushOperation pushOperation() {
		return pushOperation;
	}

	public PlusFriendOperation plusFriendOperation() {
		return plusFriendOperation;
	}

	private void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		
		//create admin rest template
		adminRestTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
		adminRestTemplate.setInterceptors(Arrays.asList(new ClientHttpRequestInterceptor[]{new AdminKeyHeaderOAuth2RequestInterceptor(adminKey)}));
		
		initSubApis();
	}

	private void initSubApis() {
		userOperation = new UserTemplate(getRestTemplate(), adminRestTemplate, isAuthorized(), this.apiUrl);
		storyOperation = new StoryTemplate(getRestTemplate(), isAuthorized(), this.apiUrl);
		talkOperation = new TalkTemplate(getRestTemplate(), isAuthorized(), this.apiUrl);
		pushOperation = new PushTemplate(adminRestTemplate, isAuthorized(), this.apiUrl);
		plusFriendOperation = new PlusFriendTemplate(getRestTemplate(), isAuthorized(), this.apiUrl);
	}

	/**
	 * admin key ???????????? api?????? ??? ????????? rest template ??? ????????? interceptor
	 */
	class AdminKeyHeaderOAuth2RequestInterceptor implements ClientHttpRequestInterceptor {
		private final String adminKey;
		
		public AdminKeyHeaderOAuth2RequestInterceptor(String adminKey) {
			this.adminKey = adminKey;
		}
		
		public ClientHttpResponse intercept(final HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
			HttpRequest protectedResourceRequest = new HttpRequestDecorator(request);
			protectedResourceRequest.getHeaders().set("Authorization", "KakaoAK " + adminKey);
			return execution.execute(protectedResourceRequest, body);
		}
	}
}
