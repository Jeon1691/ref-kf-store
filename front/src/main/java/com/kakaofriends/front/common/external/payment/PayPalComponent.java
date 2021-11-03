package com.kakaofriends.front.common.external.payment;

import com.google.common.collect.Lists;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.api.PayResult;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.payment.PayCancel;
import com.kakaofriends.front.domain.payment.PayCancelResultData;
import com.kakaofriends.front.domain.payment.PayMethodType;
import com.kakaofriends.front.repository.OrderRepository;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Dave on 2017. 5. 30..
 */

@Slf4j
@Component
public class PayPalComponent implements PayComponent {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Value("${kfo.payment.domain}")
    private String paymentDomain;

    @Value("${kfo.payment.paypal.cancel}")
    private String paymentPaypalCancelProcess;

    @Override
    public List<PayMethodType> getPayMethodType() {
        return Lists.newArrayList(PayMethodType.PAYPAL);
    }

    /**
     * 작성자 : dave
     * 날짜 : 2017. 6. 15.
     *
     * 페이팔 결제 취소
     *
     * @return 페이팔 결제 취소 결과 데이터
     */
    @Override
    public PayCancelResultData cancelProcessing(HttpServletRequest httpServletRequest, PayCancel payCancel) {
        log.info("페이팔 결제 취소 요청 !!!!" + payCancel.getTid() + " " + payCancel.getCancelAmt() + " " + payCancel.getPartialCancelCode());

        PayCancelResultData payCancelResultData = new PayCancelResultData();

        try {
            String saleID = orderRepository.getPaypalSaleIdByTid(payCancel.getTid());
            if(saleID == null){
                log.info("페이팔 결제 전 취소 요청 :  SalesId 없음");
                String path = "paypal";
                HttpClient client = new HttpClient();
                org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper();
                Map<String, String> parameters = new HashMap<>();
                String pgtid = payCancel.getTid();

                PostMethod method = new PostMethod(paymentDomain + "/" + path + "/cancel");
                parameters.put("tid", pgtid);
                parameters.put("price", "0");
                parameters.put("currency", "USD");
                parameters.put("cancelType", "ALL_CANCEL");

                try {
                    String content = objectMapper.writeValueAsString(parameters);
                    StringRequestEntity requestEntity = new StringRequestEntity(content, "application/json", "UTF-8");
                    method.setRequestEntity(requestEntity);
                    int statusCode = client.executeMethod(method);
                    if ( statusCode == HttpStatus.SC_OK ) {
                        payCancelResultData.setCancelSuccess(true);
                        log.info("[PAYMENT][PAYPAL][CANCEL][SUCCESS] > " + requestEntity);
                    } else {
                        payCancelResultData.setCancelSuccess(false);
                        log.error("[PAYMENT][PAYPAL][CANCEL][FAIL] CODE: {}", statusCode);
                    }
                } catch (Exception e) {
                    log.info("[PAYMENT][PAYPAL][CANCEL][FAIL]");
                    log.error("" + e, e);
                }
                return payCancelResultData;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.set("exchangeRate", exchangeRateComponent.getExchangeRate());
            multiValueMap.set("saleID", saleID);
            multiValueMap.set("payCancel", payCancel);

            String resResult = KakaoFriendsUtil.httpEntity(httpServletRequest, paymentDomain + paymentPaypalCancelProcess, HttpMethod.POST, multiValueMap);
            PayResult payResult = objectMapper.readValue(resResult, PayResult.class);
            Map<String, Object> refundResult = payResult.getResultMap();

            payCancelResultData.setResultCode(refundResult.get("state").toString());
            payCancelResultData.setTid(payCancel.getTid());
            payCancelResultData.setResultMsg(payCancel.getMessage());
            payCancelResultData.setAuthDate(refundResult.get("updateTime").toString());
            payCancelResultData.setCancelSuccess(payCancelResultData.getResultCode().equals("completed") ? true : false);

            log.info("페이팔 결제 취소 결과 :: saleId : {} , refundId : {}, amount : {},  " , refundResult.get("saleId"), refundResult.get("id"), refundResult.get("amountTotal"));
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            log.info("페이팔 결제 취소 결과 :  " + payCancelResultData.isCancelSuccess());

        } catch (Exception e) {
            e.printStackTrace();
            log.info("페이팔 결제 취소 결과 :  " + payCancelResultData.isCancelSuccess());
        }

        return payCancelResultData;
    }
}
