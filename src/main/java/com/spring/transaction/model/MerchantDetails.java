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
@Document(collection = "MERCHANT_DETAILS")
public class MerchantDetails {
	
	@Id
	private long merchantDetailsId;
	
	private String code;
	
	private int position;
	
	@NotEmpty(message = "Merchant Name is required field")
	private String description;
	
	private long merchantPointsId;
	
}
