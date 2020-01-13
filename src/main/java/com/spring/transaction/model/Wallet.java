package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "WALLET_CODE")
public class Wallet {
	
	@Id
	@Field(value="WALLET_ID", order = 1)													private String walletId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Wallet Code is required field.")
	@Field(value="CODE", order = 2) 														private String code;
	
	@Field(value="POSITION", order = 3) 													private Long position;
	
	@NotNull(message="Wallet Name is required field.")
	@Field(value="DESCRIPTION", order = 4) 													private String description;
	
}
