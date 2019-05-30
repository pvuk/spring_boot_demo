package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CASHBACK")
public class Cashback {
	
	@Field(value = "CASHBACK_ID", order = 1)
	@Id 
	private String cashbackId;
	
	@Field(value = "CASHBACK_AMOUNT", order = 2)
	private BigDecimal cashbackAmount;
	
	@Field(value = "PAYMENT", order = 3)
	private BigDecimal payment;
	
	@Field(value = "PAYMENT_ON", order = 4)
	private Date paymentOn;
	
	@Field(value = "CASHBACK_ON", order = 5)
	private Date cashbackOn;
	
	@Field(value = "DESCRIPTION", order = 6)
	@NotEmpty(message = "Cashback Amount Description is required field.")
	private String description;
	
	@Field(value = "CASHBACK_ELIGIBLE_ONLY_WHEN", order = 7)
	private String cashbackEligibleOnlyWhen;
	
	@Field(value = "PERCENTAGE", order = 8)
	private Double percentage;
	
	@Field(value = "ELIGIBLE_CASHBACK", order = 9)
	private BigDecimal eligibleCashback;
	
	@Field(value = "CASHBACK_UPTO", order = 10)
	private BigDecimal cashbackUpto;
	
	@Field(value = "CASHBACK_UPTO_DESCRIPTION", order = 11)
	private BigDecimal cashbackUptoDescription;
	
	@Field(value = "CASHBACK_ADJUSTED", order = 12)
	private BigDecimal cashbackAdjusted;
	
	@Field(value = "CASHBACK_TYPE", order = 13)
	private String cashbackType;
	
	@Field(value = "CASHBACK_CATEGORY_ID", order = 14)
	private Long cashbackCategoryId;
	
	@Field(value = "CUSTOMER_ID", order = 15)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
