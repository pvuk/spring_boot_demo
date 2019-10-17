package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "WALLET_STATEMENT")
public class WalletStatement {
	
	@Id
	private String walletStatementId;
	
	@Column(name = "date") 												private Date date;
	@Column(name = "mode") 												private String mode;
	@Column(name = "PARTICULARS") 										private String particulars;
	@Column(name = "DEPOSITS") 											private BigDecimal deposits;
	@Column(name = "WITHDRAWALS") 										private BigDecimal withdrawals;
	@Column(name = "BALANCE") 											private BigDecimal balance;
	@Column(name =	"STATEMENT_TOTAL_DEPOSITS")							private BigDecimal statementTotalDeposits;
	@Column(name =	"STATEMENT_TOTAL_WITHDRAWALS")						private BigDecimal statementTotalWithdrawals;
	@Column(name =	"STATEMENT_TOTAL_BALANCE")							private BigDecimal statementTotalBalance;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.") 					private String customerId;
	
	@Transient 															private Set<WalletStatementTransaction> wStatementTransactionSet;
}
