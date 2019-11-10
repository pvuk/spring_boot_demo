package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "OFFER_STATUS_CODE")
public class OfferStatus {

	@Id
	@Field(value = "OFFER_STATUS_ID")					private String offerStatusId;

	@Field(value="CODE")
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Offer Status is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
