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
	
	@Field(value = "GIFT_CARD_DETAILS_ID")					private String giftCardDetailsId;
	
	@Field(value = "CASHBACK_ID")							private String cashbackId;
	
	@Field(value = "COUPON_DETAILS_ID")						private String couponDetailsId;
	
	@Field(value = "VOUCHER_DETAILS_ID")					private String voucherDetailsId;
	
	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")							private String customerId;
}
