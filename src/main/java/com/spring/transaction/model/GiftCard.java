package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(value = "GIFT_CARD_CODE")
public class GiftCard {
	
	@Id
	@Field(value = "GIFT_CARD_ID", order = 1)
	private String giftCardId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Gift Card Code is required field.")
	@Field(value = "CODE", order = 2)
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@NotNull(message = "Gift Card is required field.")
	@Field(value = "DESCRIPTION", order = 4)
	private String description;
}
