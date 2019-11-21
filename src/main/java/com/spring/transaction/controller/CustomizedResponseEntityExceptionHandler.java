package com.spring.transaction.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
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
//@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//	@Autowired TransErrorLogReportRepo transErrorLogReportRepo;
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Date date = new Date();
		String message = ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
		
		log.error("handleExceptionInternal: {}", getErrorDetails(ex, ex.getMessage(), status, null, request));
//		return super.handleExceptionInternal(ex, body, headers, status, request);
		
		ErrorDetails errorDetails = new ErrorDetails(date, message.split(":")[0], request.getDescription(false));//send only Error reason

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		Date date = new Date();
		String message = ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;

		log.error("handleUserNotFoundException: {}", getErrorDetails(ex, message, httpStatus, date, request));

		ErrorDetails errorDetails = new ErrorDetails(date, message, request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleUserException(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		Date date = new Date();
		String message = ex.getMessage() + ". " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;

		log.error("handleUserException: {}", getErrorDetails(ex, message, httpStatus, date, request));

		ErrorDetails errorDetails = new ErrorDetails(date, message, request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Object getErrorDetails(Exception ex, String message, HttpStatus httpStatus, Date date, WebRequest request) {
		StackTraceElement ste = ex.getStackTrace()[0];
		StackTraceElement ste2 = ex.getStackTrace()[2];//for method reference
		String className = ste.getClassName();
		String methodName = ste2.getMethodName();
		int lineNumber = ste.getLineNumber();
		String fileName = ste.getFileName();
		int statusCode = httpStatus.value();
		String statusName = httpStatus.name();
		HttpServletRequest httpServletRequest = ((ServletWebRequest) request).getRequest();
		String requestURL = httpServletRequest.getRequestURL().toString();
		String queryString = httpServletRequest.getQueryString();
		queryString = queryString != null ? ", Parameters: "+ queryString : "";
		Object errorDetails = "Exception Message: " + message + ", occured at class :" + className + ", methodName: " + methodName
				+ ", lineNumber: " + lineNumber + ", fileName: " + fileName + ", StatusCode: " + statusCode
				+ ", StatusName: " + statusName +", requestURL: "+ requestURL + queryString;
		
//		TransErrorLogReport logReport = TransErrorLogReport.builder()
//				.className(className)
//				.customerId(null)
//				.errorLogReportOn(date)
//				.fileName(fileName)
//				.lineNumber(lineNumber)
//				.message(message)
//				.methodName(methodName)
//				.parameters(parameters)
//				.printStackTrace(ex)
//				.requestURL(requestURL)
//				.statusCode(statusCode)
//				.statusName(statusName)
//				.build();
//		transErrorLogReportRepo.save(logReport);
		return errorDetails;
	}
}