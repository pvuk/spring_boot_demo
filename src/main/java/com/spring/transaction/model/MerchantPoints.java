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
@Document(collection = "MERCHANT_POINTS")
public class MerchantPoints {
	
	@Id
	private long MerchantPointsId;
	
	@NotEmpty(message = "Point Value is required field")
	private long eachPointValue;
	
	private long pointsOnEvery;
	
	//10x
	private String rewardsOnMerchantCategory;
}
