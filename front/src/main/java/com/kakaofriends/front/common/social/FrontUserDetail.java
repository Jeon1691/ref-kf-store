package com.kakaofriends.front.common.social;

import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;
import java.util.HashSet;

public class FrontUserDetail implements SocialUserDetails {

    private static final long serialVersionUID = 5197941260523577515L;

    private Member user;

    public FrontUserDetail( Member user ) {
        this.user = user;
    }

    public Member getUser() {
        return user;
    }

    public void setUser( Member user ) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>( 1 );
        if ( this.user.getEmail().equalsIgnoreCase( KakaoFriendsConstants.NONMEMBER ) ) {
            authorities.add( new SimpleGrantedAuthority( "ROLE_ANONYMOUS" ) );
        } else {
            authorities.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }


    public String getNickName() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUserId() {
        return user.getId().toString();
    }
}
