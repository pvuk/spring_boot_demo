package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="CUSTOMER")
public class Customer {
	
	@Id
	private String customerId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	@NotNull(message= "Address is required field")
	private String addressId;
	
	private String employeerId;
}
