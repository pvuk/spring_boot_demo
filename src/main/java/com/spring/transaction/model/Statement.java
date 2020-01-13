package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	
	@Id
	@Field(value = "STATEMENT_ID")							private String statementId;
	
	@Field(value = "DEBIT_CARD_STATEMENT_ID")				private String debitCardStatementId;
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID")				private String creditCardStatementId;
	
	@Field(value = "REWARD_POINTS_STATEMENT_ID")			private String rewardPointsStatementId;
	
	@Field(value = "WALLET_STATEMENT_ID")					private String walletStatementId;
}
