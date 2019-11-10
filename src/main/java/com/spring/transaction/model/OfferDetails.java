package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "OFFER_DETAILS")
public class OfferDetails {

	@Id
	@Field(value = "OFFER_DETAILS_ID")						private String offerDetailsId;
	
	private String giftCardDetailsId;
	
	private String cashbackId;
	
	private String couponDetailsId;
	
	private String voucherDetailsId;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
