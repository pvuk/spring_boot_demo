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
	
	@Field(value = "BANK_DETAILS_ID", order = 1)
	@Id
	private String bankDetailsId;
	
	@Field(value="BANK_ID", order = 2)
	private String bankId;
	
	@Field(value="BANK_BRANCH_ID", order = 3)
	private String bankBranchId;
	
	@Field(value="IS_ACTIVE", order = 4)
	@Type(type="yes_no")
	private Boolean isActive;
	
	/**
	 * if bank account is transferred to other branch then new branch account is in
	 * active state. Transfer from branch isActive false.
	 */
	@Field(value="IS_TRANSFERRED", order = 5)
	@Type(type="yes_no")
	@Builder.Default
	private Boolean isTransferred = false;
	
	@Field(value="ACCOUNT_CREATED_ON", order = 6)
	private Date accountCreatedOn;
	
	@Field(value="CHECK_BOOK_ID", order = 7)
	private String checkBookId;
	
	@Field(value = "TransferOn", order = 8)
	private Date transferOn;
	
	@Field(value="BALANCE", order = 9)
	private BigDecimal balance;
	
	@Field(value="DEBIT", order = 10)
	private BigDecimal debit;
	
	@Field(value="CREDIT", order = 11)
	private BigDecimal credit;
	
	@Field(value="TRANSFER_DESCRIPTION", order = 12)
	private String transferDescription;
	
	/**
	 * payee name
	 */
	@Field(value="TRANSFER_TO_ID", order = 13)
	@NotNull(message = "Transfer To is required field.")
	private String transferToId;
	
	@Field(value="PAYMENT_BY_ID", order = 14)
	private String paymentById;
	
	@Field(value="CUSTOMER_ID", order = 15)
	@NotNull(message = "Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
