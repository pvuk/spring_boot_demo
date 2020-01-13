package com.spring.transaction.model;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "WELCOME_BENIFIT")
public class WelcomeBenifit {
	
	@Id
	@Field(value="CARD_DETAILS_ID")
	private String welcomeBenifitId;
	
	@Field(value="DESCRIPTION")
	private String description;
	
	@Field(value="USE_BEFORE")
	private Date useBefore;
	
	@NotNull(message = "Card is required field.")
	@Field(value="CARD_DETAILS_ID")
	private String cardDetailsId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")
	private String customerId;
}
