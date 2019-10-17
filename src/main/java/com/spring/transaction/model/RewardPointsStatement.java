package com.spring.transaction.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "REWARD_POINTS_STATEMENT")
public class RewardPointsStatement {
	
	@Id private String rewardPointsStatementId;
	
	private String rewardPointsDetailsId;
	
	@Transient 																		private Set<RewardPointsStatementTransaction> rpStatementTransactionSet;
}
