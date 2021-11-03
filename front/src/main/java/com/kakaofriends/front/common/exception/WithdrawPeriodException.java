package com.kakaofriends.front.common.exception;

import org.springframework.http.HttpStatus;

public class WithdrawPeriodException extends RuntimeException {

    private static final long serialVersionUID = 5441929384632926601L;

    private HttpStatus httpStatus;

    public WithdrawPeriodException( String message, HttpStatus httpStatus ) {
        super( message );
        this.httpStatus = httpStatus;
    }
}