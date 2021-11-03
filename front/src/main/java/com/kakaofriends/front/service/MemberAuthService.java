package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.MemberAuth;
import org.springframework.dao.DataAccessException;

public interface MemberAuthService {
    int insert(MemberAuth memberAuth) throws Exception;

    boolean auth(MemberAuth memberAuth) throws Exception;

    boolean isResendable(MemberAuth memberAuth) throws DataAccessException;

}
