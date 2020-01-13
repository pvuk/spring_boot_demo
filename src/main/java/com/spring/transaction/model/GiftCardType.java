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
 * Gift Card Type
 * <ul>This Document used on following cases:
 * 	<li>Gift Card</li>
 * 	<li>Voucher</li>
 * 	<li>E-Voucher</li>
 * 	<li>E-Gift Card</li>
 * 	<li>Gifted By Others</li>
 * </ul>
 * </p>
 * 
 * @author venkataudaykiranp
 * @since Fri 29-Nov-2019 16:22
 */
@Data
@Document(collection = "GIFT_CARD_TYPE_CODE")
public class GiftCardType {
	
	@Id
	@Field(value = "GIFT_CARD_TYPE_ID", order = 1)
	private String giftCardTypeId;

	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Gift Card Type Code is required field.")
	@Field(value = "CODE", order = 2)
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@NotNull(message = "Gift Card Type is required field.")
	@Field(value = "DESCRIPTION", order = 4)
	private String description;
}
