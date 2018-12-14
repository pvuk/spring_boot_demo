package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CASHBACK")
public class Cashback {
	
	private Long cashbackId;
	private BigDecimal cashbackAmount;	
	private BigDecimal payment;	
	private Date paymentOn;
	private Date cashbackOn;
	@NotEmpty(message = "Cashback Amount Description is required field")
	private String description;	
	private String cashbackEligibleOnlyWhen;	
	private String cashbackType;	
	private Long cashbackCategoryId;
}
