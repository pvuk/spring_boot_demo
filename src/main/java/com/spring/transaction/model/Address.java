package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "ADDRESS")
public class Address {

	@Field(value = "ADDRESS_ID", order = 1)
	@Id
	private ObjectId addressId;

	@DBRef
	@Field(value = "PERMANENT_ADDRESS", order = 2)
	@NotNull(message = "Permanent Address is required field.")
	private PermanentAddress permanentAddress;

	@DBRef
	@Field(value = "CURRENT_ADDRESS", order = 3)
	@NotNull(message = "Current Address is required field.")
	private CurrentAddress currentAddress;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
