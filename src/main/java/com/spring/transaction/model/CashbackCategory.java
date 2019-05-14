package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CASHBACK_CATEGORY_CODE")
public class CashbackCategory {

	@Id
	private String cashbackCategoryId;

	private String code;
	
	private int position;
	
	@NotEmpty(message = "Cashback Category is required field.")
	private String description;
}
