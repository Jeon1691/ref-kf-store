package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.exception.ExceededAuthCountException;
import com.kakaofriends.front.common.exception.NoDataException;
import com.kakaofriends.front.common.exception.NotCertificationException;
import com.kakaofriends.front.common.response.ApiSuccess;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.controller.views.MemberAuthVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAuth;
import com.kakaofriends.front.service.MemberAuthService;
import com.kakaofriends.front.service.MemberServiceImpl;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

import static com.kakaofriends.front.utils.FriendsUtil.*;

@Slf4j
@Controller
@FriendsGlobal
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
public class SignInController {

    private LocaleUtils localeUtils;
    private MemberAuthService memberAuthService;
    private PasswordEncoder encoder;
    private MessageSource messageSource;

    private MemberServiceImpl memberService;

    private ProviderSignInUtils providerSignInUtils;

    @RequestMapping( value = "/providerUserId/{providerUserId}" )
    public String providerUserIdLogin( WebRequest request, @PathVariable( name = "providerUserId" ) String providerUserId ) {

        String[] profiles = new String[]{ "local", "development", "stage" };
        String profile = System.getProperties().getProperty( "spring.profiles.active", "" );

        if ( Arrays.asList( profiles ).contains( profile ) ) {
            Member providerUserMember = new Member();

            if ( providerUserId != null ) {
                providerUserMember.setStatus( "MEMBER" );
                providerUserMember.setProviderUserId( providerUserId );
            }

            Member member = memberService.get( providerUserMember );

            if ( member != null ) {
                FrontUserDetail frontUserDetail = new FrontUserDetail( member );
                providerSignInUtils.doPostSignUp( frontUserDetail.getUser().getId().toString(), request );

                Authentication authentication = new UsernamePasswordAuthenticationToken( frontUserDetail, null, frontUserDetail.getAuthorities() );
                SecurityContextHolder.getContext().setAuthentication( authentication );
            }
        }

        return "redirect:/kr/index";
    }

    @RequestMapping( value = "/signin" )
    public String redirectLogin( HttpServletRequest request,
                                 @RequestParam( defaultValue = "false" ) boolean sessionExpired ) throws UnsupportedEncodingException {
        String param = "";

        log.debug( "#### session expired = {}", sessionExpired );
        if ( request.getParameter( "error" ) != null ) {
            param = "?error=true";
            log.error( "[ 로그인 실패  sessionID ] : " + request.getSession().getId() );
        }

        if ( sessionExpired ) {
            String message = FriendsUtil.processMessage( messageSource, "session.destroyed.message" );
            param = "?errMsg=" + URLEncoder.encode( message, StandardCharsets.UTF_8.name() );
        }

        if ( request.getParameter( "kakao_error" ) != null ) {
            return "redirect:/signin/error";
        }
        return "redirect:/" + localeUtils.whereAreYou() + "/signin" + param;
    }

