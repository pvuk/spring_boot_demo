package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_CODE")
public class Bank {

	@Id
	private long bankId;
	
	@NotNull(message="Bank Name Can't be empty / null")
	@NotBlank(message="Bank Name Can't be empty")
	private String bankName;
	
	@NotNull(message="IFSC Code Can't be empty / null")
	private String ifscCode;
	
	private long micrCode;
	
	private long branchCode;
	
	private String branch;
	
	private String contactNumber;
	
	private Long addressId;
	
}
