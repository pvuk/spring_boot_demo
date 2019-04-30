package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="TRANS_ERROR_LOG_REPORT")
public class TransErrorLogReport {
	
	@Id private String transErrorLogReportId;
	private String message;
	private String className;
	private String methodName;
}
