package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * This table is in continuous chain flow.
 * 
 * CREDIT_CARD_STATEMENT -> CREDIT_CARD_Bill_PAYMENT_MODE_CODE -> CREDIT_CARD_BILL_PAYMENT_TYPE -> CREDIT_CARD_BILL_PAYMENT_TURN_AROUND_TIME
 *
 */
@Data
@Document(collection="CREDIT_CARD_BILL_PAYMENT_LOGIN_AND_ACCESS")
public class CreditCardBillPaymentLoginAndAccess {
	
	@Id
	private String creditCardBillPaymentLoginAndAccessId;
	
	@NotNull(message = "Credit Card Bill Payment Type is required field.")
	private String creditCardBillPaymentTypeId;
	
	/**
	 * 1. This field contains link description
	 * 
	 */
	private String loginAndAccessLinkDescription;
	
	/**
	 * 1. This field contains link
	 * 2. Contains Links to redirect payment gateways.
	 */
	private String loginAndAccessLink;
	
	/**
	 * 1. This field contains image data in database or image link reference to display on UI
	 */
	private String loginAndAccessImage;
	
	private String comment;
}
