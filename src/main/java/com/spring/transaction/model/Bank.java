package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	private ObjectId bankId;
	
	@Indexed
	@NotNull(message="Bank Name Can't be empty.")
	@NotBlank(message="Bank Name is required field.")
	private String bankName;
	
	@Indexed
	@NotNull(message="IFSC Code Can't be empty")
	@NotBlank(message="IFSC Code is required field.")
	private String ifscCode;
	
	private long micrCode;
	
	private long branchCode;
	
	private String branch;
	
	private String contactNumber;
	
	@DBRef
	private Address address;
	
}
