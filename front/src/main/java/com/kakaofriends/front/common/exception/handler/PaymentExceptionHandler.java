package com.kakaofriends.front.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * PaymentExceptionHandler
 *
 * Author  april
 * Date    2018. 1. 23.
 */
@Slf4j
public class PaymentExceptionHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
      log.debug("#### ClientHttpResponse = {}", response);
    }
}
