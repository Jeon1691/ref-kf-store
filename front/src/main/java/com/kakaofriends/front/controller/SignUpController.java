package com.kakaofriends.front.controller;

import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.response.ApiSuccess;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.Provision;
import com.kakaofriends.front.domain.ProvisionAgreement;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.MemberServiceImpl;
import com.kakaofriends.front.service.ProvisionService;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoAccount;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@AllArgsConstructor( onConstructor = @_( @Autowired ) )

@FriendsGlobal
@Controller
public class SignUpController {
    private ProviderSignInUtils providerSignInUtils;
    private ProvisionService provisionService;
    private LocaleUtils localeUtils;
    private EmsService emsService;
    private MemberServiceImpl memberService;

    @GetMapping( value = "/us" )
    public ModelAndView gogoUs( HttpServletRequest request, HttpServletResponse response ) {
        log.debug( "======Breeze3" );
        ModelAndView mav = new ModelAndView();
        mav.setViewName( "common/popup/gogoUs" );
        return mav;
    }

    @RequestMapping( value = "/signup" )
    public String redirectSignUP() {
        return "redirect:/" + localeUtils.whereAreYou() + "/signup";
    }


    @RequestMapping( value = { "/kr/signup", "/en/signup" }, method = RequestMethod.GET )
    @Transactional
    public String redirectRequestToRegistrationPage( WebRequest request, ModelMap modelMap ) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession( request );
        String providerId = "";
        String providerUserId = "";

        log.info( "==============================================================================================" );
        log.warn( "[ SignUp (?????? ??????)  sessionID ] : " + request.getSessionId() );
        log.info( "==============================================================================================" );

        boolean isNotSocial = request.getParameter( "notSocial" ) != null ? Boolean.parseBoolean( request.getParameter( "notSocial" ) ) : false;
        if ( isNotSocial ) {
            log.warn( "[ isNotSocial == 'true' ] : " + request.getSessionId() );
            connection = null;
        }

        if ( connection != null ) {
            log.info( "==============================================================================================" );
            log.warn( "[ connection != null' ] : " + request.getSessionId() );
            log.info( "==============================================================================================" );

            providerUserId = connection.getKey().getProviderUserId();

            log.info( "==============================================================================================" );
            log.warn( " providerUserId : {} ", providerUserId );
            log.info( "==============================================================================================" );

            providerId = connection.getKey().getProviderId();
            log.info( "==============================================================================================" );
            log.warn( " providerId : {} ", providerId );
            log.info( "==============================================================================================" );

            UserProfile userProfile = connection.fetchUserProfile();

            UserCreateRequestVO userCreateRequestVO = UserCreateRequestVO.fromSocialUserProfile( userProfile );
            userCreateRequestVO.setProviderUserId( providerUserId );
            userCreateRequestVO.setProviderId( providerId );


            log.info( "==============================================================================================" );
            log.warn( "user : {}", userCreateRequestVO );
            log.info( "==============================================================================================" );

            modelMap.put( "user", userCreateRequestVO );

            if ( providerId.equals( "kakao" ) ) {
                KakaoProfile kakaoProfile = ((Kakao) connection.getApi()).userOperation().getUserProfile();

//                if ( !(Boolean) kakaoProfile.getExtraData().get( "has_signed_up" ) ) {
//                    return "redirect:/auth/kakao?disable_approval_window=false";
//                }

                log.info( "kakao profile : {}", kakaoProfile );

                modelMap.put( "kakaoAccount", kakaoProfile.getKakao_account() );
            }
        }

        //???????????? ????????? 2017.11.1
        modelMap.put( "countryList", emsService.getCountryList( localeUtils.whereAreYou() ) );

        // ?????? ???????????? ????????? ??????. 2017.10.30 Breeze
        Provision provision = new Provision();
        provision.setCountry( localeUtils.whereAreYou() );
        modelMap.put( "provision", provisionService.getLatestProvision( provision ) );

