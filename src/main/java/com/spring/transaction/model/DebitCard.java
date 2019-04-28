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
	private String debitCardId;

	@Indexed(unique = true)
	private String cardNumber;
	
	private int expireMonth;
	
	private int expireYear;
	
	@NotNull(message = "Name On Card is required field")
	private String nameOnCard;
	
	private int cvv;
	
	private boolean allowedInternationalTransaction;
	
	private boolean vertualCard;

	@NotNull(message = "Bank Name is required field")
	private long bankId;
	
	@NotNull(message = "Card Type is required field")
	private long cardTypeId;
	
	private Date cardIssuedOn;
	
	private String rewardCardId;
}
