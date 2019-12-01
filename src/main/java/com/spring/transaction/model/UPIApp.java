package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UPI_APP_CODE")
public class UPIApp {

	@Id
	@Field("UPI_APP_ID")
	private String upiAppId;

	@Field("CODE")
	private String code;
	
	@Field(value = "POSITION")
	private int position;

	@Field("DESCRIPTION")
	private String description;
	
	@Field("COMMENT")
	private String comment;

}
