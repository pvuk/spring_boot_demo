package com.spring.transaction.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CREDIT_LIMIT")
public class CreditLimit {

	@Id
	private long creditLimitId;
	
	private Integer position;
	private String code;
	private String cardUpgradeThrough;
	
	private Long cardUpgradeLimitFrom;
	private Long cardUpgradeLimitTo;
	private Timestamp cardUpgradeLimitOn;
	
	private CreditCard creditCard; 
}
