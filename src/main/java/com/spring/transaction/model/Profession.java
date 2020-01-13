package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PROFESSION_CODE")
public class Profession {

	@Id
	@Field(value = "PROFESSION_ID")
	private String professionId;

	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Prefession Code is required field.")
	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@NotNull(message = "Profession is required field.")
	@Field(value = "DESCRIPTION", order = 4)
	private String description;
}