    @RequestMapping( value = "/signin/error" )
    public ModelAndView accessDenied() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/signup/kakao" );
        return mav;
    }


    @RequestMapping( value = { "/kr/signin", "/en/signin" } )
    @Transactional
    public ModelAndView viewLogin( HttpServletRequest request ) {
        ModelAndView mav = new ModelAndView();
        if ( FriendsUtil.isAnonymousUser() ) {

            log.info( "==============================================================================================" );
            log.warn( "[ 익명 로그인 URL redirection(회원 가입)  sessionID ] : " + request.getSession().getId() );
            log.info( "==============================================================================================" );

            mav.setViewName( localeUtils.whereAreYou() + "/signup/login" );
        } else {

            if ( localeUtils.whereAreYou().equalsIgnoreCase( "en" ) ) {
                request.setAttribute( SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.ENGLISH );
            }

            if ( localeUtils.whereAreYou().equalsIgnoreCase( "kr" ) ) {
                mav.setViewName( "redirect:/kr/index" );
                log.info( "==============================================================================================" );
                log.warn( "[ 로그인 성공 KR URL redirection ] 회원 정보 : {} ", getFriendsMember() );
                log.info( "==============================================================================================" );

            } else {
                mav.setViewName( "redirect:/en/index" );
                log.info( "==============================================================================================" );
                log.warn( "[ 로그인 성공 EN URL redirection ] 회원 정보 : {} ", getFriendsMember() );
                log.info( "==============================================================================================" );
            }
        }

        if ( request.getParameter( "kakao_error" ) != null ) {
            mav.addObject( "kakao_error", request.getParameter( "kakao_error" ) );
        }
        return mav;
    }


    @RequestMapping( value = { "/member/welcome", "/kr/member/welcome", "/en/member/welcome" } )
    public ModelAndView memberWelcome() {
        ModelAndView mav = new ModelAndView();
        Locale locale = new Locale( localeUtils.whereAreYou() );

        if ( isSocial() ) {
            mav.addObject( "welcome", messageSource.getMessage( "join.welcome.social.go", null, locale ) );
        } else {
            mav.addObject( "welcome", messageSource.getMessage( "join.welcome.friends.go", null, locale ) );
        }
        log.info( "==============================================================================================" );
        log.warn( "[ 회원가입 성공 KR URL redirection ] 회원 아이디 : {},  회원 이메일 : {} ", getFriendsMemberId(), getFriendsMember().getEmail() );
        log.info( "==============================================================================================" );

        mav.setViewName( localeUtils.whereAreYou() + "/member/welcome" );
        return mav;
    }

    @RequestMapping( value = { "/usr/findid", "/kr/usr/findid", "/en/usr/findid" } )
    public ModelAndView findId() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/signup/findid" );
        return mav;
    }

    @RequestMapping( value = { "/usr/findidComplete", "/kr/usr/findidComplete", "/en/usr/findidComplete" } )
    public ModelAndView findidComplete() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/signup/findidComplete" );
        return mav;
    }

    @RequestMapping( value = { "/usr/findpw", "/kr/usr/findpw", "/en/usr/findpw" } )
    public ModelAndView findpw() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/signup/findpw" );
        return mav;
    }

    @RequestMapping( value = { "/usr/findpwChange", "/kr/usr/findpwChange", "/en/usr/findpwChange" } )
    public ModelAndView findpwChange() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/signup/findpwChange" );
        return mav;
    }

    /**
     * 재전송 가능 여부 조회.
     *
     * @param memberAuth
     * @return
     */
    @RequestMapping( value = "/usr/auth/isResendable", method = RequestMethod.POST )
    public ResponseEntity<ApiSuccess> isResendable( @ModelAttribute MemberAuth memberAuth ) {
        memberAuth.setCountryCode( localeUtils.whereAreYou() );
        ApiSuccess apiSuccess = new ApiSuccess();
        LocalDateTime now = LocalDateTime.now();
        switch ( memberAuth.getAuthMethod() ) {
            case "MESSAGE":
                memberAuth.setCreateDate( now.minusMinutes( 1 ) );
                break;
            case "EMAIL":
                memberAuth.setCreateDate( now.minusMinutes( 10 ) );
                break;
        }

        if ( !memberAuthService.isResendable( memberAuth ) ) {
            apiSuccess.setStatusCode( "0001" );
        }
        return new ResponseEntity<>( apiSuccess, new HttpHeaders(), apiSuccess.getStatus() );
    }

    /**
     * 인증 번호 발송
     *
     * @param memberAuth
     * @return
     */
    @RequestMapping( value = "/usr/auth", method = RequestMethod.POST )
    public ResponseEntity<MemberAuthVO> sendAuthSMS( @ModelAttribute MemberAuth memberAuth ) {
        MemberAuthVO memberAuthVO = new MemberAuthVO();
        memberAuth.setCountryCode( localeUtils.whereAreYou() );
        memberAuth.setCreateDate( LocalDateTime.now() );

        // 인증 번호 발송 및 내역 저장
        try {
            memberAuthVO.setCountAuth( memberAuthService.insert( memberAuth ) );
        } catch ( ExceededAuthCountException ex ) {
            memberAuthVO.setStatusCode( "0002" );
        } catch ( NoDataException e ) {
            memberAuthVO.setStatusCode( "0001" );
        } catch ( Exception e ) {
            log.error( "result {} ", e.getStackTrace() );
            memberAuthVO.setStatus( HttpStatus.INTERNAL_SERVER_ERROR );
        }

        return new ResponseEntity<>( memberAuthVO, new HttpHeaders(), memberAuthVO.getStatus() );
    }

    /**
     * 인증 시도
     *
     * @param memberAuth
     * @return
     */
    @RequestMapping( value = "/usr/auth/check", method = RequestMethod.POST )
    public ResponseEntity<MemberAuthVO> checkAuth( @ModelAttribute MemberAuth memberAuth ) {
        MemberAuthVO memberAuthVO = new MemberAuthVO();

        //memberAuth.setCountryCode(localeUtils.whereAreYou());

        try {
            memberAuthVO.setResult( memberAuthService.auth( memberAuth ) );
            memberAuthVO.setId( memberAuth.getId() );
            memberAuthVO.setEmail( memberAuth.getEmail() );
        } catch ( NotCertificationException ex ) {
            memberAuthVO.setStatusCode( "0002" );
        } catch ( NoDataException e ) {
            memberAuthVO.setStatusCode( "0001" );
        } catch ( Exception e ) {
            memberAuthVO.setStatus( HttpStatus.INTERNAL_SERVER_ERROR );
        }

        return new ResponseEntity<>( memberAuthVO, new HttpHeaders(), memberAuthVO.getStatus() );
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/temp-logout", method = RequestMethod.GET )
    public String logoutPage( HttpServletRequest request, HttpServletResponse response ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String locale = localeUtils.whereAreYou();
        if ( isSocial() ) {
            if ( locale.equalsIgnoreCase( "kr" ) ) {
                return "redirect:/kr/index";
            } else {
                return "redirect:/en/index";
            }
        }
        if ( auth != null ) {
            new SecurityContextLogoutHandler().logout( request, response, auth );
        }
        return "redirect:/" + locale + "/signin";
    }

    @RequestMapping( value = "/logout", method = RequestMethod.GET )
    public ModelAndView logout( HttpServletRequest request, HttpServletResponse response ) {
        String locale = localeUtils.whereAreYou();
        ModelAndView view = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ( auth != null ) {
            new SecurityContextLogoutHandler().logout( request, response, auth );
        }
        if ( locale.equalsIgnoreCase( "kr" ) ) {
            view.setViewName( "redirect:/kr/index" );
        } else {
            view.setViewName( "redirect:/en/index" );
        }
        return view;
    }

    /**
     * @param authentication
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/isMyPrivacyOk", method = RequestMethod.GET )
    public String isMyPrivacyOk( Authentication authentication, HttpServletRequest request, HttpServletResponse response ) {
        String locale = localeUtils.whereAreYou();
        if ( authentication.isAuthenticated() ) {
            //todo
            if ( getFriendsMember().getProviderId() == null ) {
                return "redirect:/" + localeUtils.whereAreYou() + "/mypage/myinfo";
            }
            return "redirect:/" + localeUtils.whereAreYou() + "/mypage/myinfoModify";
        }
        new SecurityContextLogoutHandler().logout( request, response, authentication );
        return "redirect:/" + locale + "/signin";
    }

    @RequestMapping( value = "/isValidPassword", method = RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<ApiSuccess> isValidPassword( String password ) {
        String originPassword = getFriendsMember().getPassword();
        ApiSuccess apiSuccess = new ApiSuccess();
        if ( password == null ) password = "";

        if ( !encoder.matches( password, originPassword ) ) {
            apiSuccess.setStatusCode( "0001" );
        }

        return new ResponseEntity<>( apiSuccess, new HttpHeaders(), HttpStatus.OK );
    }

}