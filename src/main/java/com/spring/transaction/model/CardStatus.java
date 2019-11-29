package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p>
 * Card Status
 * <ul>This Document used on following cases:
 * 	<li>Debit Card</li>
 * 	<li>Credit Card</li>
 * </ul>
 * </p>
 * 
 * @author venkataudaykiranp
 * @Date Fri 29-Nov-2019 15:26
 */
@Data
@Document(collection = "CARD_STATUS_CODE")
public class CardStatus {

	@Field(value = "CARD_STATUS_ID", order = 1)
	@Id
	private String cardStatusId;

	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Card Status Code is required field.")
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "Card Status is required field.")
	private String description;
}
