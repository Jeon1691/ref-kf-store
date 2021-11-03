package org.springframework.social.kakao.connect;

import com.kakaofriends.front.service.MemberService;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.kakao.api.Kakao;

public class KakaoConnectionFactory extends OAuth2ConnectionFactory<Kakao> {
    public KakaoConnectionFactory( String clientId, String authUrl, String apiUrl, MemberService memberService ) {
        super( "kakao", new KakaoServiceProvider( clientId, authUrl, apiUrl ), new KakaoAdapter( memberService ) );
    }

}
