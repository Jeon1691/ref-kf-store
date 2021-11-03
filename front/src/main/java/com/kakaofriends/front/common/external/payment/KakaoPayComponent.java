package com.kakaofriends.front.common.external.payment;

import com.google.common.collect.Lists;
import com.kakaofriends.front.domain.payment.PayCancel;
import com.kakaofriends.front.domain.payment.PayCancelResultData;
import com.kakaofriends.front.domain.payment.PayMethodType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class KakaoPayComponent implements PayComponent {

    @Value("${kfo.payment.domain}")
    private String paymentUrl;

    @Override
    public List<PayMethodType> getPayMethodType() {
        return Lists.newArrayList(PayMethodType.KAKAOPAY_V2);
    }

    @Override
    public PayCancelResultData cancelProcessing(HttpServletRequest httpServletRequest, PayCancel payCancel) {
        /*
        카카오페이 V2 결제 취소
        다른 결제 수단 수정 후 PaymentHandler.java 로 이동
         */
        String path = "kakaopay";
        HttpClient client = new HttpClient();
        org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper();
        Map<String, String> parameters = new HashMap<>();
        String pgtid = payCancel.getTid();
        String price = String.valueOf(payCancel.getCancelAmt());

        PostMethod method = new PostMethod(paymentUrl + "/" + path + "/cancel");
        parameters.put("tid", pgtid);
        parameters.put("price", price);
        parameters.put("currency", "KRW");

        PayCancelResultData payCancelResultData = new PayCancelResultData();
        payCancelResultData.setCancelSuccess(false);
        try {
            String content = objectMapper.writeValueAsString(parameters);
            StringRequestEntity requestEntity = new StringRequestEntity(content, "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            int statusCode = client.executeMethod(method);
            if ( statusCode == HttpStatus.SC_OK ) {
                payCancelResultData.setCancelSuccess(true);
                log.info("[PAYMENT][KAKAOPAY2][CANCEL][SUCCESS] > " + requestEntity);
            } else {
                payCancelResultData.setCancelSuccess(false);
                log.info("[PAYMENT][KAKAOPAY2][CANCEL][FAIL] CODE: {}", statusCode);
            }
        } catch (Exception e) {
            log.info("[PAYMENT][KAKAOPAY2][CANCEL][FAIL]");
            log.error("" + e, e);
        }
        return payCancelResultData;
    }
}
