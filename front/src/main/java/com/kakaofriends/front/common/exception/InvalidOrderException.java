package com.kakaofriends.front.common.exception;


import lombok.Getter;

/**
 * InvalidOrderException
 *
 * Author  april
 * Date    2018. 1. 22.
 */
public class InvalidOrderException extends FriendsStoreException {
    private static final long serialVersionUID = 6957270850490659840L;

    @Getter
    private final Object[] objects;

    public InvalidOrderException() {
        this.objects = null;
    }

    public InvalidOrderException(String message) {
        super(message);
        this.objects = null;
    }

    public InvalidOrderException(String message, Object[] messageArgs) {
        super(message);
        this.objects = messageArgs;
    }
}
