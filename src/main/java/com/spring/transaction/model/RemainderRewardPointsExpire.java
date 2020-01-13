package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "REMAINDER_REWARD_POINTS_EXPIRE")
public class RemainderRewardPointsExpire {
	
	@Id
	@Field(value="REMAINDER_REWARD_POINTS_EXPIREID")									private String remainderRewardPointsExpireId;
	
	@Type(type="yes_no")
	@Field(value="REMAINDER_SENT")														private Boolean remainderSent;
	
	@Type(type="yes_no")
	@Field(value="NOTIFICATION_SENT")													private Boolean notificationSent;
	
	@Type(type="yes_no")
	@Field(value="NOTIFICATION_READ")													private Boolean notificationRead;
	
	@Type(type="yes_no")
	@Field(value="STOP_NOTIFY")															private Boolean stopNotify;
	
	@Field(value="REWARDS_EXPIRE_THIS_MONTH") 											private long rewardsExpireThisMonth;
	
	/**
	 * 1. Save column data as 16-10-2019 23:59:59
	 */
	@Field(value="REWARDS_EXPIRE_THIS_MONTH_ON") 										private Date rewardsExpireThisMonthOn;
	
	@Field(value="REWARDS_EXPIRE_NEXT_MONTH") 											private long rewardsExpireNextMonth;
	@Field(value="POINTS_EXPIRE_NEXT_MONTH_ON") 										private Date pointsExpireNextMonthOn;
	
	@Field(value="REWARDS_EXPIRE_NEXT_THREE_MONTH") 									private long rewardsExpireNextThreeMonth;
	@Field(value="POINTS_EXPIRE_NEXT_THREE_MONTH_ON") 									private Date pointsExpireNextThreeMonthOn;
	
	@Type(type="yes_no")
	@Field(value="AUTO_REDEEM")															private boolean autoRedeem;
	
	@Field(value="REWARD_POINTS_CATALOGUE_ID")											private String rewardPointsCatalogueId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")															private String customerId;
}
