package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="EMPLOYEER")
public class Employeer {

	@Id
	private String employeerId;

	@Field(value = "EMPLOYEER_NAME")
	@NotNull(message = "Employeer Name is required field.")
	private String empolyeerName;

	@Field(value = "ADDRESS_ID")
	private String addressId;
}
