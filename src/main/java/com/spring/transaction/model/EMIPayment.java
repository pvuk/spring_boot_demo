package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author udaykiran pulipati
 *
 */
@Data
@Document(collection="EMI_PAYMENT", value="EQUATED_MONTHLY_INSTALLMENT")
public class EMIPayment {
	
	@Field(value="EMI_PAYMENT_ID", order = 1)
	@Id private String emiPaymentId;
	
	@Field(value="PAYMENT_BY_ID", order = 2)
	@NotNull(message="Payment By is required field.")
	private String paymentById;
	
	@Field(value="EMI_START_ON", order = 3)
	@NotNull(message="Credit Card is required field.")
	private String emiStartOn;
	
	@Field(value="EMI_ENDS_ON", order = 4)
	@NotNull(message="Amount is required field.")
	private BigDecimal emiEndsOn;
	
	@Field(value="EMI_PAYMENT_AMOUNT", order = 5)
	private Date emiPaymentAmount;
	
	@Field(value="EMI_PAID", order = 6)
	private BigDecimal emiPaid;
	
	@Field(value="OVERAL_EMI_PAID", order = 7)
	private BigDecimal overalEMIPaid;
	
	@Field(value="CURRENT_EMI_AMOUNT", order = 8)
	private BigDecimal currentEMIAmount;
	
	@Field(value="REMAINING_EMI_AMOUNT", order = 9)
	private BigDecimal remainingEMIAmount;
	
	@Field(value="REMAINING_EMI_PAYMENT", order = 10)
	private BigDecimal remainingEMIPayment;
	
	@Field(value="ACTUAL_EMI_AMOUNT", order = 11)
	private BigDecimal actualEMIAmount;
	
	@Field(value="EMI_CHARGABLE_AMOUNT", order = 12)
	private BigDecimal emiChargableAmount;
	
	@Field(value="EMI_MONTHS", order = 13)
	private String emiMonths;
	
	@Field(value="COMMENT", order = 14)
	private String comment;
	
	@Field(value="OVERAL_EMI_PAYMENT_AMOUNT", order = 15)
	private BigDecimal overalEMIPaymentAmount;
	
	@Field(value="DIFFERENCE_IN_EMI_AMOUNT", order = 16)
	private BigDecimal differenceInEMIAmount;
	
	@Field(value="CUSTOMER_ID", order = 17)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT", order = 18)
	private Boolean confirmPayment;
}
