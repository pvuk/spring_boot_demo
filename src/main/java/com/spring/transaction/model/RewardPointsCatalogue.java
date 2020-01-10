package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "REWARD_POINTS_CATALOGUE")
public class RewardPointsCatalogue {

	@Id
	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 1)					private String rewardPointsCatalogueId;
	
	@Field(value="CODE", order = 2)											private String code;
	
	@Field(value="POSITION", order = 3)										private int position;
	
	/**
	 * 1. Show all linked cards to User Account in dropdown list.
	 */
	@Field(value = "CARD_DETAILS_ID", order = 4)							
	@NotNull(message = "Card is required field.")							private String cardDetailsId;
	
	@Field(value="ON_EVERY_PAYMENT", order = 5)
	@NotNull(message = "On Every Payment is required field.")				private BigDecimal onEveryPayment;
	
	@Field(value="REWARD_POINTS_EARN", order = 6)
	@NotNull(message = "Reward Points Earn is required field.")				private BigDecimal rewardPointsEarn;
	
	@Field(value="EACH_REWARD_POINT_VALUE", order = 7)
	@NotNull(message = "Each Reward Point Value is required field.")		private BigDecimal eachRewardPointValue;
	
	/**
	 * <h1>As Per SBI DebitCard</h1>
	 * 1. If the transaction REWARD_POINTS_CAP.PAID_AMOUNT is 100 user will get 1 reward point.
	 * 2. if the transaction REWARD_POINTS_CAP.PAID_AMOUNT is >= 101 and <= 199 he will get only 1 reward point.
	 * 3. 100 points max per ₹ 10,000.
	 * 4. 1000 points monthly cap, beyond 1000 points no reward points.
	 * 5. Warn user if he reaches >=900 monthly cap, to use another card.
	 * 6. If user reaches monthly cap suggest another card to earn more reward points.
	 */
	@Field(value = "MAX_POINTS_PER_TRANSACTION")							private Long maxPointsPerTransaction;
	
	/**
	 * <h1>As Per SBI DebitCard</h1>
	 * 1. On Min ₹ 100 transaction get 1 Reward Point.
	 * 2. On Max ₹ 10,000 transaction get 100 Reward Points.
	 * 3. On ₹ 1,00,000(₹ 10,000 x 10) transaction get 1,000 Reward points, beyond no reward points.
	 * 4. If the transaction ₹ 10,001 or greater user can get only 100 points. "Transactional Capping is reached" message will display.
	 */
	@Field(value = "MAX_PAYMENT_CAP")											private BigDecimal maxPaymentCap;
	
	@Field(value="CUSTOMER_ID", order = 8)
	@NotNull(message="Customer is required field.")							private String customerId;
}
