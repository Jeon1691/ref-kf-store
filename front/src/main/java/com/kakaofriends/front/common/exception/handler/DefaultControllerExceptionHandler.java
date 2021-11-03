package com.kakaofriends.front.common.exception.handler;

import com.kakaofriends.front.common.exception.SessionTimeOutException;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;
import java.util.Properties;

/**
 * DefaultControllerExceptionHandler : 컨트롤러의 예외를 처리하는 핸들러
 *
 * Author  april
 * Date    2018. 1. 26.
 */
@Slf4j
@ControllerAdvice(basePackages = "com.kakaofriends.front.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultControllerExceptionHandler {

    private MessageSource messageSource;

    @ExceptionHandler(SessionTimeOutException.class)
    public RedirectView handleSessionTimeOutException(Locale locale) {
        log.warn("#### Session Timeout");

        RedirectView view = new RedirectView();
        Properties properties = new Properties();
        view.setUrl(FriendsUtil.getLanguagePath(locale) + "/signin");
        properties.setProperty("errMsg", FriendsUtil.processMessage(messageSource, "session.destroyed.message"));
        view.setAttributes(properties);
        return view;
    }
}