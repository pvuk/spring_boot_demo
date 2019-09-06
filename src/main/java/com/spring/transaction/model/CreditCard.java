package com.spring.transaction.model;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document(collection = "CREDIT_CARD_CODE")
public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5336834937743445753L;

	@Field(value = "CREDIT_CARD_ID", order = 1)
	@Id 												private String creditCardId;

	/*
	 * https://docs.mongodb.com/manual/core/index-unique/
	 */
	@Field(value="CODE", order = 2)
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION", order = 3) 				private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION", order = 4) 				private String description;
	
	@Field(value="IS_ACTIVE", order = 5) 				private boolean isActive;
	
	@Transient
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
}
