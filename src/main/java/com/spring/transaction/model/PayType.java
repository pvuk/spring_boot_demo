package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PAY_TYPE_CODE")
public class PayType {

	@Id
	@Field(value = "PAY_TYPE_ID")						private String payTypeId;
	
	@Indexed(unique=true)
	@Field(value="CODE")								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Pay Type is required field.")
	@Field(value="DESCRIPTION") 						private String description;
	
	/**
	 * 1. Display format in DropDown should be DESCRIPTION (DETAILS)
	 */
	@Field(value="DETAILS")								private String details;
}
