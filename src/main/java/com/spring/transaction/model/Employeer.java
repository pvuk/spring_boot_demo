package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="EMPLOYEER")
public class Employeer {

	@Id
	@Field(value="EMPLOYEER_ID", order = 1)
	private String employeerId;

	@NotNull(message = "Employeer Name is required field.")
	@Field(value = "EMPLOYEER_NAME", order = 2)
	private String empolyeerName;
	
	@Field(value = "NUMBER_OF_EMPLOYEES", order = 3)
	private BigDecimal numberOfEmployees;
	
	@Field(value = "ADDRESS_ID", order = 4)
	private String addressId;
}
