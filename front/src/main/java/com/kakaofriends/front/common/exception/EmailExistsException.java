package com.kakaofriends.front.common.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable{
    public EmailExistsException(final String message) {
        super(message);
    }
}
