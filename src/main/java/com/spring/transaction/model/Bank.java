package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document(collection = "BANK_CODE")
public class Bank {

	@Id
	@Field(value = "BANK_ID", order = 1)
	private ObjectId bankId;

	@Field(value = "BANK_NAME", order = 2)
	@Indexed(unique = true)
	@NotNull(message = "Bank Name Can't be empty.")
	@NotBlank(message = "Bank Name is required field.")
	private String bankName;

	/**
	 * Pass MongoDB Field value for inserting data, if Field value is different then new column is created.
	 * 
	 * In MongoDB Field value and java Field value is different.
	 * Ex: In DB Field value BANK_NAME not equal to Java Field value bankName
	 */
	@Override
	public String toString() {
		return "{\"BANK_NAME\":" +"\""+ bankName + "\"}";
	}
	
}
