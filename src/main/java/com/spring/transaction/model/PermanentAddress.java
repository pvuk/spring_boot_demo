package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PERMANENT_ADDRESS")
public class PermanentAddress {

	@Field(value="PERMANENT_ADDRESS_ID", order = 1)
	@Id
	private String permanentAddressId;

	@Field(value="ADDRESS", order = 2)
	private String address;

	@Field(value="CITY", order = 3)
	private String city;

	@Field(value="PINCODE", order = 4)
	private String pinCode;
	
	@Field(value="DISTRICT", order = 5)
	private String district;
	
	@Field(value="STATE", order = 6)
	private String state;

	@Field(value="COUNTRY", order = 7)
	private String country;

	@Field(value="ADDRESS_ID", order = 8)
	@NotEmpty(message = "Address is required field.")
	private String addressId;
	
	@Field(value="CUSTOMER_ID", order = 9)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
