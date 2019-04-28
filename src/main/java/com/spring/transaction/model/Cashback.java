package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CASHBACK")
public class Cashback {
	
	@Id private String cashbackId;
	private BigDecimal cashbackAmount;	
	private BigDecimal payment;	
	private Date paymentOn;
	private Date cashbackOn;
	@NotEmpty(message = "Cashback Amount Description is required field")
	private String description;	
	private String cashbackEligibleOnlyWhen;
	private BigDecimal percentage;
	private BigDecimal eligibleCashback;
	private BigDecimal cashbackUpto;
	private BigDecimal cashbackUptoDescription;
	private BigDecimal cashbackAdjusted;
	private String cashbackType;	
	private Long cashbackCategoryId;
}
