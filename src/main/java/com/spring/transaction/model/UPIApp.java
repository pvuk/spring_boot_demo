package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UPI_APP_CODE")
public class UPIApp {

	@Id
	@Field("UPI_APP_ID")
	private String upiAppId;

	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "UPI App Code is required field.")
	@Field("CODE")
	private String code;
	
	@Field(value = "POSITION")
	private int position;

	@Field("DESCRIPTION")
	private String description;
	
	@Field("COMMENT")
	private String comment;

}
