package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "CARD_TYPE_CODE")
public class CardType {

	@Id
	private long cardTypeId;

	private String code;
	
	private int position;
	
	@NotEmpty(message = "Card Type is required field")
	private String description;

}
