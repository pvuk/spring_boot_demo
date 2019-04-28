package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

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
	
	@Id private String bankPaymentId;
	
	@Field(value="BANK_CODE")
	@NotNull(message="Bank Can't be empty.")
	@DBRef
	private Bank bank;
	
	@Field(value="ACCOUNT_NUMBER")
	@NotNull(message="Account Number is required field.")
	private BigDecimal accountNumber;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
}
