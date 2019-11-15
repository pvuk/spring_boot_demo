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
	@NotNull(message="EMI Start On is required field.")
	private Date emiStartOn;
	
	@Field(value="EMI_ENDS_ON", order = 4)
	@NotNull(message="EMI Ends On is required field.")
	private Date emiEndsOn;
	
	@Field(value="EMI_DUE_DATE", order = 5)
	@NotNull(message="EMI Due Date is required field.")
	private Date emiDueDate;
	
	@Field(value="LOAN_AMOUNT", order = 6)
	@NotNull(message="Loan Amount required field.")
	private BigDecimal loanAmount;
	
	@Field(value="TOTAL_EMI_PAYMENT_WITH_INTEREST", order = 7)
	private BigDecimal totalEMIPaymentWithInterest;
	
	@Field(value="UNBILLED_PRINCIPAL", order = 8)
	private BigDecimal unbilledPrincipal;
	
	@Field(value="CURRENT_EMI_DUE", order = 9)
	private BigDecimal currentEMIDue;
	
	@Field(value="Goods_&_Services_Tax", order = 10)
	private BigDecimal goodsAndServicesTax;
	
	@Field(value="PROCESSING_FEE", order = 11)
	private BigDecimal processingFee;
	
	@Field(value="TOTAL_PAYMENT_DUE", order = 12)
	private BigDecimal totalPaymentDue;
	
	@Field(value="MINIMUM_AMOUNT_DUE", order = 13)
	private BigDecimal minimumAmountDue;
	
	@Field(value="EMI_PAID", order = 14)
	private BigDecimal emiPaid;
	
	@Field(value="REMAINING_PAYMENT", order = 15)
	private BigDecimal remainingPayment;
	
	@Field(value="EMI_PAID_ON", order = 16)
	private Date emiPaidOn;
	
	@Field(value="EMI_CHARGABLE_AMOUNT", order = 17)
	private BigDecimal emiChargableAmount;
	
	@Field(value="EMI_MONTHS", order = 18)
	private String emiMonths;
	
	@Field(value = "REMAINING_EMI_MONTHS", order = 19)
	private String remainingEMIMonths;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS", order = 20)
	private String transactionDetails;
	
	@Field(value="OVERAL_EMI_PAID", order = 21)
	private BigDecimal overalEMIPaid;
	
	@Field(value="OVERAL_EMI_PAYMENT_AMOUNT", order = 22)
	private BigDecimal overalEMIPaymentAmount;

	@Field(value = "REFERENCE_NO", order = 23)
	private String referenceNo;
	
	@Field(value="CUSTOMER_ID", order = 24)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT", order = 25)
	private Boolean confirmPayment;
	
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
