package com.kakaofriends.front.controller.order;

import com.kakaofriends.front.common.configuration.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@ActiveProfiles("local")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MyControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void testUserController() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/test")
                       // .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        /*.header("testHeader",
                                "headerValue")*/

                        .content("test body")
                .param("wonhwa","aurore")
                .param("aurore", "developer");

        this.mockMvc.perform(builder)
                /*.andExpect(MockMvcResultMatchers.status()
                        .isOk())*/
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void name() throws MalformedURLException, UnsupportedEncodingException {
        String result = "_csrf=e0294d72-6c14-4737-9d63-8516b52d3cd3&amp;_csrf_header=X-CSRF-TOKEN&amp;payMethodType=&amp;bsSeqList=3395679&amp;accesstype=1&amp;goodname=%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%95%88%EB%A7%88%EB%B4%89(%EC%8B%9C%EC%A6%8C2)-%EB%9D%BC%EC%9D%B4%EC%96%B8&amp;originalAmt=14500&amp;paymentAccountNotDeli=12000&amp;acceptmethod=SKIN(YELLOW)%3AHPP(1)%3Abelow1000%3AVbank(20180102)&amp;currency=KRW&amp;oid=K1712262201418702&amp;ini_logoimage_url=&amp;ini_menuarea_url=&amp;ini_encfield=&amp;ini_certid=&amp;quotainterest=&amp;paymethod=&amp;cardcode=&amp;cardquota=&amp;rbankcode=&amp;reqsign=DONE&amp;encrypted=&amp;sessionkey=&amp;uid=&amp;sid=&amp;version=5000&amp;clickcontrol=disable&amp;gopaymethod=&amp;ini_paymethod=&amp;buyername=sdfsdf&amp;buyeremail=sdfsdf%40hanmail.net&amp;buyertel=82-01081811891&amp;P_APP_BASE=&amp;P_MID=&amp;P_OID=&amp;P_AMT=&amp;P_MNAME=%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%84%EB%A0%8C%EC%A6%88+%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%8A%A4%ED%86%A0%EC%96%B4%5B%EA%B0%9C%EB%B0%9C%5D&amp;P_UNAME=&amp;P_GOODS=&amp;P_NOTI=&amp;P_HPP_METHOD=&amp;P_MOBILE=&amp;P_BUYERMOBILE=&amp;P_EMAIL=&amp;P_RESERVED=&amp;P_CHARSET=&amp;P_NEXT_URL=&amp;P_NOTI_URL=&amp;P_RETURN_URL=&amp;PayMethod=KAKAOPAY&amp;GoodsCnt=1&amp;GoodsName=%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%95%88%EB%A7%88%EB%B4%89(%EC%8B%9C%EC%A6%8C2)-%EB%9D%BC%EC%9D%B4%EC%96%B8&amp;Amt=&amp;supplyAmt=&amp;goodsVat=&amp;ServiceAmt=&amp;MID=cnstest25m&amp;BuyerName=sdfsdf&amp;BuyerEmail=sdfsdf%40hanmail.net&amp;certifiedFlag=CN&amp;merchantEncKey=10a3189211e1dfc6&amp;merchantHashKey=10a3189211e1dfc6&amp;requestDealApproveUrl=https%3A%2F%2Fkmpay.lgcns.com%3A8443%2Fmerchant%2FrequestDealApprove.dev&amp;merchantTxnNum=&amp;AuthFlg=10&amp;prType=WPM&amp;channelType=4&amp;possiCard=&amp;maxInt=&amp;fixedInt=&amp;noIntYN=&amp;noIntOpt=&amp;pointUseYn=&amp;blockCard=&amp;resultCode=&amp;resultMsg=&amp;txnId=&amp;prDt=&amp;EdiDate=&amp;EncryptData=&amp;SPU=&amp;SPU_SIGN_TOKEN=&amp;MPAY_PUB=&amp;NON_REP_TOKEN=&amp;giftCardNumber=&amp;giftCardAmount=&amp;giftCardCodes=&amp;paymentAmount=&amp;osDeliMoenyUse=Y&amp;deliveryCharge=2500&amp;ordDeliveryCharge=2500&amp;pointPrice=0&amp;osDeliType=1&amp;osDeliPayType=2&amp;oaCountryName=%ED%95%9C%EA%B5%AD&amp;oaBuyerCountryName=%ED%95%9C%EA%B5%AD&amp;oaBuyerCountryCode=KR&amp;oaBuyerPhone=82-01081811891&amp;payaplSaleId=&amp;paypalPaymentId=&amp;paypalPayerId=&amp;paypalPayerEmail=&amp;paypalCreateTime=&amp;changeNationType=C&amp;prCodes=FRPBRYBRE0004&amp;prNames=Self+Massage+Tool-Ryan&amp;prsPrCodes=&amp;prEas=1&amp;bsEas=1&amp;bsCtSeqs=76&amp;bsEtc5s=&amp;isDiscountPeriods=false&amp;prType=1&amp;bsEa=1&amp;cpnNum1=&amp;oaBuyerName=sdfsdf&amp;tfEmailIdTemp=sdfsdf&amp;oaBuyerEmail=sdfsdf%40hanmail.net&amp;oaName=wjdnd&amp;oaEmail=sdfsdf%40gmail.com&amp;oaPhoneCountry=82&amp;oaPhone1=01081811891&amp;oaPhone=01081811891&amp;oaZoneCode_txt=02875&amp;oaZoneCode=02875&amp;oaAddr1_txt=%EC%84%9C%EC%9A%B8+%EC%84%B1%EB%B6%81%EA%B5%AC+%EB%82%99%EC%82%B0%EA%B8%B8+243-15+(%EC%82%BC%EC%84%A0%EB%8F%992%EA%B0%80%2C+%EC%82%BC%EC%84%A0%ED%98%84%EB%8C%80%ED%9E%90%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8)&amp;oaAddr1=%EC%84%9C%EC%9A%B8+%EC%84%B1%EB%B6%81%EA%B5%AC+%EB%82%99%EC%82%B0%EA%B8%B8+243-15+(%EC%82%BC%EC%84%A0%EB%8F%992%EA%B0%80%2C+%EC%82%BC%EC%84%A0%ED%98%84%EB%8C%80%ED%9E%90%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8)&amp;oaAddr2=%E3%84%B4%E3%85%87%E3%84%B9%E3%84%B4%E3%85%87%E3%84%B9&amp;oaAddr3=&amp;osDeliMemo=&amp;saveId=checkAgree&amp;payType=kakaopay_v2";
        String mockHost = "http://localhost/";
        System.out.println(splitQuery(result));

       /* Map<String, List<String>> params =  splitQuery(result);
        System.out.println(params);*/

        MultiValueMap<String, String> params = getPayDataMultiValueMap(result);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.leveluplunch.com")
                .queryParams(params).build();

        System.out.println(uriComponents);

    }

    private MultiValueMap<String, String> getPayDataMultiValueMap(String result) throws UnsupportedEncodingException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        for (Map.Entry<String, String> entry : splitQuery(result).entrySet()) {
            params.add(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return params;
    }


    public static Map<String, String> splitQuery(String why) throws UnsupportedEncodingException {
        final Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        final String[] pairs = why.split("&amp;");
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
            if (!query_pairs.containsKey(key)) {
                query_pairs.put(key, new String());
            }
            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
            query_pairs.put(key, value);
        }
        return query_pairs;
    }
}