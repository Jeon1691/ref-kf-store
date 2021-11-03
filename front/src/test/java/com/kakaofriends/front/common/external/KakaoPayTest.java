package com.kakaofriends.front.common.external;

import com.kakaofriends.front.common.configuration.*;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@ActiveProfiles("local")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Log
public class KakaoPayTest {


    @Test
    @Description("결제 준비 - 성공시 pg_token 받음")
    public void kakaoReady() throws URISyntaxException, IOException {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        //parameters.add("cid", "C571010182");
        parameters.add("cid", "TC0ONETIME");
        parameters.add("partner_order_id", "partner_order_id");
        parameters.add("partner_user_id", "partner_user_id");
        parameters.add("item_name", "초코파이");
        parameters.add("quantity", "2");
        parameters.add("total_amount", "2200");
        parameters.add("vat_amount", "200");
        parameters.add("tax_free_amount", "200");
        parameters.add("approval_url", "http://localhost:8080/success");
        parameters.add("fail_url", "http://localhost:8080/fail");
        parameters.add("cancel_url", "http://localhost:8080/cancel");


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK 2eec74783dfbc75e688a22c5e9b68149");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> readyResponseEntity = restTemplate.postForEntity(new URI("https://kapi.kakao.com/v1/payment/ready"), request, String.class);

        /*
         * {"tid":"T2435267773173474104","tms_result":false,"next_redirect_app_url":"https://mockup-pg-web.kakao.com/v1/45038f5f335da0d2989a53c4170f701b5a1e12423b6917a4de4e76ea9e772e7b/aInfo","next_redirect_mobile_url":"https://mockup-pg-web.kakao.com/v1/45038f5f335da0d2989a53c4170f701b5a1e12423b6917a4de4e76ea9e772e7b/mInfo","next_redirect_pc_url":"https://mockup-pg-web.kakao.com/v1/45038f5f335da0d2989a53c4170f701b5a1e12423b6917a4de4e76ea9e772e7b/info","android_app_scheme":"kakaotalk://kakaopay/pg?url=https://mockup-pg-web.kakao.com/v1/45038f5f335da0d2989a53c4170f701b5a1e12423b6917a4de4e76ea9e772e7b/order","ios_app_scheme":"kakaotalk://kakaopay/pg?url=https://mockup-pg-web.kakao.com/v1/45038f5f335da0d2989a53c4170f701b5a1e12423b6917a4de4e76ea9e772e7b/order","created_at":"2017-12-19T13:22:43"}

         * */
        if (readyResponseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("readyResponseEntity is : " + readyResponseEntity.getBody());
        }
    }

    private ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().addValueReader(new JsonNodeValueReader());
        // modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
        return modelMapper;
    }


    @Test
    @Description("결제 승인 - 결제를 승인하는 기능")
    public void kakaoApprove() throws URISyntaxException {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        //parameters.add("cid", "C571010182");
        parameters.add("cid", "TC0ONETIME");
        // 스토어에서 만든 주문 번호
        parameters.add("partner_order_id", "partner_order_id");
        // 스토어 유저 아이디
        parameters.add("partner_user_id", "partner_user_id");

        // pre 이후에 리턴 받음
        parameters.add("tid", "T2438280623831571876");
        // pre 이후에 리턴 받음
        parameters.add("pg_token", "c49a695fb83fb1ad3d1d");


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK 2eec74783dfbc75e688a22c5e9b68149");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.postForEntity(new URI("https://kapi.kakao.com/v1/payment/approve"), request, String.class);

        System.out.println(entity.getBody());


        /*
         * {"aid":"A2434928316139483762","tid":"T2434928170109378902","cid":"TC0ONETIME","partner_order_id":"partner_order_id","partner_user_id":"partner_user_id","payment_method_type":"MONEY","item_name":"초코파이","quantity":1,"amount":{"total":2200,"tax_free":200,"vat":200,"point":0},"created_at":"2017-12-18T15:24:53","approved_at":"2017-12-18T15:26:41"}

         * */
    }

    @Test
    @Description("결제 취소 - 전체 및 부분 동시 가능 : 전체 금액보다 작으면 인정")
    public void kakaoCancel() throws URISyntaxException {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        //parameters.add("cid", "C571010182");
        parameters.add("cid", "C571010182");
        // pre 이후에 리턴 받음
        parameters.add("tid", "T2438269392489458320");
        // 취소 금액 (전체 금액 보다 작아야함)
        parameters.add("cancel_amount", "14500");
        // 취소 비과세 금액	 (필수)
        parameters.add("cancel_tax_free_amount", "0");


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK 2eec74783dfbc75e688a22c5e9b68149");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.postForEntity(new URI("https://kapi.kakao.com/v1/payment/cancel"), request, String.class);

        System.out.println(entity.getBody());

        /*
         * {"aid":"A2434928316139483762","tid":"T2434928170109378902","cid":"TC0ONETIME","partner_order_id":"partner_order_id","partner_user_id":"partner_user_id","payment_method_type":"MONEY","item_name":"초코파이","quantity":1,"amount":{"total":2200,"tax_free":200,"vat":200,"point":0},"created_at":"2017-12-18T15:24:53","approved_at":"2017-12-18T15:26:41"}

         * */
    }



}