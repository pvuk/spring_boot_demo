package com.spring.transaction.model;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "YEARS_OF_EXPERIENCE_CODE")
public class YearsOfExperience {

	@Column(name = "YEARS_OF_EXPERIENCE_ID")
	private String yearsOfExperienceId;
	
	private String code;
	
	private Long position;
	
	private String description;
}
