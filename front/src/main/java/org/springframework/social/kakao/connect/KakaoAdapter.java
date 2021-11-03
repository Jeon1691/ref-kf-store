package org.springframework.social.kakao.connect;

import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.service.MemberService;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoProfile;

import java.util.Map;

public class KakaoAdapter implements ApiAdapter<Kakao> {

    private final MemberService memberService;

    @Deprecated
    public boolean test( Kakao api ) {
        // do nothing
        return false;
    }

    public KakaoAdapter( MemberService memberService ) {
        this.memberService = memberService;
    }

    public void setConnectionValues( Kakao kakao, ConnectionValues values ) {
        KakaoProfile profile = kakao.userOperation().getUserProfile();
        values.setProviderUserId( Long.toString( profile.getId() ) );

        Map<String, Object> extraData = profile.getExtraData();

        if ( extraData.containsKey( "has_signed_up" ) ) {
            Boolean hasSignedUp = (Boolean) extraData.get( "has_signed_up" );

            if ( hasSignedUp ) {
                values.setDisplayName( profile.getProperties().getNickname() );
                values.setProfileUrl( "" );
            } else {
                values.setDisplayName( "" );
                values.setProfileUrl( "" );


                Member member = new Member();
                member.setStatus( "MEMBER" )
                    .setProviderUserId( Long.toString( profile.getId() ) );

                Member pMember = memberService.get( member );

                if ( null != pMember ) {
                    try {
                        kakao.userOperation().signup( "" );
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }
                }
            }

            values.setImageUrl( hasSignedUp.toString() );
        }
    }

    public UserProfile fetchUserProfile( Kakao kakao ) {
        KakaoProfile profile = kakao.userOperation().getUserProfile();

//		return new UserProfileBuilder().setName(profile.getProperties().getNickname()).setUsername(profile.getProperties().getNickname()).build();
        return new UserProfileBuilder().setName( "wonhwa" ).build();
    }

    @Deprecated
    public void updateStatus( Kakao kakao, String message ) {
        // do nothing
    }
}
