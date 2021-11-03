package com.kakaofriends.front.common.exception;

import org.springframework.http.HttpStatus;

/**
 * SessionTimeOutException : 세션 만료 예외
 *
 * Author  april
 * Date    2018. 2. 9.
 */
public class SessionTimeOutException extends FriendsStoreException {

    public SessionTimeOutException() {
        super();
    }

    public SessionTimeOutException(String message) {
        super(message, HttpStatus.REQUEST_TIMEOUT);
    }
}
