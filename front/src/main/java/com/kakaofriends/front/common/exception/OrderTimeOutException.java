package com.kakaofriends.front.common.exception;

import org.springframework.http.HttpStatus;

/**
 * SessionTimeOutException : 주문 가능 세션 만료 예외
 *
 * Author  april
 * Date    2018. 2. 9.
 */
public class OrderTimeOutException extends FriendsStoreException {

    public OrderTimeOutException() {
        super("session.destroyed.message");
    }

    public OrderTimeOutException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
