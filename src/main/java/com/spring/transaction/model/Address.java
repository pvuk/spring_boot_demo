package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

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

	@Id
	private Long addressId;
	
	@DBRef
	@Field(value="PERMANENT_ADDRESS")
	@NotNull(message = "Permanent Address is required field.")
	private PermanentAddress permanentAddress;
	
	@DBRef
	@Field(value="CURRENT_ADDRESS")
	@NotNull(message = "Current Address is required field.")
	private CurrentAddress currentAddress;
}
