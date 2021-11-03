package com.kakaofriends.front.service.payment;

import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.common.exception.PaymentException;
import com.kakaofriends.front.common.exception.handler.PaymentExceptionHandler;
import com.kakaofriends.front.service.payment.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * PaymentHandler : 결제 서비스와 통신하는 서비스
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Slf4j
@Service
public class PaymentHandler {
    private String paymentUrl;
    private String domain;

    @Autowired
    public PaymentHandler(@Value("${kfo.payment.domain}") String paymentUrl,
                          @Value("${kakaopay2.redirect.domain}") String domain) {
        this.paymentUrl = paymentUrl;
        this.domain = domain;
    }

    /**
     * 결제 전 처리 통신을 한다.
     *
     * @param paymentGateway 결제 수단
     * @param preparation 결제 준비 데이터
     * @return 결제 준비 응답 정보
     */
    public PaymentPreparationResult prepare(PaymentGateway paymentGateway, PaymentPreparation preparation) {
        log.info("#### prepare payment : pg = {}, param = {}", paymentGateway, preparation);
        String controllerPath = preparation.getOrderPath().getPath();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new PaymentExceptionHandler());
        String path = this.toPath(paymentGateway);

        switch (paymentGateway) {
            case KAKAOPAY:
                preparation.setApprovalUrl( domain + "/" + controllerPath + "/kakaopay");
                preparation.setCancelUrl(domain + "/" + controllerPath + "/kakaopay/cancel");
                preparation.setFailUrl( domain + "/" + controllerPath + "/kakaopay/failure");
                break;
            case INICIS_MOBILE:
                preparation.setApprovalUrl( domain + "/" + controllerPath + "/inicis/mobile");
                break;
        }

        HttpEntity httpEntity = new HttpEntity(preparation, this.getHeaders(null));
        ResponseEntity<PaymentPreparationResult> response = restTemplate.postForEntity(paymentUrl + "/" + path + "/preparation",
                httpEntity, PaymentPreparationResult.class);
        HttpHeaders headers = response.getHeaders();
        PaymentPreparationResult responseBody = response.getBody();
        String cookie = headers.getFirst(headers.SET_COOKIE);
        responseBody.setSessionId(cookie);
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            log.error("#### Payment Preparation Exception : HttpStatus = {}, PaymentGateway = {}, PaymentPreparation = {}, Message = {}",
                    response.getStatusCode(), paymentGateway, preparation, responseBody.getMessage());
            throw new PaymentException(responseBody.getMessage());
        }

        return responseBody;
    }

    /**
     * 결제 처리 통신을 한다.
     *
     * @param paymentGateway 결제 수단
     * @param payment 결제 처리 데이터
     */
    public PaymentResult pay(PaymentGateway paymentGateway, PaymentExecution payment) {
        log.info("#### pay payment : pg = {}, param = {}", paymentGateway, payment);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new PaymentExceptionHandler());
        String path = this.toPath(paymentGateway);

        HttpEntity httpEntity = new HttpEntity(payment, this.getHeaders(payment.getSessionId()));
        ResponseEntity<PaymentResult> response = restTemplate.postForEntity(paymentUrl + "/" + path + "/payment", httpEntity, PaymentResult.class);
        PaymentResult paymentResult = response.getBody();
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            log.error("#### Payment Execution Exception : HttpStatus = {}, PaymentGateway = {}, PaymentExecution = {}, Message = {}",
                    response.getStatusCode(), paymentGateway, payment, paymentResult.getMessage());
            throw new PaymentException(paymentResult.getMessage());
        }
        log.info("#### pay success : pg = {}, result = {}", paymentGateway, paymentResult);
        return paymentResult;
    }

    public void cancel(PaymentGateway paymentGateway, CancelExecution cancel) {
        log.info("#### pay cancel : pg = {}, param = {}", paymentGateway, cancel);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new PaymentExceptionHandler());
        String path = this.toPath(paymentGateway);

        HttpEntity httpEntity = new HttpEntity(cancel, this.getHeaders(null));
        ResponseEntity<String> response = restTemplate.postForEntity(paymentUrl + "/" + path + "/cancel", httpEntity, String.class);
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            log.error("#### Cancel Execution Exception : HttpStatus = {}, PaymentGateway = {}, CancelExecution = {}, Message = {}",
                    response.getStatusCode(), paymentGateway, cancel, response.getBody());
            throw new PaymentException(response.getBody());
        }
    }


    private String toPath(PaymentGateway paymentGateway) {
        return paymentGateway.name().toLowerCase();
    }

    private HttpHeaders getHeaders(String session) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.COOKIE, session);
        return headers;
    }
}
