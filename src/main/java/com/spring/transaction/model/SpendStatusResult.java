package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author P V UdayKiran
 *
 * @Date: Sat 28-Dec-2019 20:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="SPEND_STATUS_RESULT_CODE")
public class SpendStatusResult {

	@Field(value = "SPEND_STATUS_RESULT_ID", order = 1)
	@Id 															private String spendStatusResultId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true)											private String code;
	
	@Field(value = "POSITION", order = 3) 							private Long position;
	
	@NotNull(message = "Spend Status Result is required field.")
	@Field(value = "DESCRIPTION", order = 4) 						private String description;
	
	@Field(value = "SPEND_STATUS_ID", order = 5)					private String spendStatusId;
}
