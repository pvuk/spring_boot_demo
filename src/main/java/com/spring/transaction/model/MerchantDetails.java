package com.spring.transaction.model;

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
@Document(collection = "MERCHANT_DETAILS")
public class MerchantDetails {
	
	@Field(value="MERCHANT_DETAILS_ID", order = 1)
	@Id
	private String merchantDetailsId;
	
	@Field(value="CODE", order = 2)
	private String code;
	
	@Field(value="POSITION", order = 3)
	private int position;
	
	@Field(value="DESCRIPTION", order = 4)
	@NotNull(message = "Merchant Name is required field.")
	private String description;
	
	@Field(value="MERCHANT_POINTS_ID", order = 5)
	private String merchantPointsId;
	
}
