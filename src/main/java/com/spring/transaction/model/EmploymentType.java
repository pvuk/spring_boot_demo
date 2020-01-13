package com.spring.transaction.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "EMPLOYMENT_TYPE_CODE")
public class EmploymentType {
	
	@Id
	@Column(name = "EMPLOYMENT_TYPE_ID")
	private String employmentTypeId;
	
	@NotNull(message="'Employee Type' Code is required field.")
	@Indexed(unique=true)
	@Field(value="CODE")
	private String code;
	
	@Field(value="POSITION")
	private Long position;
	
	@NotNull(message="Employee Type is required field.")
	@Field(value="DESCRIPTION")
	private String description;
}
