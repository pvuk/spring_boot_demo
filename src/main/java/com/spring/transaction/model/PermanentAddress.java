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

	@Field(value="STATE", order = 5)
	private String state;

	@Field(value="COUNTRY", order = 6)
	private String country;

	@Field(value="ADDRESS_ID", order = 7)
	@NotEmpty(message = "Address is required field.")
	private String addressId;
}
