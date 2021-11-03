package com.kakaofriends.front.common.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaofriends.front.domain.kims.ShortMessageServiceDto;
import com.kakaofriends.front.domain.kims.WakeUpDeveloper;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.HTTP_WAITING_TIME;


// 문자 테스트 test Case
public class KakaoIntegratedMessagingComponentTest {
    @Test
    public void sendMessageService() throws Exception {
        WakeUpDeveloper dto = new WakeUpDeveloper();
        dto.setCallerNumber("15773754");
        dto.setCountryCode("82");
        dto.setMessage("wonhwa ");
        dto.setReceiverNumber("01081811891");
        sendMessageService(dto);

    }

    public void sendMessageService(ShortMessageServiceDto shortMessageServiceDto) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.set("appName", "kakaofriends");
        request.set("msgJson", objectMapper.writeValueAsString(shortMessageServiceDto));

        System.out.println(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(HTTP_WAITING_TIME);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.postForEntity("http://kims-api.dev.9rum.cc" + "/api/send_msg", new HttpEntity<>(request, headers), String.class);
    }
}