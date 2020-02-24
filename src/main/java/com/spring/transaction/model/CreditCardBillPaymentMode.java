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
 * 
 * @author venkataudaykiranp
 * @Date Mon 24-Feb-2020 18:55
 * 
 * @version 2
 */
@Data
@Document(collection="CREDIT_CARD_Bill_PAYMENT_MODE_CODE")
public class CreditCardBillPaymentMode {
	
	@Id
	@Field(value = "CREDIT_CARD_BILL_PAYMENT_MODE_ID")											private String creditCardBillPaymentModeId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Mode Of Payment Code is required field.")
	@Field(value = "CODE")																		private String code;

	@Field(value = "POSITION")																	private int position;

	@NotNull(message = "Credit Card Bill Payment Mode is required field.")
	@Field(value = "DESCRIPTION")																private String description;
	
//	Supported by RBL eservices CC payment
//	@NotNull(message="Credit Card is required field.")
//	private CreditCard creditCard;
//	
//	@NotNull(message="Credit Card Bill Payment Type is required field.")
//	private List<CreditCardBillPaymentType> ccBillPaymentTypeList;
//	
//	@Field(value="MODE_OF_PAYMENT")
//	private String modeOfPayment;
//	
//	/**
//	 * <p>* 1. Available Limit Release is subject to bank’s policies and discretion.<p>
//	 */
//	private String noteAvailableLimitRelease;
//	
//	/**
//	 * <p>
//	 *	*1. Turn around Time is mentioned in Business Days.
//	 * 	2. In span of ? days available limit will be shown. 
//	 * </p>
//	 */
//	private String noteTurnaroundTime;
//	
//	/**
//	 * 1. Check how this field position is placed in MongoDB., because only this column order is mentioned.
//	 */
//	@Field(value="CUSTOMER_ID", order = 6)
//	@NotNull(message="Customer is required field.")
//	private String customerId;
}
