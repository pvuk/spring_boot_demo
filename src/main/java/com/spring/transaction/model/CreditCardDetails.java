package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_CARD_DETAILS")
public class CreditCardDetails {

	@Id
	@Field(value = "CREDIT_CARD_DETAILS_ID", order = 1)
	private String creditCardDetailsId;

	@Indexed(unique = true)
	@Field(value = "CARD_NUMBER", order = 2)
	private String cardNumber;

	@Field(value = "EXPIRE_MONTH", order = 3)
	private int expireMonth;

	@Field(value = "EXPIRE_YEAR", order = 4)
	private int expireYear;

	@Field(value = "NAME_ON_CARD", order = 5)
	private String nameOnCard;

	@Field(value = "CVV", order = 6)
	private int cvv;

	@Field(value = "ALLOWED_INTERNATIONAL_TRANSACTION", order = 7)
	private boolean allowedInternationalTransaction;

	@NotNull(message = "Credit Card is required field.")
	@Field(value = "CREDIT_CARD_ID", order = 8)
	private String creditCardId;
	
	@NotNull(message = "BankId is required field.")
	@Field(value = "BANK_ID", order = 9)
	private long bankId;

	@Field(value = "CARD_TYPE_ID", order = 10)
	private long cardTypeId;

	@Field(value = "VALID_FROM_MONTH", order = 11)
	private Date validFromMonth;

	@Field(value = "VALID_FROM_YEAR", order = 12)
	private Date validFromYear;

	@NotNull(message="Reward Card is required field.")
	@Field(value = "REWARD_CARD_ID", order=13)
	private Long rewardCardId;
	
	@Field(value = "CARD_STATUS_ID", order=14)
	private String cardStatusId;
	
	@Field(value = "IS_SEMI_CLOSED", order=15)
	private Boolean isSemiClosed;
	
	@Field(value = "CARD_LIMIT_ID", order=16)
	private String cardLimitId;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID", order = 17)
	private String customerId;
}
