package com.kakaofriends.front.controller.common;

import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.common.exception.PaymentException;
import com.kakaofriends.front.common.exception.WithdrawPeriodException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import static com.kakaofriends.front.utils.FriendsUtil.getIp;
import static com.kakaofriends.front.utils.FriendsUtil.processMessage;

@Controller
@ControllerAdvice
public class ErrorController {

    private static final Logger log = LoggerFactory.getLogger( ErrorController.class );

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler( OrderManageException.class )
    public String orderManageExceptionHandle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "redirect:/";
    }

    @ExceptionHandler( NoHandlerFoundException.class )
    public String noHandlerFoundExceptionHandle( Exception exception, HttpServletRequest request, Model model ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        model.addAttribute( "userAgent", KakaoFriendsUtil.getUserAgent( request ) );
        model.addAttribute( "language", LocaleContextHolder.getLocale() );
        return "common/error/404";
    }

    @ExceptionHandler( WithdrawPeriodException.class )
    public String withdrawPeriodExceptionHandle( Exception exception, HttpServletRequest request ) {
        return "common/error/signup";
    }

    @ExceptionHandler( RuntimeException.class )
    public String runtimeExceptionHandle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @ExceptionHandler( MyBatisSystemException.class )
    public String myBatisSystemException( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @ExceptionHandler( ServletRequestBindingException.class )
    public String servletRequestBindingExceptionHandle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/400";
    }

    @ExceptionHandler( HttpRequestMethodNotSupportedException.class )
    public String httpRequestMethodNotSupportedException( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/400";
    }

    @ExceptionHandler( PaymentException.class )
    public String paymentException( PaymentException exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @RequestMapping( value = "/common/error/400" )
    public String error400Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @RequestMapping( value = "/common/error/401" )
    public String error401Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @RequestMapping( value = "/common/error/403" )
    public String error403Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @RequestMapping( value = "/common/error/404" )
    public String error404Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "/common/error/404";
    }

    @RequestMapping( value = "/common/error/405" )
    public String error405Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/405";
    }

    @RequestMapping( value = "/common/error/500" )
    public String error500Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/500";
    }

    @RequestMapping( value = "/common/error/501" )
    public String error501Handle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/501";
    }

    @RequestMapping( value = "/common/error/signup" )
    public String errorSignupHandle( Exception exception, HttpServletRequest request ) {
        MDC.put( "x_daum_ip", getIp( request ) );
        log.error( "{}, URL : {}, PARAMS : {}, IP : {}.", request.getMethod(), request.getRequestURI(), request.getQueryString(), getIp( request ) );
        log.error( "Stack Trace", exception );
        return "common/error/signup";
    }

    @RequestMapping( value = "/common/ie8" )
    public String errorIe8( HttpServletRequest request ) {
        return "common/error/ie8Upgrade";
    }

    @RequestMapping( value = "/common/sessionTimeOut/{language}" )
    public ModelAndView sessionTimeOut( @PathVariable( "language" ) String language, RedirectAttributes redirectAttributes ) {

        redirectAttributes.addFlashAttribute( "emptyMessage", processMessage( messageSource, "session.destroyed.message" ) );
        RedirectView redirectView = new RedirectView( "/" + language + "/index" );
        redirectView.setExposeModelAttributes( false );
        ModelAndView mav = new ModelAndView();
        mav.setView( redirectView );
        return mav;
    }

}