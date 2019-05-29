package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CREDIT_LIMIT_DETAILS")
public class CreditLimitDetails {
	
	@Id private String creditLimitDetailsId;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
}
