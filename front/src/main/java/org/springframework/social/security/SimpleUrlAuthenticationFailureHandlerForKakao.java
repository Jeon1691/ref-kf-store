/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.security;

import com.kakaofriends.core.utils.KakaoFriendsConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <tt>AuthenticationFailureHandler</tt> which performs a redirect to the value of the
 * {@link #setDefaultFailureUrl defaultFailureUrl} property when the
 * <tt>onAuthenticationFailure</tt> method is called. If the property has not been set it
 * will send a 401 response to the client, with the error message from the
 * <tt>AuthenticationException</tt> which caused the failure.
 * <p>
 * If the {@code useForward} property is set, a {@code RequestDispatcher.forward} call
 * will be made to the destination instead of a redirect.
 *
 * @author Luke Taylor
 * @since 3.0
 */
public class SimpleUrlAuthenticationFailureHandlerForKakao implements
    AuthenticationFailureHandler {
    protected final Log logger = LogFactory.getLog( getClass() );

    private String defaultFailureUrl;
    private boolean forwardToDestination = false;
    private boolean allowSessionCreation = true;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public SimpleUrlAuthenticationFailureHandlerForKakao() {
    }

    public SimpleUrlAuthenticationFailureHandlerForKakao( String defaultFailureUrl ) {
        setDefaultFailureUrl( defaultFailureUrl );
    }

    /**
     * Performs the redirect or forward to the {@code defaultFailureUrl} if set, otherwise
     * returns a 401 error code.
     * <p>
     * If redirecting or forwarding, {@code saveException} will be called to cache the
     * exception for use in the target view.
     */
    public void onAuthenticationFailure( HttpServletRequest request,
                                         HttpServletResponse response, AuthenticationException exception )
        throws IOException, ServletException {

        if ( defaultFailureUrl == null ) {
            logger.debug( "No failure URL set, sending 401 Unauthorized error" );

            response.sendError( HttpServletResponse.SC_UNAUTHORIZED,
                "Authentication Failed: " + exception.getMessage() );
        } else {
            saveException( request, exception );

            if ( forwardToDestination ) {
                logger.debug( "Forwarding to " + defaultFailureUrl );

                request.getRequestDispatcher( defaultFailureUrl )
                    .forward( request, response );
            } else {
                logger.debug( "Redirecting to " + defaultFailureUrl );
                String errorUrl = defaultFailureUrl;

                if ( null != request.getParameter( KakaoFriendsConstants.KAKAO_ERROR ) ) {
                    String error = request.getParameter( KakaoFriendsConstants.KAKAO_ERROR );
                    String errorDesc = request.getParameter( KakaoFriendsConstants.KAKAO_ERROR_DESC );

                    // error 는 있는데, error_description 이 없는 상황이 발생할 수 있나?
                    if ( null != error ) {
                        // error 가 diable_approval_window 일 경우
                        if ( error.equals( KakaoFriendsConstants.KAKAO_DISABLE_APPROVAL_WINDOW ) ) {
                            // not_connected_user 에러
                            if ( null != errorDesc && errorDesc.equals( KakaoFriendsConstants.KAKAO_NOT_CONNECTED_USER ) ) {
                                request.getSession().setAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE, KakaoFriendsConstants.KAKAO_SSO_MODE_NOT_CONNECTED_USER );
                                errorUrl = "/";
                            } else {
                                errorUrl += "?kakao_error=" + error;
                            }
                        } else {
                            errorUrl += "?kakao_error=" + error;
                        }
                    }
                }
                redirectStrategy.sendRedirect( request, response, errorUrl );
            }
        }
    }

    /**
     * Caches the {@code AuthenticationException} for use in view rendering.
     * <p>
     * If {@code forwardToDestination} is set to true, request scope will be used,
     * otherwise it will attempt to store the exception in the session. If there is no
     * session and {@code allowSessionCreation} is {@code true} a session will be created.
     * Otherwise the exception will not be stored.
     */
    protected final void saveException( HttpServletRequest request,
                                        AuthenticationException exception ) {
        if ( forwardToDestination ) {
            request.setAttribute( WebAttributes.AUTHENTICATION_EXCEPTION, exception );
        } else {
            HttpSession session = request.getSession( false );

            if ( session != null || allowSessionCreation ) {
                request.getSession().setAttribute( WebAttributes.AUTHENTICATION_EXCEPTION,
                    exception );
            }
        }
    }

    /**
     * The URL which will be used as the failure destination.
     *
     * @param defaultFailureUrl the failure URL, for example "/loginFailed.jsp".
     */
    public void setDefaultFailureUrl( String defaultFailureUrl ) {
        Assert.isTrue( UrlUtils.isValidRedirectUrl( defaultFailureUrl ), "'"
            + defaultFailureUrl + "' is not a valid redirect URL" );
        this.defaultFailureUrl = defaultFailureUrl;
    }

    protected boolean isUseForward() {
        return forwardToDestination;
    }

    /**
     * If set to <tt>true</tt>, performs a forward to the failure destination URL instead
     * of a redirect. Defaults to <tt>false</tt>.
     */
    public void setUseForward( boolean forwardToDestination ) {
        this.forwardToDestination = forwardToDestination;
    }

    /**
     * Allows overriding of the behaviour when redirecting to a target URL.
     */
    public void setRedirectStrategy( RedirectStrategy redirectStrategy ) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    protected boolean isAllowSessionCreation() {
        return allowSessionCreation;
    }

    public void setAllowSessionCreation( boolean allowSessionCreation ) {
        this.allowSessionCreation = allowSessionCreation;
    }
}
