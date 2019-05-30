package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CUSTOMER")
public class Customer {
	
	@Field(value = "CUSTOMER_ID", order = 1)
	@Id
	private String customerId;

	@Field(value = "FIRST_NAME", order = 2)
	private String firstName;
	
	@Field(value = "MIDDLE_NAME", order = 3)
	private String middleName;
	
	@Field(value = "LAST_NAME", order = 4)
	private String lastName;
	
	@Field(value = "DATE_OF_BIRTH", order = 5)
	private Date dateOfBirth;
	
	@Field(value = "ADDRESS_ID", order = 6)
	@NotNull(message= "Address is required field")
	private String addressId;
	
	@Field(value = "EMPLOYEER_ID", order = 7)
	private String employeerId;
}