        if ( StringUtils.isEmpty( providerId ) ) {
            log.info( "==============================================================================================" );
            log.warn( "providerId is empty : user ==> {}", request.getSessionId() );
            log.info( "==============================================================================================" );

            return localeUtils.whereAreYou() + "/join/join";
        } else {

            log.info( "==============================================================================================" );
            log.warn( "providerId is Not empty : user ==> {}", request.getSessionId() );
            log.warn( "?????? ?????? ?????? ???????????? ?????? ??????." );
            log.info( "==============================================================================================" );

            return localeUtils.whereAreYou() + "/join/joinSocial";
        }
    }


    @RequestMapping( value = { "/signup", "kr/signup", "en/signup" }, method = RequestMethod.POST )
    @Transactional
    public String registrationUser( @ModelAttribute UserCreateRequestVO userCreateRequestVO, WebRequest request, HttpSession session ) {

        Connection<?> connection = providerSignInUtils.getConnectionFromSession( request );
        String providerId = "";
        String providerUserId = "";

        if ( connection != null ) {
            providerUserId = connection.getKey().getProviderUserId();
            providerId = connection.getKey().getProviderId();
        }

        if ( memberService.checkWithdrawPeriod( userCreateRequestVO ) ) {
            String message = "You can not re-enter within 30 days.";

            if ( localeUtils.whereAreYou().equalsIgnoreCase( "kr" ) ) {
                message = "30??? ????????? ????????? ??? ??? ????????????.";
            }

            session.setAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE, KakaoFriendsConstants.KAKAO_SSO_MODE_WITHDRAW_PERIOD_REMAIN );

            try {
                if ( connection.getApi() != null ) {
                    ((Kakao) connection.getApi()).userOperation().logout();
                }
            } catch ( Exception e1 ) {
                e1.getStackTrace();
            }

            return String.format( "redirect:/common/error/signup?message=%s", message );
        }

        try {

            log.info( "==============================================================================================" );
            log.warn( "URL : {\"/signup\", \"kr/signup\", \"en/signup\"}" );
            log.warn( " ?????? ?????? POST  : user ==> {}", userCreateRequestVO );
            log.info( "==============================================================================================" );

            // 4??? Feature : ????????? ????????? ??? ????????? ???????????? providerUserId ??? ?????? ????????? ????????? ????????????.
            if ( providerId.equals( "kakao" ) ) {
                if ( StringUtils.isEmpty( userCreateRequestVO.getEmail() ) ) {
                    userCreateRequestVO.setEmail( "kakao" + providerUserId + "@kakao.com" );
                }
            }

            FrontUserDetail frontUserDetail = new FrontUserDetail( memberService.insert( userCreateRequestVO ) );
            providerSignInUtils.doPostSignUp( frontUserDetail.getUser().getId().toString(), request );

            Authentication authentication = new UsernamePasswordAuthenticationToken( frontUserDetail, null, frontUserDetail.getAuthorities() );
            SecurityContextHolder.getContext().setAuthentication( authentication );
            log.info( "==============================================================================================" );
            log.warn( "???????????? ??????  ?????? ?????? : {}", FriendsUtil.getFriendsMember() );
            log.info( "==============================================================================================" );


            // ?????? ????????? ?????? ?????? Kakao Signup API ??? ????????????.
            // developers.kakao.com ?????? ?????? ???????????? ?????? ????????? ??????????????? ????????? ?????? ?????? try catch ??????
            try {
                if ( connection != null && connection.getApi() != null ) {
                    ((Kakao) connection.getApi()).userOperation().signup( "" );
                }
            } catch ( Exception e1 ) {
                e1.getStackTrace();
            }

            session.removeAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE );

            int kakaoWebView = (int) session.getAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW );

            if ( kakaoWebView == KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB ) {
                return "redirect:/" + localeUtils.whereAreYou() + "/index";
            } else {
                return "redirect:/" + localeUtils.whereAreYou() + "/member/welcome";
            }

        } catch ( Exception e ) {
            log.info( "==============================================================================================" );
            log.error( "???????????? ??????   ?????? ?????? : {}", FriendsUtil.getFriendsMember() );
            log.info( "==============================================================================================" );

            log.info( e.getMessage() );

            return String.format( "redirect:/signup?message=%s", e.getMessage() );
        }
    }

    @RequestMapping( value = { "/kr/signup/error", "/en/signup/error" }, method = RequestMethod.GET )
    public String signupError( ModelMap modelMap ) {
        return localeUtils.whereAreYou() + "/error/signup";
    }

    @RequestMapping( value = "/signup/kakao" )
    public String signupKakao( WebRequest request, HttpSession session ) {

        Connection<?> connection = providerSignInUtils.getConnectionFromSession( request );
        String providerId = "";
        String providerUserId = "";
        String locale = localeUtils.whereAreYou();

        if ( connection == null ) {
            return "redirect:/signup?message=error";
        }

        providerId = connection.getKey().getProviderId();
        providerUserId = connection.getKey().getProviderUserId();

        if ( !providerId.equals( "kakao" ) ) {
            return "redirect:/signup?message=error";
        }

        KakaoProfile kProfile = null;
        try {
            kProfile = ((Kakao) connection.getApi()).userOperation().getUserProfile();
        } catch ( Exception e ) {
            return "redirect:/signup?message=error";
        }

        // ??????????????? ?????????
//        if ( !(Boolean) kProfile.getExtraData().get( "has_signed_up" ) ) {
//            return "redirect:/auth/kakao?disable_approval_window=false";
//        }

        KakaoAccount kAccount = kProfile.getKakao_account();

        String gender = "";

        if ( kAccount.getHas_gender() && kAccount.getGender() != null ) {
            gender = kAccount.getGender().equalsIgnoreCase( "female" ) ? "F" : "M";
        }

        UserCreateRequestVO userCreateRequestVO = UserCreateRequestVO.builder()
//            .name( kProfile.getProperties().getNickname() )
            .providerId( providerId )
            .providerUserId( providerUserId )
            .country( locale )
            .email( kAccount.getHas_email() && kAccount.getEmail() != null ? kAccount.getEmail() : "kakao" + providerUserId + "@kakao.com" )
            .gender( gender )
            .birthday( kAccount.getHas_birthday() && kAccount.getBirthday() != null ? kAccount.getBirthday() : "0000" )
            .build();

        if ( memberService.checkWithdrawPeriod( userCreateRequestVO ) ) {
            String message = "You can not re-enter within 30 days.";

            if ( localeUtils.whereAreYou().equalsIgnoreCase( "kr" ) ) {
                message = "30??? ????????? ????????? ??? ??? ????????????.";
            }

            session.setAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE, KakaoFriendsConstants.KAKAO_SSO_MODE_WITHDRAW_PERIOD_REMAIN );

            try {
                if ( connection.getApi() != null ) {
                    ((Kakao) connection.getApi()).userOperation().logout();
                }
            } catch ( Exception e1 ) {
                e1.getStackTrace();
            }


            return String.format( "redirect:/common/error/signup?message=%s", message );
        }

        Provision provision = new Provision();
        provision.setCountry( localeUtils.whereAreYou() );
        List<Provision> provisionList = provisionService.getLatestProvision( provision );

        List<ProvisionAgreement> provisionAgreementList = new ArrayList<>();

        for ( Provision p : provisionList ) {
            provisionAgreementList.add(
                ProvisionAgreement.builder()
                    .provisionCountry( p.getCountry() )
                    .provisionCode( p.getCode() )
                    .provisionVersion( p.getVersion() )
                    .necessary( p.isNecessary() )
                    .agreement( p.isNecessary() )
                    .build()
            );
        }

        userCreateRequestVO.setProvisionAgreements( provisionAgreementList );
        try {
            Member member = memberService.insert( userCreateRequestVO );
            FrontUserDetail frontUserDetail = new FrontUserDetail( member );
            providerSignInUtils.doPostSignUp( frontUserDetail.getUser().getId().toString(), request );

            Authentication authentication = new UsernamePasswordAuthenticationToken( frontUserDetail, null, frontUserDetail.getAuthorities() );
            SecurityContextHolder.getContext().setAuthentication( authentication );

            try {
                if ( connection.getApi() != null ) {
                    ((Kakao) connection.getApi()).userOperation().signup( "" );
                }
            } catch ( Exception e1 ) {
                e1.getStackTrace();
            }

            session.removeAttribute( KakaoFriendsConstants.KAKAO_SSO_MODE );

            int kakaoWebView = (int) session.getAttribute( KakaoFriendsConstants.KAKAO_WEB_VIEW );

            if ( kakaoWebView == KakaoFriendsConstants.KAKAO_WEB_VIEW_4TAB ) {
                return "redirect:/" + locale + "/index";
            } else {
                return "redirect:/" + locale + "/member/welcome";
            }

        } catch ( Exception e ) {
            return String.format( "redirect:/signup?message=%s", e.getMessage() );
        }
    }


    // ????????? ????????????
    @ResponseBody
    @RequestMapping( value = "/uniqueIdCheck" )
    public ResponseEntity<ApiSuccess> uniqueIdCheck( Member joinUsr ) {
        joinUsr.setStatus( "MEMBER" );
        ApiSuccess apiSuccess = new ApiSuccess();
        Member member = memberService.get( joinUsr );
        if ( member != null ) {
            // ?????? ????????? ??????
            apiSuccess.setStatusCode( "0001" );
        }
        return new ResponseEntity<>( apiSuccess, new HttpHeaders(), apiSuccess.getStatus() );
    }

}
