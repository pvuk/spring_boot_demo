package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

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
@Document(collection = "CURRENT_ADDRESS")
public class CurrentAddress {

	@Field(value="CURRENT_ADDRESS_ID", order = 1)
	@Id
	private String currentAddressId;

	@Field(value="ADDRESS", order = 2)
	private String address;

	@Field(value="CITY", order = 3)
	private String city;
	
	@Field(value="PIN_CODE", order = 4)
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
}
