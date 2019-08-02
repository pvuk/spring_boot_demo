package com.spring.transaction.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "EMPLOYMENT_TYPE_CODE")
public class EmploymentType {
	
	@Column(name = "EMPLOYMENT_TYPE_ID")
	@Id
	private String employmentTypeId;
	
	private String code;
	
	private Long position;
	
	private String description;
}
