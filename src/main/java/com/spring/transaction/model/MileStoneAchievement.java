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
	 * 2. Alert the user before 4 months, 3 months, 2 months, 1 month, 1 week, 1 day to achieve milestone.
	 * 3. If Achieved Milestone don't send alerts.
	 * 4. Check next card which is not completed Milestone.
	 */
	@Field(value = "MILESTONE_ACHIEVED_IF_SPENDS_BEFORE_ON")
	private Date mileStoneAchievedIfSpendsBeforeOn;
	
	/**
	 * 1. Total Spend to Achieve Milestone Benefit
	 */
	@Field(value = "MILESTONE_ACHIEVEMENT_ON_SPENDS_OFF")
	private BigDecimal mileStoneAchievementOnSpendsOff;
	
	@Field(value = "REMAINING_SPENDS_LEFT_FOR_ACHIEVE_MILESTONE")
	private BigDecimal remainingSpendsLeftForAchieveMileStone;

	/**
	 * 1. If MILESTONE_ACHIEVED = true update MILESTONE_ACHIEVED_ON date
	 */
	@Field(value = "MILESTONE_ACHIEVED_ON")
	private Date milestoneAchievedOn;
	
	/**
	 * 1. If REMAINING_SPENDS_LEFT_FOR_ACHIEVE_MILESTONE <= 0 set MILESTONE_ACHIEVED = true
	 */
	@Field(value = "MILESTONE_ACHIEVED")
	private boolean milestoneAchieved;
	
	/**
	 * 1. When current date is greater than MILESTONE_ACHIEVED_IF_SPENDS_BEFORE_ON set CLOSED_MILESTONE_ACHIEVEMENT = true
	 */
	@Field(value = "CLOSED_MILESTONE_ACHIEVEMENT")
	private boolean closedMilestoneAchievement;
	
	/**
	 * 1. Milestone details of CREDIT_CARD / DEBIT_CARD
	 */
	@Field(value = "BENEFIT")
	private String benefit;
	
	@Field(value = "COMMENT")
	private String comment;
}
