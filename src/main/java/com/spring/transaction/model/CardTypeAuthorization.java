package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CARD_TYPE_AUTHORIZATION_CODE")
public class CardTypeAuthorization {
	
	@Id
	@Field(value = "CARD_TYPE_AUTHORIZATION_ID", order = 1)					private String cardTypeAuthorizationId;
	
	@Field(value = "CODE", order = 2)										private String code;
	
	@Field(value = "POSITION", order = 3)									private int position;
	
	@NotNull(message = "Card Type is required field.")
	@Field(value = "DESCRIPTION", order = 4)								private String description;
	
	@Field(value = "COMMENTS", order = 5)									private String comments;
}
