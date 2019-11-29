package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * A gift card is a prepaid stored-value money card usually issued by a retailer
 * or bank to be used as an alternative to cash for purchases within a
 * particular store or related businesses.
 * 
 * @author Priyanka
 *
 * @Date: Sun 10-Nov-2019 15:28
 */
@Data
@Document(collection = "GIFT_CARD_DETAILS")
public class GiftCardDetails {

	@Id
	@Field(value = "GIFT_CARD_DETAILS_ID")						private String giftCardDetailsId;
	
	private String description;
	private Date receivedOn;
	private Date validFrom;
	private Date validTo;
	private String giftCardStatusId;
	private String giftCardTypeId;
	private String cardCategoryId;

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
