package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CARD_TYPE")
public class CardType {

	@Id
	private long cardTypeId;

	private String code;
	
	private int position;
	
	@NotEmpty(message = "Card Type is required field")
	private String description;

}
