package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

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
@Document(collection = "MERCHANT_POINTS")
public class MerchantPoints {
	
	@Field(value="MERCHANT_POINTS_ID", order = 1)
	@Id
	private String merchantPointsId;
	
	@Field(value="EACH_POINT_VALUE", order = 2)
	@NotEmpty(message = "Point Value is required field.")
	private long eachPointValue;
	
	@Field(value="POINTS_ON_EVERY", order = 3)
	private long pointsOnEvery;
	
	//10x
	@Field(value="DESCRIPTION", order = 4)
	private String description;
	
	@Field(value="PARTNER_SHIP_ID", order = 5)
	private String partnerShipId;
}
