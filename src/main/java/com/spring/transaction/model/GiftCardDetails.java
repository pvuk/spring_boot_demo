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
 * @since Sun 10-Nov-2019 15:28
 */
@Data
@Document(collection = "GIFT_CARD_DETAILS")
public class GiftCardDetails {

	@Id
	@Field(value = "GIFT_CARD_DETAILS_ID")								private String giftCardDetailsId;
	
	@Field(value="NAME_ON_CARD")										private String nameOnCard;
	
	@NotNull(message = "Card Number is required field.")
	@Field(value="CARD_NUMBER")											private String cardNumber;
	
	@NotNull(message = "Pin is required field.")
	@Field(value="PIN")													private String pin;
	
	@Field(value="DESCRIPTION")											private String description;
	
	@Field(value="RECEIVED_ON")											private Date receivedOn;
	
	@Field(value="VALID_FROM")											private Date validFrom;
	
	@Field(value="VALID_TO")											private Date validTo;
	
	@Field(value="GIFT_CARD_STATUS_ID")									private String giftCardStatusId;
	
	@Field(value="GIFT_CARD_TYPE_ID")									private String giftCardTypeId;
	
	@Field(value="GIFT_CARD_ID")										private String giftCardId;
	
	@Field(value="CARD_CATEGORY_ID")									private String cardCategoryId;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")										private String customerId;
}
