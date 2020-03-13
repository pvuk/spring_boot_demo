package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="DEBIT_CARD_DETAILS")
public class DebitCardDetails {
	
	@Id
	@Field(value="DEBIT_CARD_DETAILS_ID", order = 1)
	private String debitCardDetailsId;
	
	@Indexed(unique = true)
	@Field(value="CARD_NUMBER", order = 2)
	private String cardNumber;
	
	@Field(value="EXPIRE_MONTH", order = 3)
	private int expireMonth;
	
	@Field(value="EXPIRE_YEAR", order = 4)
	private int expireYear;
	
	@NotNull(message = "Name On Card is required field.")
	@Field(value="NAME_ON_CARD", order = 5)
	private String nameOnCard;
	
	@Field(value="CVV", order = 6)
	private int cvv;
	
	@Field(value="ALLOW_INTERNATIONAL_TRANSACTION", order = 7)
	private boolean allowInternationalTransaction;
	
	@NotNull(message = "Debit Card is required field.")
	@Field(value = "DEBIT_CARD_ID", order = 8)
	private String debitCardId;
	
	@NotNull(message = "Bank Name is required field.")
	@Field(value="BANK_ID", order = 9)
	private long bankId;
	
	@NotNull(message = "Card Type is required field.")
	@Field(value="CARD_TYPE_ID", order = 10)
	private long cardTypeId;
	
	@Field(value="CARD_ISSUED_ON", order = 11)
	private Date cardIssuedOn;
	
	@NotNull(message="Reward Card is required field.")
	@Field(value = "REWARD_CARD_ID", order = 12)
	private String rewardCardId;

	@Field(value = "CARD_STATUS_ID", order=13)
	private String cardStatusId;
	
	@Field(value = "IS_SEMI_CLOSED", order=14)
	private Boolean isSemiClosed;
	
	@Field(value = "CARD_LIMIT_ID", order=15)
	private String cardLimitId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 16)
	private String customerId;
}
