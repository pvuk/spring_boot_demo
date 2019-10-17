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
	
	@Id private String rewardPointsStatementId;
	
	private String rewardPointsDetailsId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.") 								private String customerId;
	
	@Transient 																		private Set<RewardPointsStatementTransaction> rpStatementTransactionSet;
}
