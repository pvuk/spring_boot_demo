package com.spring.transaction.model;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

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

	@Id
	@Field(value = "BANK_BRANCH_ID", order = 1)											private String bankBranchId;
	
	@Indexed
	@DBRef
	@NotNull(message="Bank is required field.")
	@Field(value="BANK_CODE", order = 2)												private Bank bank;
	
	@Indexed
	@NotNull(message="IFSC Code is required field.")
	@Field(value="IFSC_CODE", order = 3)												private String ifscCode;
	
	@Field(value="MICR_CODE", order = 4) 												private long micrCode;
	@Field(value="BRANCH_CODE", order = 5) 												private long branchCode;
	@Field(value="BRANCH_CODE_DESCRIPTION", order = 6) 									private String branchCodeDescription;
	@Field(value="BRANCH_NAME", order = 7) 												private String branchName;
	@Field(value="CONTACT_NUMBER", order = 8) 											private String contactNumber;
	
	@DBRef
	@Field(value="ADDRESS", order = 9)													private Address address;
	
	@Field(value="BANK_BRANCH_STATUS_ID", order = 10)									private String bankBranchStatusId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 11)												private String customerId;
	
	@Embedded
	private AuditData auditData;
}
