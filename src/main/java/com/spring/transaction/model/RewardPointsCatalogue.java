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
@Document(collection = "REWARD_POINTS_CATALOGUE")
public class RewardPointsCatalogue {

	@Id
	private long rewardPointsCatalogueId;
	
	private String code;
	
	private int position;
	
	@NotEmpty(message = "Reward Points On Every is required field")
	private String description;
}
