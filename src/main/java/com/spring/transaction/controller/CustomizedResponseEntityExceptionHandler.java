package com.spring.transaction.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.transaction.exception.ErrorDetails;
import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.TransErrorLogReport;
import com.spring.transaction.repository.TransErrorLogReportRepo;
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

	@Autowired TransErrorLogReportRepo transErrorLogReportRepo;
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		Date date = new Date();
		String message = ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;

		log.error("handleUserNotFoundException: {}", getErrorDetails(ex, message, httpStatus, date));

		ErrorDetails errorDetails = new ErrorDetails(date, message, request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleUserException(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		Date date = new Date();
		String message = ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;

		log.error("handleUserException: {}", getErrorDetails(ex, message, httpStatus, date));

		ErrorDetails errorDetails = new ErrorDetails(date, message, request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Object getErrorDetails(Exception ex, String message, HttpStatus httpStatus, Date date) {
		StackTraceElement ste = ex.getStackTrace()[0];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		String fileName = ste.getFileName();
		int statusCode = httpStatus.value();
		String statusName = httpStatus.name();
		
		Object errorDetails = "Error: " + message + ", occured at class :" + className + ", methodName: " + methodName
				+ ", lineNumber: " + lineNumber + ", fileName: " + fileName +", StatusCode: "+ statusCode +", StatusName: "+ statusName;
		
		TransErrorLogReport logReport = TransErrorLogReport.builder()
				.className(className)
				.customerId(null)
				.errorLogReportOn(date)
				.fileName(fileName)
				.lineNumber(lineNumber)
				.message(message)
				.methodName(methodName)
				.printStackTrace(ex)
				.statusCode(statusCode)
				.statusName(statusName)
				.build();
		transErrorLogReportRepo.save(logReport);
		return errorDetails;
	}
}