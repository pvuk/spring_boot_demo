package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "OFFER_TYPE_CODE")
public class OfferType {

	@Id
	@Field(value = "OFFER_TYPE_ID")						private String offerTypeId;
	
	@Indexed(unique=true)
	@Field(value="CODE")								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Offer Type is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
