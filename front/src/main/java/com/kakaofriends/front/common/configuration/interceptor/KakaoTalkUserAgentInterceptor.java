package com.kakaofriends.front.common.configuration.interceptor;

import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.utils.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoTalkUserAgentInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {

        HttpSession session = request.getSession();

        if ( session.getAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW ) == null ) {// 세션에 웹뷰 정보가 없을 경우

            checkUserAgent( request );

            // KaKaotalkAgent 체크
            String kakaoAgent = request.getHeader( KakaoFriendsConstants.KAKAO_AGENT_KEY );

            if ( StringUtils.isNotEmpty( kakaoAgent ) ) {
                session.setAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW, KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB );
            }
        } else { // 세션에 웹뷰 정보가 있을 경우
            int webViewMode = (int) session.getAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW );

            if ( webViewMode != KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB ) {
                // User-Agent 부터 체크
                checkUserAgent( request );

            }
        }

//        session.setAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW, KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB );

        // 카톡에서 썸네일 안보이는 이슈 때문에 수정
        int kakaoWebView = (int) session.getAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW );

        if ( kakaoWebView == KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB ) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if ( authentication == null ) {
                String redirectUrl = (String) session.getAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL );

                if ( StringUtils.isEmpty( redirectUrl ) ) {
                    session.setAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL, request.getRequestURL().toString() );
                } else {
                    if ( !request.getRequestURL().toString().equals( redirectUrl ) ) {
                        session.setAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL, request.getRequestURL().toString() );
                    }
                }
            } else {
                FrontUserDetail friendsUserDetails = null;

                if ( authentication.getPrincipal() instanceof FrontUserDetail ) {
                    friendsUserDetails = (FrontUserDetail) authentication.getPrincipal();
                } else {
                    friendsUserDetails = (FrontUserDetail) authentication.getDetails();
                }

                if ( friendsUserDetails.getUser().getEmail().equals( "nonmember" ) ) {
                    String redirectUrl = (String) session.getAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL );

                    int excludeSSO = 0;

                    if ( session.getAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE ) != null ) {
                        excludeSSO = (int) session.getAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE );
                    }

                    if ( excludeSSO == KakaoFriendsConstants.KAKAO_SSO_MODE_WITHDRAW_PERIOD_REMAIN || excludeSSO == KakaoFriendsConstants.KAKAO_SSO_MODE_NOT_CONNECTED_USER )
                        return true;

                    if ( StringUtils.isEmpty( redirectUrl ) ) {
                        session.setAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL, request.getRequestURL().toString() );
                        response.sendRedirect( "/auth/kakao" );
                        return false;
                    } else {
                        if ( !request.getRequestURL().toString().equals( redirectUrl ) ) {
                            session.setAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL, request.getRequestURL().toString() );
                            response.sendRedirect( "/auth/kakao" );
                            return false;
                        }
                    }
                }
            }
        }


        return true;
    }

    private void checkUserAgent( HttpServletRequest request ) {
        // User-Agent 부터 체크
        String userAgent = request.getHeader( "User-Agent" );

        HttpSession session = request.getSession();

        if ( userAgent != null ) {
            userAgent = userAgent.toLowerCase();

            int count = 0;

            int idx = 0;
            while ( (idx = userAgent.indexOf( KakaoFriendsConstants.KAKAO_USER_AGENT_KEY, idx )) != -1 ) {
                count++;
                idx += KakaoFriendsConstants.KAKAO_USER_AGENT_KEY.length();
            }

            if ( count > 0 ) {
                session.setAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW, KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB );
            } else {
                session.setAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW, KakaoFriendsConstants.KAKAO_WEB_VIEW_NONE );
            }
        }
    }
}
