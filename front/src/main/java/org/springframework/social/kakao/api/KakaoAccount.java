package org.springframework.social.kakao.api;

import java.io.Serializable;
import java.util.StringJoiner;

public class KakaoAccount extends KakaoObject implements Serializable {

    private static final long serialVersionUID = 1946621413401492467L;

    private boolean has_email;

    private String email;

    private boolean has_birthday;

    private String birthday;

    private boolean has_gender;

    private String gender;


    public boolean getHas_email() {
        return has_email;
    }

    public String getEmail() {
        return email;
    }

    public boolean getHas_birthday() {
        return has_birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean getHas_gender() {
        return has_gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", KakaoAccount.class.getSimpleName() + "[", "]" )
            .add( "has_email=" + has_email )
            .add( "email='" + email + "'" )
            .add( "has_birthday=" + has_birthday )
            .add( "birthday='" + birthday + "'" )
            .add( "has_gender=" + has_gender )
            .add( "gender='" + gender + "'" )
            .toString();
    }
}
