package com.spring.transaction.exception;

public class UserAuthenticationException extends RuntimeException {
	
	public UserAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserAuthenticationException(String msg) {
		super(msg);
	}

}
