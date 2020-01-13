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
@Document(collection = "MERCHANT_POINTS")
public class MerchantPoints {
	
	@Id
	@Field(value="MERCHANT_POINTS_ID", order = 1)
	private String merchantPointsId;
	
	@NotNull(message = "Point Value is required field.")
	@Field(value="EACH_POINT_VALUE", order = 2)
	private long eachPointValue;
	
	@Field(value="POINTS_ON_EVERY", order = 3)
	private long pointsOnEvery;
	
	/**
	 * 1. 10x
	 * 2. 20x
	 * 3. 2x
	 * 4. 4x
	 * 5. 5x
	 */
	@Field(value="DESCRIPTION", order = 4)
	private String description;
	
	@Field(value="PARTNER_SHIP_ID", order = 5)
	private String partnerShipId;
}
