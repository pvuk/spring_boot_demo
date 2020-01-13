package com.spring.transaction.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "REWARD_POINTS_STATEMENT")
public class RewardPointsStatement {
	
	@Id
	@Field(value="REWARD_POINTS_STATEMENT_ID")				private String rewardPointsStatementId;
	
	@Field(value="REWARD_POINTS_DETAILS_ID")				private String rewardPointsDetailsId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")								private String customerId;
	
	@Transient 												private Set<RewardPointsStatementTransaction> rpStatementTransactionSet;
}
