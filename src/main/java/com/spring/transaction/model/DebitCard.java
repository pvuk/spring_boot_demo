package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "DEBIT_CARD_CODE")
public class DebitCard {

	@Id
	private long debitCardId;

	@Indexed(unique = true)
	private String cardNumber;
	
	private int expireMonth;
	
	private int expireYear;
	
	private String nameOnCard;
	
	private int cvv;
	
	private boolean allowedInternationalTransaction;
	
	private boolean vertualCard;

	@NotNull(message = "BankId is required field")
	private long bankId;
	
	private long cardTypeId;
	
	private Date cardIssuedOn;
	
	private Long rewardCardId;
}
