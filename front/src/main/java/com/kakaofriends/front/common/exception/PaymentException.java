package com.kakaofriends.front.common.exception;

public class PaymentException extends RuntimeException {

	private static final long serialVersionUID = 6031113276125429731L;

	public PaymentException() {
		super();
	}

	public PaymentException(String message) {
		super(message);
	}
}
