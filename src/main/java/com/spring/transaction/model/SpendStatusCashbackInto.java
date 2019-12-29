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
 * @Date: Sun 29-Dec-2019 07:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="SPEND_STATUS_CASHBACK_INTO_CODE")
public class SpendStatusCashbackInto {

	@Field(value = "SPEND_STATUS_CASHBACK_INTO_ID", order = 1)
	@Id 															private String spendStatusCashbackIntoId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true)											private String code;
	
	@Field(value = "POSITION", order = 3) 							private Long position;
	
	@NotNull(message = "Spend Status Cashback Into is required field.")
	@Field(value = "DESCRIPTION", order = 4) 						private String description;
}
