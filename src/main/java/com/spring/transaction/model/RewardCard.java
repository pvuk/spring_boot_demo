package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "REWARD_CARD")
public class RewardCard {
	
	@Field(value="REWARD_CARD_ID", order = 1)
	@Id private String rewardCardId;
	
	@Field(value="CARD_NUMBER", order = 2)
	private String cardNumber;
	
	@Field(value="NAME_ON_CARD", order = 3)
	private String nameOnCard;
	
	@Field(value="PIN", order = 4)
	private String pin;
	
	@Field(value="CUSTOMER_ID", order = 5)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
