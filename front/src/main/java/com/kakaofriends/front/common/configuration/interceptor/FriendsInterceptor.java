/*
package com.kakaofriends.front.common.configuration.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*/
/**
 * Created by seott on 2016-11-17.
 *//*

@Slf4j
public class FriendsInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HttpSession httpSession = request.getSession();
            if(httpSession.getAttribute("oId") == null ){
                if (request.getRequestURI().startsWith("/en/")) {
                    log.info("### Session Time Out En ### ");
                    response.sendRedirect("/common/sessionTimeOut/en");
                } else {
                    log.info("### Session Time Out Kr ### ");
                    response.sendRedirect("/common/sessionTimeOut/kr");
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
*/
