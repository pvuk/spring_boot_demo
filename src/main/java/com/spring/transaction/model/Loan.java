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
 * @author venkataudaykiranp
 * @since Mon 30-Dec-2019 13:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="LOAN_CODE")
public class Loan {

	@Id
	@Field(value = "LOAN_ID", order = 1)							private String loanId;
	
	@Indexed(unique = true)
	@Field(value = "CODE", order = 2)								private String code;
	
	@Field(value = "POSITION", order = 3) 							private Long position;
	
	@NotNull(message = "Loan is required field.")
	@Field(value = "DESCRIPTION", order = 4) 						private String description;
	
}
