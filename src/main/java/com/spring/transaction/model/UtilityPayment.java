package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UTILITY_PAYMENT_CODE")
public class UtilityPayment {

	@Id
	@Field(value = "UTILITY_PAYMENT_ID")													private String utilityPaymentId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Utility Payment Code is required field.")
	@Field(value="CODE")																	private String code;
	
	@Field(value="POSITION") 																private Long position;
	
	@NotNull(message="Utility Payment is required field.")
	@Field(value="DESCRIPTION") 															private String description;
}
