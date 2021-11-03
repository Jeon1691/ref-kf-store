package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoProfile extends KakaoObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    private KakaoProfileProperties properties;
    private KakaoAccount kakao_account;

    public long getId() {
        return this.id;
    }

    public KakaoProfileProperties getProperties() {
        return this.properties;
    }

    public KakaoAccount getKakao_account() {
        return kakao_account;
    }

    public void setKakao_account( KakaoAccount kakao_account ) {
        this.kakao_account = kakao_account;
    }

    KakaoProfile() {
    }
}
