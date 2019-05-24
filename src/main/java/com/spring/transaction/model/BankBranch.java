package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_BRANCH_CODE")
public class BankBranch {

	@Id private String bankBranchId;
	
	@Indexed
	@DBRef
	@Field(value="BANK_CODE")
	@NotNull(message="Bank Can't be empty.")
	@NotBlank(message="Bank is required field.")
	private Bank bank;
	
	@Field(value="IFSC_CODE")
	@Indexed
	@NotNull(message="IFSC Code Can't be empty")
	@NotBlank(message="IFSC Code is required field.")
	private String ifscCode;
	
	@Field(value="MICR_CODE") private long micrCode;
	
	@Field(value="BRANCH_CODE") private long branchCode;
	
	@Field(value="BRANCH_CODE_DESCRIPTION") private String branchCodeDescription;
	
	@Field(value="BRANCH") private String branch;
	
	@Field(value="CONTACT_NUMBER") private String contactNumber;
	
	@DBRef
	@Field(value="ADDRESS")
	private Address address;
	
	private boolean isActive;
}
