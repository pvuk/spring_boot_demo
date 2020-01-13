package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="MILESTONE_ACHIEVEMENT")
public class MileStoneAchievement {
	
	@Id
	@Field(value = "MILESTONE_ACHIEVEMENT_ID")
	private Long mileStoneAchievementId;
	
	@NotNull(message = "Card is required field.")
	@Field(value="CARD_DETAILS_ID")
	private String cardDetailsId;
	
	@Field(value="FEE_WAIVER_ID")
	private String feeWaiverId;
	
	/**
	 * 1. It should be equal to Annual Year Fee Waiver date, 
	 * 2. Alert the user before 2 months, 1 month, 1 week, 1 day to achieve milestone.
	 */
	@Field(value = "MILESTONE_ACHIEVED_IF_SPENDS_BEFORE_ON")
	private Date mileStoneAchievedIfSpendsBeforeOn;
	
	@Field(value = "MILESTONE_ACHIEVEMENT_ON_SPENDS_OFF")
	private BigDecimal mileStoneAchievementOnSpendsOff;
	
	@Field(value = "REMAINING_SPENDS_LEFT_FOR_ACHIEVE_MILESTONE")
	private BigDecimal remainingSpendsLeftForAchieveMileStone;
	
	@Field(value = "BENIFIT")
	private String benifit;
	
	@Field(value = "DESCRIPTION")
	private String description;
}
