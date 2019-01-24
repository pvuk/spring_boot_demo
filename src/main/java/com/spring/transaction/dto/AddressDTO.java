package com.spring.transaction.dto;

import lombok.Data;

@Data
public class AddressDTO {

	private Long addressId;
	private PermanentAddressDTO permanentAddressDTO;
	private CurrentAddressDTO currentAddressDTO;
}
