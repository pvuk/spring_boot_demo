package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
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
@Document(collection = "BANK_PAYMENT")
public class BankPayment {
	
	@Field(value="BANK_PAYMENT_ID", order = 1)
	@Id private String bankPaymentId;
	
	@Field(value="BANK_CODE", order = 2)
	@NotNull(message="Bank Can't be empty.")
	@DBRef
	private Bank bank;
	
	@Field(value="ACCOUNT_NUMBER", order = 3)
	@NotNull(message="Account Number is required field.")
	private BigDecimal accountNumber;
	
	@Field(value="AMOUNT", order = 4)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value="CONFIRM_PAYMENT", order = 5)
	private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
