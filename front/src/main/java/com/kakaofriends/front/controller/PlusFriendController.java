package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.jws.WebResult;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
@Controller
@FriendsGlobal
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
@RequestMapping( value = "/api" )
public class PlusFriendController {

    private UsersConnectionRepository usersConnectionRepository;
    private ProviderSignInUtils providerSignInUtils;
    @GetMapping( value = "/plusfriend/add" )
    @ResponseBody
    public String addPlusFriends( WebRequest request ) {
        try {
            String ownerId = getFriendsMemberId();
            String rep = "";
            if ( usersConnectionRepository != null ) {
                Connection<?> connection = usersConnectionRepository.createConnectionRepository( ownerId )
                        .getPrimaryConnection( Kakao.class );
//            Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

                String providerId = connection.getKey().getProviderUserId();
                rep = ((Kakao) connection.getApi()).plusFriendOperation().addPlusFriend( providerId );

                log.info( "rep : {}", rep );
            }
            return rep;
        }catch ( Exception e){
            e.printStackTrace();
            return "\""+e.getMessage() +"\"";
        }
    }

}