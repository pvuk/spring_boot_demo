package com.spring.transaction.model;

import java.io.Serializable;

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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CREDIT_CARD_CODE")
public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field(value = "CREDIT_CARD_ID", order = 1)
	@Id 												private String creditCardId;

	@Field(value="CODE", order = 2) 					private String code;
	
	@Field(value="POSITION", order = 3) 				private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION", order = 4) 				private String description;
	
	@Field(value="IS_ACTIVE", order = 5) 				private boolean isActive;
}
