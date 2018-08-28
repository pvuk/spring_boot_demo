package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "BANK_CODE")
public class Bank {

	@Id
	private long bankId;
	
	@NotNull(message="Bank Name Can't be null")
	@NotBlank(message="Bank Name Can't be empty")
	private String bankName;
	
	private String ifscCode;
	
	private String contactNumber;
	
	private String address;
	
}
