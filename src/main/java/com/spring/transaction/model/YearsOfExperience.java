package com.spring.transaction.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "YEARS_OF_EXPERIENCE_CODE")
public class YearsOfExperience {

	@Id
	@Column(name = "YEARS_OF_EXPERIENCE_ID")												private String yearsOfExperienceId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Years Of Experience Code is required field.")
	@Field(value = "CODE", order = 2)														private String code;
	
	@Field(value = "POSITION", order = 3)													private Long position;
	
	@NotNull(message = "Years Of Experience is required field.")
	@Field(value="DESCRIPTION", order = 4)													private String description;
}
