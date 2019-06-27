package com.spring.transaction.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.transaction.exception.ErrorDetails;
import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@ControllerAdvice
@RestController
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
		log.error("handleUserNotFoundException: {}",
				getErrorDetails(ex) + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT,
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleUserException(Exception ex, WebRequest request) {
		log.error("handleUserException: {}", getErrorDetails(ex));
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT,
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Object getErrorDetails(Exception ex) {
		StackTraceElement ste = ex.getStackTrace()[0];
		Object errorDetails = "Error: "+ ex.getMessage() +", occured at class :"+ ste.getClassName() +", methodName: "+ ste.getMethodName() +", lineNumber: "+
				ste.getLineNumber() +", fileName: "+ ste.getFileName();
		return errorDetails;
	}
}