package com.spring.transaction.model;

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
@Document(collection = "CURRENT_ADDRESS")
public class CurrentAddress {

	@Id
	private Long currentAddressId;

	private String address;

	private String city;
	
	private String pinCode;

	private String state;

	private String country;
}
