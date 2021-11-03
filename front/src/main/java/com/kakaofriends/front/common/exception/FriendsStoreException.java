package com.kakaofriends.front.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

class FriendsStoreException extends RuntimeException {
	private static final long serialVersionUID = 6031113276125429731L;

	@Getter
	private final HttpStatus status;

	FriendsStoreException() {
		super();
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	FriendsStoreException(String message) {
		super(message);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	FriendsStoreException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}