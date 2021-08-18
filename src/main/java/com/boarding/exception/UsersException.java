package com.boarding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsersException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsersException() {
		super();
	}

	public UsersException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsersException(String message) {
		super(message);
	}

	public UsersException(Throwable cause) {
		super(cause);
	}
}
