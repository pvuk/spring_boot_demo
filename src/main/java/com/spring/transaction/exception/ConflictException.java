package com.spring.transaction.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1235495721556154608L;

	public ConflictException(String exception) {
		super(exception);
	}
	
	public ConflictException(String exception, HttpServletRequest request) {
		super(exception);
	}
}
