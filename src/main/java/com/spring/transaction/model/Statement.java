package com.spring.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * This Entity deals with all statements.
 * 1. Credit Card / Bank Statement / Wallet Statement / Reward Points Statement
 * 2. Detailed transactions on accounts as point 1.
 * 3. Credit Card Bill payment through Debit card(Multiple payments may done).
 * @author venkataudaykiranp
 *
 */
@Data
@Document(collection = "STATEMENT")
public class Statement {
	
	private String statementId;
	
	private String debitCardStatementId;
	
	private String creditCardStatementId;
	
	private String rewardPointsStatementId;
	
	private String walletStatementId;
}
