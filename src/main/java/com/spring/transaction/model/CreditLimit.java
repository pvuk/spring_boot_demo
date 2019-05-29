package com.spring.transaction.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

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
	private String creditLimitId;
	
	private String cardUpgradeThrough;
	
	private Long upgradeLimitFrom;
	private Long upgradeLimitTo;
	private Timestamp upgradeLimitOn;

	private Long temporaryLimit;
	private Date temporaryLimitFrom;
	private Date temporaryLimitTo;
	
	@NotNull(message = "Credit Card is required field.")
	private CreditCard creditCard;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
}
