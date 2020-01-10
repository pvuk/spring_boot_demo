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
 * 	<ol> Card Category
 * 		<li>CREDIT_CARD_CODE</li>
 * 		<li>DEBIT_CARD_CODE</li>
 * 		<li>GIFT_CARD_CODE</li>
 * 		<li>WALLET_CARD_CODE</li>
 * 		<li>REWARD_CARD</li>
 * 	</ol>
 * </p>
 * @author P V UdayKiran
 *
 * @Date: Tue 03-Dec-2019 21:52
 * @version 2
 */
@Data
@Document(collection = "CARD_CATEGORY_CODE")
public class CardCategory {

	@Field(value = "CARD_CATEGORY_ID", order = 1)
	@Id
	private String cardCategoryId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Card Category Code is required field.")
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "Card Category is required field.")
	private String description;
}
