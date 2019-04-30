package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	@Id
	private String permanentAddressId;

	private String address;

	private String city;

	private String pinCode;

	private String state;

	private String country;

	@NotEmpty(message = "Address is required field.")
	private String addressId;
}
