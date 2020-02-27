package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * @Date Thu 27-Feb-2020 15:32
 */
@Data
@Document(value = "RATE_YOUR_EXPERIENCE_CODE")
public class RateYourExperience {

	@Id
	@Field(value = "RATE_YOUR_EXPERIENCE_ID", order = 1)
	private String rateYourExperienceId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Rate Your Purchase Experience Code is required field.")
	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@NotNull(message = "Rate Your Purchase Experience is required field.")
	@Field(value = "DESCRIPTION", order = 4)
	private String description;
}
