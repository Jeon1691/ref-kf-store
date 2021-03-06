package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.response.ApiSuccess;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.ProvisionAgreement;
import com.kakaofriends.front.domain.email.Email;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.MemberService;
import com.kakaofriends.front.service.ProvisionAgreementService;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMember;
import static com.kakaofriends.front.utils.FriendsUtil.isSocial;

@Slf4j
@Controller
@FriendsGlobal
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
public class MyInfoMngController extends MyPageTopController {
    private LocaleUtils localeUtils;
    private MemberService memberService;
    private EmsService emsService;
    private ProvisionAgreementService provisionAgreementService;

    private UsersConnectionRepository usersConnectionRepository;


    // ????????????
    @RequestMapping( value = { "/mypage/myinfo", "/kr/mypage/myinfo", "/en/mypage/myinfo" } )
    public ModelAndView getMyInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( localeUtils.whereAreYou() + "/mypage/myinfo" );
        return mav;
    }

    // ???????????? ??????
    @RequestMapping( value = { "/mypage/myinfoModify", "/kr/mypage/myinfoModify", "/en/mypage/myinfoModify" } )
    public ModelAndView getMyInfoModify() throws Exception {
        ModelAndView mav = new ModelAndView();
        ProvisionAgreement provisionAgreement = new ProvisionAgreement();
        Email email = new Email();

        // ?????? ?????? ?????? ????????????
        Member member = getFriendsMember();

        // ?????? ?????? ??????
        if ( member.getBirthyear() != null && member.getBirthday().equals( "0000" ) ) {
            String birthday = member.getBirthyear() + member.getBirthday();
            SimpleDateFormat transFormat = new SimpleDateFormat( "yyyyMMdd" );
            Date temp = transFormat.parse( birthday );
            transFormat = new SimpleDateFormat( "yyyy. M. d" );
            birthday = transFormat.format( temp );
            member.setBirthString( birthday );
        }


        // ?????? ?????? ????????????
        String locale = localeUtils.whereAreYou();
        List<Map<String, Object>> countryList = emsService.getCountryList( locale );
        mav.addObject( "countryList", countryList );

        for ( Map<String, Object> country : countryList ) {
            String code = country.get( "EC_CODE" ).toString().toLowerCase();
            if ( code.equals( member.getCountry() ) ) {
                if ( "kr".equalsIgnoreCase( locale ) ) {
                    member.setCountryName( country.get( "EC_COUNTRY" ).toString() );
                } else {
                    member.setCountryName( country.get( "EC_COUNTRYENG" ).toString() );
                }
                member.setCountryNumber( country.get( "EC_PHONECODE" ).toString() );
            }
        }

        // ?????? ?????? ?????? ????????????
        provisionAgreement.setMemberId( member.getId() );
        provisionAgreement.setProvisionCountry( locale );
        provisionAgreement.setNecessary( false );

        // ????????? ?????????
        String[] emailArray = member.getEmail().split( "@" );
        if ( emailArray.length == 2 ) {
            if ( member.getProviderId().equals( "kakao" ) && emailArray[0].startsWith( "kakao" ) && emailArray[1].equals( "kakao.com" ) ) {

            } else {
                email.setAddress( emailArray[0] );
                email.setDomain( emailArray[1] );
            }
        }

        mav.addObject( "provision", provisionAgreementService.getMemberProvisionInfo( provisionAgreement ) );
        mav.addObject( "user", member );
        mav.addObject( "email", email );
        if ( isSocial() ) {
            mav.setViewName( localeUtils.whereAreYou() + "/mypage/myinfoModifySocial" );
        } else {
            mav.setViewName( localeUtils.whereAreYou() + "/mypage/myinfoModify" );
        }
        return mav;
    }

    @RequestMapping( value = { "/mypage/updateMyInfo" }, method = RequestMethod.POST )
    public ResponseEntity<ApiSuccess> updateMyInfo( @ModelAttribute UserCreateRequestVO userCreateRequestVO ) {
        ApiSuccess apiSuccess = new ApiSuccess();
        Member member = new Member().setId( userCreateRequestVO.getId() );
        if ( userCreateRequestVO.getCountry() != null ) {
            userCreateRequestVO.setCountry( userCreateRequestVO.getCountry().toLowerCase() );
        }
        memberService.update( userCreateRequestVO );

        // ?????? ??????
        if ( userCreateRequestVO.getProvisionAgreements() != null && userCreateRequestVO.getProvisionAgreements().size() > 0 ) {
            for ( ProvisionAgreement provisionAgreement : userCreateRequestVO.getProvisionAgreements() ) {
                provisionAgreement.setMemberId( userCreateRequestVO.getId() );
            }
            provisionAgreementService.agreeProvision( userCreateRequestVO.getProvisionAgreements() );
        }

        FrontUserDetail frontUserDetail = new FrontUserDetail( memberService.get( member ) );
        Authentication authentication = new UsernamePasswordAuthenticationToken( frontUserDetail, frontUserDetail.getPassword(), frontUserDetail.getAuthorities() );
        SecurityContextHolder.getContext().setAuthentication( authentication );
        return new ResponseEntity<>( apiSuccess, HttpStatus.OK );
    }

    @RequestMapping( value = { "/mypage/withdraw" }, method = RequestMethod.POST )
    public ResponseEntity<ApiSuccess> withdraw() {

        Member member = FriendsUtil.getFriendsMember();

        Connection<?> connection = usersConnectionRepository
            .createConnectionRepository( member.getId().toString() )
            .getPrimaryConnection( Kakao.class );

        ApiSuccess apiSuccess = new ApiSuccess();

        // ?????? ????????? Kakao ??? ????????? ?????? ?????????.
        if ( connection != null && connection.getKey().getProviderId().equalsIgnoreCase( "kakao" ) && connection.getApi() != null ) {
            KakaoProfile profile = ((Kakao) connection.getApi()).userOperation().unlink();

            if ( profile != null && profile.getId() > 0 ) {
                memberService.delete( member );
            } else {
                apiSuccess.setStatusCode( "0001" );
            }
        }

        return new ResponseEntity<>( apiSuccess, HttpStatus.OK );
    }

}