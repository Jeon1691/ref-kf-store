package com.kakaofriends.front.common.exception;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 1.
 * SMS 본인 인증 횟수 초과 예외
 */
public class ExceededAuthCountException extends Exception {
    public ExceededAuthCountException(final String message) {
        super(message);
    }
}
