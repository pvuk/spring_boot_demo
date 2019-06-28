package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="TRANS_ERROR_LOG_REPORT")
public class TransErrorLogReport {
	
	@Field(value = "TRANS_ERROR_LOG_REPORT_ID", order = 1)
	@Id private String transErrorLogReportId;
	
	@Field(value = "MESSAGE", order = 2)
	private String message;

	@Field(value = "PRINT_STACK_TRACE", order = 3)
	private Object printStackTrace;
	
	@Field(value = "CLASS_NAME", order = 4)
	private String className;
	
	@Field(value = "METHOD_NAME", order = 5)
	private String methodName;
	
	@Field(value = "LINE_NUMBER", order = 6)
	private int lineNumber;
	
	@Field(value = "FILE_NAME", order = 7)
	private String fileName;
	
	@Field(value = "STATUS_CODE", order = 8)
	private int statusCode;
	
	@Field(value = "STATUS_NAME", order = 9)
	private String statusName;
	
	@Field(value = "ERROR_LOG_REPORT_ON", order = 10)
	private Date errorLogReportOn;
	
	@Field(value="CUSTOMER_ID", order = 11)
	@NotNull(message="Customer is required field.")
	private String customerId;

	@Override
	public String toString() {
		return "TransErrorLogReport [transErrorLogReportId=" + transErrorLogReportId + ", message=" + message
				+ ", printStackTrace=" + printStackTrace + ", className=" + className + ", methodName=" + methodName
				+ ", lineNumber=" + lineNumber + ", fileName=" + fileName + ", statusCode=" + statusCode
				+ ", statusName=" + statusName + ", errorLogReportOn=" + errorLogReportOn + ", customerId=" + customerId
				+ "]";
	}
	
}
