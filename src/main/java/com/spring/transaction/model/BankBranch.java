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

	@Field(value = "BANK_BRANCH_ID", order = 1)
	@Id private String bankBranchId;
	
	@Indexed
	@DBRef
	@Field(value="BANK_CODE", order = 2)
	@NotNull(message="Bank is required field.")
	private Bank bank;
	
	@Field(value="IFSC_CODE", order = 3)
	@Indexed
	@NotNull(message="IFSC Code is required field.")
	private String ifscCode;
	
	@Field(value="MICR_CODE", order = 4) 				private long micrCode;
	@Field(value="BRANCH_CODE", order = 5) 				private long branchCode;
	@Field(value="BRANCH_CODE_DESCRIPTION", order = 6) 	private String branchCodeDescription;
	@Field(value="BRANCH", order = 7) 					private String branch;
	@Field(value="CONTACT_NUMBER", order = 8) 			private String contactNumber;
	
	@DBRef
	@Field(value="ADDRESS", order = 9)
	private Address address;
	
	/**
	 * 1. If not found user can add. Need to approve by Admin
	 */
	@Field(value = "IS_NEW", order = 10) 		private Boolean isNew;
	@Field(value = "APPROVED", order = 11) 		private Boolean approved;
	@Field(value = "APPROVED_BY", order = 12) 	private Boolean approvedBy;
	@Field(value = "REJECTED", order = 13) 		private Boolean rejected;
	@Field(value = "REJECTED_BY", order = 14) 	private Boolean rejectedBy;
	
	@Field(value="IS_ACTIVE", order = 15)
	private boolean isActive;
	
	@Field(value="CUSTOMER_ID", order = 16)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
