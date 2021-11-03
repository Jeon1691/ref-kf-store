package com.kakaofriends.front.common.exception.handler;

import com.kakaofriends.front.common.exception.InvalidBindingException;
import com.kakaofriends.front.common.exception.InvalidOrderException;
import com.kakaofriends.front.common.exception.OrderTimeOutException;
import com.kakaofriends.front.common.exception.PaymentException;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * OrderControllerExceptionHandler : 주문에 관련된 예외를 처리하는 핸들러
 *
 * Author  april
 * Date    2018. 1. 26.
 */
@Slf4j
@ControllerAdvice(basePackages = "com.kakaofriends.front.controller.order.api")
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OrderControllerExceptionHandler {
    private MessageSource messageSource;

    @ExceptionHandler(InvalidOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(InvalidOrderException e) {
        String message = FriendsUtil.processMessage(messageSource, e.getMessage(), e.getObjects());
        log.warn("#### InvalidOrderException : message = {}", message);
        log.warn("#### InvalidOrderException : {}", e);
        return message;
    }

    @ExceptionHandler(InvalidBindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> handleException(InvalidBindingException e) {
        log.warn("#### InvalidBindingException : errors = {}", e.getErrors());
        log.warn("#### InvalidBindingException : {}", e);
        return e.getErrors();
    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(PaymentException e) {
        log.warn("#### PaymentException : message = {}", e.getMessage());
        log.warn("#### PaymentException : {}", e);
        return e.getMessage();
    }

    @ExceptionHandler(OrderTimeOutException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleException(OrderTimeOutException e) {
        log.error("#### OrderTimeOutException");
        return FriendsUtil.processMessage(messageSource, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e) {
        log.error("#### Exception : message = {}", e.getMessage());
        log.error("#### Exception : {}", e);
        return FriendsUtil.processMessage(messageSource, "common.error.alert.500");
    }
}