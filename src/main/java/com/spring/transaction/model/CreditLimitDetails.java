package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_LIMIT_DETAILS")
public class CreditLimitDetails {
	
	@Field(value="CREDIT_LIMIT_DETAILS_ID", order = 1)
	@Id
	private String creditLimitDetailsId;
	
	@Field(value="CUSTOMER_ID", order = 2)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
