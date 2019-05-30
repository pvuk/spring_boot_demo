package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "REWARD_POINTS_CATALOGUE")
public class RewardPointsCatalogue {

	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 1)
	@Id
	private String rewardPointsCatalogueId;
	
	@Field(value="CODE", order = 2)
	private String code;
	
	@Field(value="POSITION", order = 3)
	private int position;
	
	@Field(value="DESCRIPTION", order = 4)
	@NotEmpty(message = "Reward Points On Every is required field.")
	private String description;
	
	@Field(value="CUSTOMER_ID", order = 5)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
