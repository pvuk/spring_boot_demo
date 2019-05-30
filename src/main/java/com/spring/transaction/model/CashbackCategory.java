package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CASHBACK_CATEGORY_CODE")
public class CashbackCategory {

	@Field(value = "CASHBACK_CATEGORY_ID", order = 1)
	@Id
	private String cashbackCategoryId;

	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotEmpty(message = "Cashback Category is required field.")
	private String description;
}
