package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "CREDIT_CARD_CODE")
public class CreditCard {

	@Id
	private String creditCardId;

	@Indexed(unique = true)
	private String cardNumber;
	
	private int expireMonth;
	
	private int expireYear;
	
	private String nameOnCard;
	
	private int cvv;
	
	private boolean allowedInternationalTransaction;
	
	private boolean vertualCard;

	@NotNull(message = "BankId is required field.")
	private long bankId;
	
	private long cardTypeId;
	
	private Date cardIssuedOn;
	
	private Date cardExpiredOn;
	
	private Long rewardCardId;
}
