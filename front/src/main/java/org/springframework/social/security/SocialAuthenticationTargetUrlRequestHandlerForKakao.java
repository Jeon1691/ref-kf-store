package org.springframework.social.security;

import com.kakaofriends.core.utils.KakaoFriendsConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SocialAuthenticationTargetUrlRequestHandlerForKakao extends AbstractAuthenticationTargetUrlRequestHandler
    implements AuthenticationSuccessHandler {

    @Override
    protected void handle( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
//        super.handle( request, response, authentication );

        String redirectUrl = (String) request.getSession().getAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL );

        if ( redirectUrl != null ) {
            getRedirectStrategy().sendRedirect( request, response, redirectUrl );
            return;
        }

        super.handle( request, response, authentication );
    }


    @Override
    public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
        handle( request, response, authentication );

        HttpSession session = request.getSession( false );

        if ( session == null ) return;

        session.removeAttribute( KakaoFriendsConstants.KAKAO_AUTH_AFTER_REDIRECT_URL );
    }
}
