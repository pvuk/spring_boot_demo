package com.spring.transaction.dto;

import lombok.Data;

@Data
public class PermanentAddressDTO {

	private Long permanentAddressId;

	private String address;

	private String city;

	private String pinCode;

	private String state;

	private String country;
}
