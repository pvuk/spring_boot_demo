package com.spring.transaction.dto;

import lombok.Data;

@Data
public class CurrentAddressDTO {

	private Long currentAddressId;

	private String address;

	private String city;
	
	private String pinCode;

	private String state;

	private String country;
}
