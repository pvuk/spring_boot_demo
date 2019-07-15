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
	
	@Field(value="CARD_DETAILS_ID")
	@Id
	private String welcomeBenifitId;
	
	@Field(value="DESCRIPTION")
	private String description;
	
	@Field(value="USE_BEFORE")
	private Date useBefore;
	
	@Field(value="CARD_DETAILS_ID")
	@NotNull(message = "Card is required field.")
	private String cardDetailsId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
