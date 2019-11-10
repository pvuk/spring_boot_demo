package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UPI_APP")
public class UPIApp {

	@Id
	@Field("UPI_APP_ID")
	private String upiAppId;
	
	@Field("APP_NAME")
	private String appName;
	
	@Field("CODE")
	private String code;
	
	@Field("DESCRIPTION")
	private String description;
	
	@Field("WALLET_STATUS_ID")
	private String walletStatusId;
}
