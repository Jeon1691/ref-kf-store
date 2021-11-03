package org.springframework.social.kakao.api.impl;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.kakao.api.KakaoObject;
import org.springframework.social.kakao.api.KakaoTalkProfile;
import org.springframework.social.kakao.api.PlusFriendOperation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class PlusFriendTemplate extends AbstractKakaoOperations implements PlusFriendOperation {
    private final RestTemplate restTemplate;

    public PlusFriendTemplate( RestTemplate restTemplate, boolean isAuthorized, String apiUrl ) {
        super( isAuthorized, apiUrl );
        this.restTemplate = restTemplate;
    }

    public String addPlusFriend( String userId ) {
        requireAuthorization();
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("plus_friend_ids", "["+userId+"]");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearer " + auth.getCredentials());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<?> requestEntity = new HttpEntity<MultiValueMap<String, String>>( param, headers );
        ResponseEntity<String> response =restTemplate.exchange( buildApiUri( "/v1/api/talk/friends/add") ,HttpMethod.POST, requestEntity , String.class );
        return response.getBody();
    }
}
