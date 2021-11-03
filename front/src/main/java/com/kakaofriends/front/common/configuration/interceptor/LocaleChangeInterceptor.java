package com.kakaofriends.front.common.configuration.interceptor;

import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.service.stat.StatService;
import com.maxmind.geoip.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.X_DAUM_IP;

@Slf4j
public class LocaleChangeInterceptor extends HandlerInterceptorAdapter {

    private LocaleResolver localeResolver;

    @Autowired
    private StatService statService;

    @Autowired
    private Resource geoIP;

    private String globalStoreUrl = "https://us.kakaofriends.com";
    private String redirectCheckDomain1 = "www.kakaofriends.com";
    private String redirectCheckDomain2 = "kakaofriends.com";
    private String redirectCheckDomain3 = "store.kakaofriends.com/us";
    private String redirectCheckDomain4 = "www.kakaofriends.com/us";

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        // 미국이면 글로벌 쇼핑몰로 redirect
        try {
            String forwaredeIp = request.getHeader( "X-FORWARDED-FOR" );
            String remoteAddrIp = request.getRemoteAddr();
            String ip = request.getHeader( X_DAUM_IP ) == null ? request.getRemoteAddr() : request.getHeader( X_DAUM_IP );
            String url = request.getRequestURL().toString().replace( "https://", "" ).replace( "http://", "" );
            String uri = request.getRequestURI().toString();
            Country country = KakaoFriendsUtil.getCountry( ip, geoIP.getFile() );
            String domain = url.replace( uri, "" );


            log.debug( "==REDIRECT START=====================================" );
            log.debug( "forwaredeIp >{}<", forwaredeIp );
            log.debug( "remoteAddrIp >{}<", remoteAddrIp );
            log.debug( "ip >{}<", ip );
            log.debug( "url >{}<", url );
            log.debug( "uri >{}<", uri );
            log.debug( "country >{}<", country.getCode() );
            log.debug( "domain >{}<", domain );
            log.debug( "==REDIRECT END=======================================" );

            //kakaofriends.com && 미국아이피 => usa
            //www.kakaofriends.com && 미국아이피 => usa
            if ( ("US").equalsIgnoreCase( country.getCode() ) ) {
                if ( domain.equals( redirectCheckDomain1 ) || domain.equals( redirectCheckDomain2 ) ) {
//                    response.sendRedirect(globalStoreUrl);
//                    log.debug("=====Breeze1");
//                    return false;
                }
            }
            //모든 아이피 store.kakaofriends.com/us => usa
            //url = "https://store.kakaofriends.com/us";
            if ( redirectCheckDomain3.equalsIgnoreCase( url ) || redirectCheckDomain4.equalsIgnoreCase( url ) ) {
                response.sendRedirect( globalStoreUrl );
                log.debug( "=====Breeze2" );
                return false;
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        }


        HttpSession httpSession = request.getSession();
        localeResolver = RequestContextUtils.getLocaleResolver( request );

        Locale locale = (Locale) httpSession.getAttribute( SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME );

        if ( request.getRequestURI().startsWith( "/en/" ) && !Locale.ENGLISH.equals( locale ) ) {
            httpSession.setAttribute( SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.ENGLISH );
            locale = Locale.ENGLISH;
        } else if ( request.getRequestURI().startsWith( "/kr/" ) && !Locale.KOREA.equals( locale ) ) {
            httpSession.setAttribute( SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.ENGLISH );
            locale = Locale.KOREA;
        }

        localeResolver.setLocale( request, response, locale );


        /**
         * 네이버 또는 다음으로부터 들어 온 경우 디비에 저장
         */
        String referer = request.getParameter( "referer" );
        if ( referer != null && !referer.equals( "" ) ) {
            statService.insert( referer );
        }

        return true;
    }

}