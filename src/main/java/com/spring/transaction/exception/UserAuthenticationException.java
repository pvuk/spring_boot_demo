package com.spring.transaction.exception;

public class UserAuthenticationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserAuthenticationException(String msg) {
		super(msg);
	}

}
