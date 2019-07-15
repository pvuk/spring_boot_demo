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
	
	@Field(value="DEBIT_CARD_DETAILS_ID", order = 1)
	@Id private String debitCardDetailsId;
	
	@Field(value="CARD_NUMBER", order = 2)
	@Indexed(unique = true)
	private String cardNumber;
	
	@Field(value="EXPIRE_MONTH", order = 3)
	private int expireMonth;
	
	@Field(value="EXPIRE_YEAR", order = 4)
	private int expireYear;
	
	@Field(value="NAME_ON_CARD", order = 5)
	@NotNull(message = "Name On Card is required field.")
	private String nameOnCard;
	
	@Field(value="CVV", order = 6)
	private int cvv;
	
	@Field(value="ALLOW_INTERNATIONAL_TRANSACTION", order = 7)
	private boolean allowInternationalTransaction;
	
	@Field(value = "DEBIT_CARD_ID", order = 8)
	@NotNull(message = "Debit Card is required field.")
	private String debitCardId;
	
	@Field(value="BANK_ID", order = 9)
	@NotNull(message = "Bank Name is required field.")
	private long bankId;
	
	@Field(value="CARD_TYPE_ID", order = 10)
	@NotNull(message = "Card Type is required field.")
	private long cardTypeId;
	
	@Field(value="CARD_ISSUED_ON", order = 11)
	private Date cardIssuedOn;
	
	@Field(value = "REWARD_CARD_ID", order = 12)
	@NotNull(message="Reward Card is required field.")
	private String rewardCardId;

	@Field(value = "IS_ACTIVE", order=13)
	private Boolean isActive;
	
	@Field(value = "IS_SEMI_CLOSED", order=14)
	private Boolean isSemiClosed;
	
	@Field(value = "CARD_LIMIT_ID", order=15)
	private String cardLimitId;
	
	@Field(value="CUSTOMER_ID", order = 16)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
