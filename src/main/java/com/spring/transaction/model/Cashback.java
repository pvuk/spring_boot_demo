package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.Data;

/**
 * Each time you use the card, you earn a percentage of your spend back in the
 * form of cashback. For example if 2% cashback eligible on payment and you
 * spend Rs 100 in a shop, you will earn 2Rs.
 * 
 * @author Priyanka
 *
 * @Date: Sun 10-Nov-2019 15:29
 */
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
	@NotNull(message = "Cashback Amount Description is required field.")
	private String description;

	@Field(value = "CASHBACK_ELIGIBLE_ONLY_WHEN", order = 7)
	private String cashbackEligibleOnlyWhen;

	@Field(value = "CASHBACK_ELIGIBLE_ONLY_WHEN_DESCRIPTION", order = 8)
	private String cashbackEligibleOnlyWhenDescription;

	@Field(value = "PERCENTAGE", order = 9)
	private Double percentage;

	@Field(value = "ELIGIBLE_CASHBACK", order = 10)
	private BigDecimal eligibleCashback;

	@Field(value = "ADDITIONAL_CASHBACK", order = 11)
	private BigDecimal additionalCashback;

	@Field(value = "CASHBACK_UPTO", order = 12)
	private BigDecimal cashbackUpto;

	@Field(value = "CASHBACK_UPTO_DESCRIPTION", order = 13)
	private BigDecimal cashbackUptoDescription;

	@Field(value = "CASHBACK_ADJUSTED", order = 14)
	private BigDecimal cashbackAdjusted;

	@Field(value = "CASHBACK_TYPE", order = 15)
	private String cashbackType;

	@Field(value = "CASHBACK_CATEGORY_ID", order = 16)
	private Long cashbackCategoryId;

	@Field(value = "CUSTOMER_ID", order = 17)
	@NotNull(message = "Customer is required field.")
	private String customerId;

	@Embedded
	private AuditData auditData;
}
