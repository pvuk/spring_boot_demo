package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CARD_TYPE_AUTHORIZATION")
public class CardTypeAuthorization {
	
	@Field(value = "CARD_TYPE_AUTHORIZATION_ID", order = 1)
	@Id
	private String cardTypeAuthorizationId;
	
	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotEmpty(message = "Card Type is required field.")
	private String description;
	
	@Field(value = "COMMENTS", order = 5)
	private String comments;
}