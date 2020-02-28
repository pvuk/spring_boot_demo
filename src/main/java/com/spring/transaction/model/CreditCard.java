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

	@Field(value = "CARD_STATUS_ID", order = 5)			private String cardStatusId;
	@Field(value = "UPGRADE_STATUS_ID", order = 6)		private String upgradeStatusId;
	
	@Type(type = "yes_no")
	@Field(value="ACTIVE", order = 7)					private	Boolean active;
	
	@Type(type = "yes_no")
	@Field(value="UPGRADED", order = 8)					private Boolean upgraded;
	
	/**
	 * 1. Once Credit Card is CLOSED true, the value of ACTIVE should be set to false.
	 * 2. If UPGRADED true value of CLOSED set to true.
	 */
	@Type(type = "yes_no")
	@Field(value="CLOSED", order = 9)					private Boolean closed;
	
	
	
	@Field(value="CUSTOMER_ID", order = 10)
	@NotNull(message = "Customer is required field.")	private String customerId;
	
	@Transient
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
}
