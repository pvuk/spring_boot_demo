package com.spring.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "REWARD_CARD")
public class RewardCard {
	
	private Long rewardCardId;
	
	private String cardNumber;
	
	private String nameOnCard;
	
	private String pin;
}
