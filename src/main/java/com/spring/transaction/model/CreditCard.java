package com.spring.transaction.model;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
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
	
	@Type(type = "yes_no")
	@Field(value="ACTIVE", order = 5)					private	Boolean active;
	
	@Type(type = "yes_no")
	@Field(value="UPGRADED", order = 6)					private Boolean upgraded;
	
	/**
	 * 1. once Credit Card is CLOSED true, the value of ACTIVE should be set to false.
	 * 2. if UPGRADED true value of CLOSED set to true.
	 */
	@Type(type = "yes_no")
	@Field(value="CLOSED", order = 7)					private Boolean closed;
	
	/**
	 * 1. When Credit Card is upgraded update CREDIT_CARD_ID with UPGRADE_CREDIT_CARD_ID.
	 * 2. ACTIVE set false, UPGRADED true.
	 */
	@Field(value="UPGRADE_CREDIT_CARD_ID", order = 8)	private String upgradeCreditCardId;
	
	@Field(value="CUSTOMER_ID", order = 9)
	@NotNull(message = "Customer is required field.")	private String customerId;
	
	@Transient
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
}
