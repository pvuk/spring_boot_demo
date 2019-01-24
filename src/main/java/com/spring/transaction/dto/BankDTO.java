package com.spring.transaction.dto;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class BankDTO {

	private ObjectId bankId;
	private String bankName;
	private String ifscCode;
	private long micrCode;
	private long branchCode;
	private String branch;
	private String contactNumber;
	private AddressDTO addressDTO;
}
