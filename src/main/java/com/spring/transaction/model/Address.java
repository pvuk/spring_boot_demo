package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

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

	@BsonId
	private Long addressId;
	
	@NotNull(message = "Permanent Address is required field.")
	private PermanentAddress permanentAddress;
	
	@NotNull(message = "Current Address is required field.")
	private Long currentAddressId;
}
