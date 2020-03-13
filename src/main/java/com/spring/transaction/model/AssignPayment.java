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
	
	@Id
	@Field(value = "ASSIGN_PAYMENT_ID", order = 1)											private String assignPaymentId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Assign Payment Code is required field.")
	@Field(value = "CODE", order = 2)														private String code;

	@Field(value = "POSITION", order = 3)													private int position;

	@NotNull(message = "Assign Payment is required field.")
	@Field(value = "DESCRIPTION", order = 4)												private String description;
}
