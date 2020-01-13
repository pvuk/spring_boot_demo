package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author P V UdayKiran
 *
 * @Date Tue 03-Dec-2019 19:34
 */
@Data
@Document(collection = "ASSIGN_PAYMENT_CODE")
public class AssignPayment {
	
	@Field(value = "ASSIGN_PAYMENT_ID", order = 1)
	@Id
	private String assignPaymentId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Assign Payment Code is required field.")
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "Assign Payment is required field.")
	private String description;
}
