package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="TRANS_ERROR_LOG_REPORT")
public class TransErrorLogReport {
	
	@Field(value = "TRANS_ERROR_LOG_REPORT_ID", order = 1)
	@Id private String transErrorLogReportId;
	
	@Field(value = "MESSAGE", order = 2)
	private String message;

	@Field(value = "PRINT_STACK_TRACE", order = 3)
	private String printStackTrace;
	
	@Field(value = "CLASS_NAME", order = 4)
	private String className;
	
	@Field(value = "METHOD_NAME", order = 5)
	private String methodName;
	
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
