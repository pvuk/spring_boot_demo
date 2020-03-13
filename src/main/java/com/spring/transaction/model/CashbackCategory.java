package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CASHBACK_CATEGORY_CODE")
public class CashbackCategory {

	@Id
	@Field(value = "CASHBACK_CATEGORY_ID", order = 1)						private String cashbackCategoryId;

	@Field(value = "CODE", order = 2)										private String code;
	
	@Field(value = "POSITION", order = 3)									private int position;
	
	@NotNull(message = "Cashback Category is required field.")
	@Field(value = "DESCRIPTION", order = 4)								private String description;
}
