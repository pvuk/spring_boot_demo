package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p> Present Reward Card applies to Payback.in cards</p>
 * @author P V UdayKiran
 *
 * @Date: Tue 03-Dec-2019 21:54
 */
@Data
@Document(collection = "REWARD_CARD")
public class RewardCard {
	
	@Id
	@Field(value="REWARD_CARD_ID", order = 1)
	private String rewardCardId;
	
	@NotNull(message = "Card Number is required field.")
	@Field(value="CARD_NUMBER", order = 2)
	private String cardNumber;
	
	@Field(value="NAME_ON_CARD", order = 3)
	private String nameOnCard;
	
	/**
	 * 1. Card PIN
	 */
	@NotNull(message = "Pin is required field.")
	@Field(value="PIN", order = 4)
	private String pin;
	
	@Field(value = "EMAIL", order = 5)
	private String email;
	
	@NotNull(message = "Mobile Number is required field.")
	@Field(value = "MOBILE_NUMBER", order = 6)
	private Long mobileNumber;
	
	/**
	 * 1. M_PIN for login into payback.in site
	 */
	@Field(value = "M_PIN", order = 7)
	private Integer mPin;
	
	@Field(value = "ADDRESS_ID", order = 8)
	private ObjectId addressId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 9)
	private String customerId;
}
