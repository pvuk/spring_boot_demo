package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "WALLET_CODE")
public class Wallet {
	
	@Field(value="WALLET_ID")
	@Id private String walletId;
	
	@Field(value="CODE") private String code;
	@Field(value="POSITION") private Long position;
	
	@NotNull(message="Wallet Name is required field.")
	@Field(value="DESCRIPTION") private String description;
	
}
