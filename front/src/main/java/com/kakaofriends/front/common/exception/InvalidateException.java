package com.kakaofriends.front.common.exception;

import org.springframework.http.HttpStatus;

/**
 * InvalidateException
 *
 * Author  april
 * Date    2018. 1. 26.
 */
public class InvalidateException extends FriendsStoreException {
    public InvalidateException() {
    }

    public InvalidateException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
