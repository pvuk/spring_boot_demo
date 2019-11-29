package com.spring.transaction.model;

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
public class CreditCard {

	@Field(value = "CREDIT_CARD_ID", order = 1)
	@Id 												private String creditCardId;

	/**
	 * 1. <a href="https://docs.mongodb.com/manual/core/index-unique/">Unique Indexes</a>
	 */
	@Field(value="CODE", order = 2)
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION", order = 3) 				private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION", order = 4) 				private String description;
	
	@Transient
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
}
