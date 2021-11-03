package com.kakaofriends.front.common.external;

import com.kakaofriends.front.domain.instagram.Data;
import com.kakaofriends.front.domain.instagram.Image;
import com.kakaofriends.front.domain.instagram.Images;
import com.kakaofriends.front.domain.instagram.Instagram;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.FRIENDS_INSTAGRAM_DEFAULT_IMAGE_URL;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.HTTP_WAITING_TIME;

@Slf4j
@Component
public class InstagramComponent {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${kakaofriends.official.instagram.url}")
	private String friendsOfficialInstagramUrl;

	@Value("${kakaofriends.official.instagram.access_token}")
	private String officialAccessToken;

	@Value("${kakaofriends.official.instagram.count}")
	private Integer officialCount;

	@Value("${kakaofriends.lab.instagram.url}")
	private String labInstagramUrl;

	public Instagram friendsInstagram() {
		return getInstagram(friendsOfficialInstagramUrl, officialAccessToken, officialCount);
	}

	public Instagram friendsLabInstagram() {
		return getInstagram(labInstagramUrl, officialAccessToken, officialCount);
	}

	private Instagram getInstagram(String friendsInstagramUrl, String accessToken, Integer count) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(HTTP_WAITING_TIME);
		requestFactory.setBufferRequestBody(false);

		restTemplate.setRequestFactory(requestFactory);
		Instagram instagram;
		try {
			instagram = restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(friendsInstagramUrl).queryParam("access_token", accessToken).queryParam("count", count).build().encode().toUri(), Instagram.class);
		} catch (Exception e) {
			log.error("getItemIdsByPageId errors: {}", e.getMessage());
			return new Instagram().builder().data(new Data[]{Data.builder().images(Images.builder().standardResolution(Image.builder().url(FRIENDS_INSTAGRAM_DEFAULT_IMAGE_URL).build()).build()).build()}).build();
		}
		log.info("instagram = " + instagram);
		return instagram;
	}
}