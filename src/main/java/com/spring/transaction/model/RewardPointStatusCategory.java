package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author P V UdayKiran
 *
 * @Date Sun 29-Dec-2019 07:39
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="REWARD_POINT_STATUS_CATEGORY")
public class RewardPointStatusCategory {

	@Id
	@Field(value = "REWARD_POINT_STATUS_CATEGORY_ID", order = 1)			private String rewardPointStatusCategoryId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true)													private String code;
	
	@Field(value = "POSITION", order = 3) 									private Long position;
	
	@NotNull(message = "Reward Point Status Category is required field.")
	@Field(value = "DESCRIPTION", order = 4) 								private String description;
	
	@NotNull(message = "Reward Point Status is required field.")
	@Field(value = "REWARD_POINT_STATUS_ID", order = 1)						private String rewardPointStatusId;
}
