package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CURRENCY_CODE")
public class Currency {
	
	@Id
	private Long currencyId;

	private String code;
	private String description;
	private Long position;
	private String type;
}
