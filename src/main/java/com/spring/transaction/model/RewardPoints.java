package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "REWARD_POINTS")
public class RewardPoints {
	
	@Id
	private long rewardPointsId;
	
	@NotEmpty(message = "Reward Points Catalogue is required field")
	private long rewardPointsCatalogueId;
	
	@NotEmpty(message = "Opening Balance is required field")
	private long rewardsOpeningBalance;
	
	@NotEmpty(message = "Merchant Name is required field")
	private long merchantDetailsId;
	
	@NotEmpty(message = "Reward Points Earned is required field")
	private long rewardPointsEarnedId;
	
	private long bonusPoints;
	
	private long pointsEqualToMoneyValue;
	
	private long rewardsClosingBalance;
	
	@NotEmpty(message = "Reward Points Redeemed To is required field")
	private long rewardPointsRedeemId;
	
}
