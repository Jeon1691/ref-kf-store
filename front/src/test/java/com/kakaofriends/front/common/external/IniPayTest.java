package com.kakaofriends.front.common.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inicis.util.etc.INIdata;
import com.kakaofriends.front.common.api.PayResult;
import com.kakaofriends.front.common.configuration.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * IniPayTest
 *
 * Author  april
 * Date    2018. 1. 10.
 */
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@ActiveProfiles("local")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class IniPayTest {

    @Test
    public void request() {
        //Parameter name: price, Parameter value: 7500
        //Parameter name: gopaymethod, Parameter value: onlycard
        //Parameter name: goodname, Parameter value: 리틀프렌즈마우스패드-라이언
        //Parameter name: bsSeqList, Parameter value: 3503016
        //Parameter name: basketAmount, Parameter value: 5000
        //Parameter name: deliveryAmount, Parameter value: 2500
        //Parameter name: paymentAmount, Parameter value: 7500
        //Parameter name: giftCardAmount, Parameter value: 0
        //Parameter name: oaCountryName, Parameter value: 한국
        //Parameter name: pointPrice, Parameter value: 0

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://10.201.3.83/api/payment/inicis/pre/process";
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("price", "7500");
        multiValueMap.add("gopaymethod", "onlycard");
//        multiValueMap.add("goodname", "리틀프렌즈마우스패드-라이언");
        multiValueMap.add("paymentAmount", "7500");
        PayResult result = restTemplate.postForObject(url, multiValueMap, PayResult.class);
        System.out.println("#### INIPAY TEST : result = " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        INIdata inipay = objectMapper.convertValue(result.getResultObj(), INIdata.class);
        System.out.println("#### INIPAY TEST : data = " + inipay);
        // TODO 결제화면 생성을 위해 화면에 리턴해줘야 하는 데이터가 뭔지 확인 필요.
    }

    @Test
    public void payment() {
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        // uid

        multiValueMap.add("uid", "DEFAULTUSR");
        multiValueMap.add("oid", "K12309876123");
        multiValueMap.add("paymentAmount", "7500");
        multiValueMap.add("INI_MID", "kfrientest");
        multiValueMap.add("INI_ENCTYPE", "asym");
        multiValueMap.add("INI_RN", "9678502626");
        multiValueMap.add("INI_PRICE", "7500");
        multiValueMap.add("goodname", "초코파이");
        multiValueMap.add("currency", "WON");
        multiValueMap.add("paymethod", "onlycard");
        multiValueMap.add("encrypted", "");
        multiValueMap.add("sessionkey", "");
        multiValueMap.add("buyername", "april");
        multiValueMap.add("buyertel", "01074732442");
        multiValueMap.add("buyeremail", "april.shin@kakaocorp.com");
        multiValueMap.add("url", "http://localhost:8080/");
        multiValueMap.add("cardcode", "");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://10.201.3.83/api/payment/inicis/post/process";
        PayResult result = restTemplate.postForObject(url, multiValueMap, PayResult.class);
        System.out.println("#### INIPAY TEST : result = " + result);
//        String resResult = KakaoFriendsUtil.httpEntity(httpServletRequest, paymentDomain + paymentInicisPostProcess, HttpMethod.POST, multiValueMap);
//        PayResult payResult = objectMapper.readValue(resResult, PayResult.class);
//        INIdata inipay = objectMapper.convertValue(payResult.getResultObj(), INIdata.class);


//        Parameter name: uid, Parameter value: DEFAULTUSR
//        Parameter name: version, Parameter value: 5000
//        Parameter name: clickcontrol, Parameter value: enable
//        Parameter name: gopaymethod, Parameter value: onlycard
//        Parameter name: ini_paymethod, Parameter value: onlycard
//        Parameter name: buyername, Parameter value: april
//        Parameter name: buyeremail, Parameter value: april.shin@kakaocorp.com
//        Parameter name: buyertel, Parameter value: 82-01074732442
//        Parameter name: P_MNAME, Parameter value: 카카오프렌즈 온라인 스토어[개발]
//        Parameter name: PayMethod, Parameter value: KAKAOPAY
//        Parameter name: GoodsCnt, Parameter value: 1
//        Parameter name: GoodsName, Parameter value: 리틀프렌즈 미니수첩-라이언
//        Parameter name: Amt, Parameter value: 5500
//        Parameter name: MID, Parameter value: cnstest25m
//        Parameter name: certifiedFlag, Parameter value: CN
//        Parameter name: merchantEncKey, Parameter value: 10a3189211e1dfc6
//        Parameter name: merchantHashKey, Parameter value: 10a3189211e1dfc6
//        Parameter name: requestDealApproveUrl, Parameter value: https://kmpay.lgcns.com:8443/merchant/requestDealApprove.dev
//        Parameter name: AuthFlg, Parameter value: 10
//        Parameter name: prType, Parameter value: WPM
//        Parameter name: prType, Parameter value: 1
//        Parameter name: channelType, Parameter value: 4
//        Parameter name: giftCardAmount, Parameter value: 0
//        Parameter name: paymentAmount, Parameter value: 5500
//        Parameter name: osDeliMoenyUse, Parameter value: Y
//        Parameter name: deliveryCharge, Parameter value: 2500
//        Parameter name: ordDeliveryCharge, Parameter value: 2500
//        Parameter name: pointPrice, Parameter value: 0
//        Parameter name: osDeliType, Parameter value: 1
//        Parameter name: osDeliPayType, Parameter value: 2
//        Parameter name: oaCountryName, Parameter value: 한국
//        Parameter name: oaBuyerCountryName, Parameter value: 한국
//        Parameter name: oaBuyerCountryCode, Parameter value: KR
//        Parameter name: oaBuyerPhone, Parameter value: 82-01074732442
//        Parameter name: changeNationType, Parameter value: C
//        Parameter name: prCodes, Parameter value: FRPBRYMNN0004
//        Parameter name: prNames, Parameter value: Mini notebook - Ryan
//        Parameter name: prEas, Parameter value: 1
//        Parameter name: bsEas, Parameter value: 1
//        Parameter name: bsCtSeqs, Parameter value: 46
//        Parameter name: isDiscountPeriods, Parameter value: false
//        Parameter name: bsEa, Parameter value: 1
//        Parameter name: oaBuyerName, Parameter value: april
//        Parameter name: tfEmailIdTemp, Parameter value: april.shin
//        Parameter name: oaBuyerEmail, Parameter value: april.shin@kakaocorp.com
//        Parameter name: oaName, Parameter value: april
//        Parameter name: oaEmail, Parameter value: april.shin@kakaocorp.com
//        Parameter name: oaPhoneCountry, Parameter value: 82
//        Parameter name: oaPhone1, Parameter value: 01074732442
//        Parameter name: oaPhone, Parameter value: 82-01074732442
//        Parameter name: oaZoneCode_txt, Parameter value: 13488
//        Parameter name: oaZoneCode, Parameter value: 13488
//        Parameter name: oaAddr1_txt, Parameter value: 경기 성남시 분당구 판교로 323 (삼평동, 투썬벤처포럼빌딩)
//        Parameter name: oaAddr1, Parameter value: 경기 성남시 분당구 판교로 323 (삼평동, 투썬벤처포럼빌딩)
//        Parameter name: oaAddr2, Parameter value: 7층 디케이테크인
//        Parameter name: saveId, Parameter value: checkAgree
//        Parameter name: payType, Parameter value: onlycard
    }
}
