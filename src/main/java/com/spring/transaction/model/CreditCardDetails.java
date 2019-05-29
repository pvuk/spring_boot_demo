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
	private String creditCardDetailsId;

	@Indexed(unique = true)
	private String cardNumber;

	private int expireMonth;

	private int expireYear;

	private String nameOnCard;

	private int cvv;

	private boolean allowedInternationalTransaction;

	@NotNull(message = "BankId is required field.")
	private long bankId;

	private long cardTypeId;

	private Date cardIssuedOn;

	private Date cardExpiredOn;

	@Field(value = "REWARD_CARD_ID")
	@NotNull(message="Reward Card is required field.")
	private Long rewardCardId;

	@NotNull(message = "Customer is required field.")
	private String customerId;
}
