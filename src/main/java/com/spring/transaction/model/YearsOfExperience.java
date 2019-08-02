package com.spring.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "YEARS_OF_EXPERIENCE")
public class YearsOfExperience {

	private String yearsOfExperienceId;
	
	private String code;
	
	private Long position;
	
	private String description;
}
