package com.kakaofriends.front.common.security;


import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private MemberServiceImpl userService;


    @Override
    public final FrontUserDetail loadUserByUsername( String username ) throws UsernameNotFoundException {
        Member pMember = new Member();
        pMember.setId( Long.parseLong( username ) );
        pMember.setStatus( "MEMBER" );
        Member user = userService.get( pMember );

        if ( user == null ) {
            throw new UsernameNotFoundException( "Not Exist User" );
        }

        return new FrontUserDetail( user );
    }
}
