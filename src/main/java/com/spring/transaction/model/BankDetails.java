package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="BANK_DETAILS")
public class BankDetails {
	
	@Id
	@Field(value = "BANK_DETAILS_ID", order = 1)
	private String bankDetailsId;
	
	@Field(value="BANK_ID", order = 2)
	private String bankId;
	
	@Field(value="BANK_BRANCH_ID", order = 3)
	private String bankBranchId;
	
	@NotNull(message = "Account Number is required field.")
	@Field(value = "ACCOUNT_NUMBER")
	private BigDecimal accountNumber;
	
	/**
	 * 1. Only one account should be Active per ACCOUNT_NUMBER
	 */
	@Field(value="BANK_ACCOUNT_STATUS_ID", order = 4)
	private String bankAccountStatusId;
	
	/**
	 * 1. If bank account is transferred to other branch then new branch account is in
	 * active state. Transfer from branch isActive false.
	 */
	@Type(type="yes_no")
	@Builder.Default
	@Field(value="IS_TRANSFERRED", order = 5)
	private Boolean isTransferred = false;
	
	@Field(value="ACCOUNT_CREATED_ON", order = 6)
	private Date accountCreatedOn;
	
	/**
	 * 1. TransferOn: Account transfer from one branch to other branch.
	 */
	@Field(value = "TransferOn", order = 8)
	private Date transferOn;
	
	@NotNull(message = "Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 9)
	private String customerId;
	
	private String bankAccountTypeId;
	
	@Embedded
	private AuditData auditData;
}
