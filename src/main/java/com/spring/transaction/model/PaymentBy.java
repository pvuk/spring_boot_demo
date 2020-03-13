package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.validation.group.GroupCustomer;

import lombok.Data;

/**
 * <p>
 * 	<ol>
 * 		<li>This Collection contains all the transactions details.</li>
 * 		<li>ASSIGN_PAYMENT_BY if any CC / other payment done, user want to pay particular transaction using dc / netbanking / upi in feature.</li>
 * 		<li>If payment is single / multiple settlements use PAYMENT(payments field) to track from source and to source of payment modes </li>
 * 	</ol>
 * </p>
 * @author P V UdayKiran
 *
 * @Date Tue 03-Dec-2019 19:21
 */
@Data
@Document(collection = "PAYMENT_BY")
public class PaymentBy {

	@Id
	@Field(value = "PAYMENT_BY_ID", order = 1)
	private String paymentById;

	@Field(value = "PAYMENT_ID")
	private String paymentId;
	
	/**
	 * 1. If payment received from more than one customer., we need to insert two
	 * records for single transaction.
	 */
	@NotNull(message = "Payment Received From Customer is required field.", groups = GroupCustomer.class)
	@Field(value = "PAYMENT_RECEIVED_ID", order = 2)
	private List<String> paymentReceivedIds;

	@Field(value = "CREDIT_CARD_PAYMENT_ID", order = 3)
	private String creditCardPaymentId;

	@Field(value = "DEBIT_CARD_PAYMENT_ID", order = 4)
	private String debitCardPaymentId;

	@Field(value = "NETBANKING_PAYMENT_ID", order = 5)
	private String netBankingPaymentId;

	@Field(value = "PAYMENT_ON_REWARD_POINTSID", order = 6)
	private String paymentOnRewardPointsId;

	@Field(value = "MOVIE_OFFER_ID", order = 7)
	private String movieOfferId;

	@Field(value = "CASH_PAYMENT_ID", order = 8)
	private String cashPaymentId;

	@Field(value = "WALLET_PAYMENT_ID", order = 9)
	private String walletPaymentId;

	@Field(value = "EMI_PAYMENT_ID", order = 10)
	private String emiPaymentId;

	@Field(value = "CHEQUE_PAYMENT_ID", order = 11)
	private String chequePaymentId;

	@Type(type="yes_no")
	@Field(value = "PAYMENT_SHOW_TO_EXPENSER", order = 12)
	private boolean paymentShowToExpenser;

	@Field(value = "COMMENT", order = 13)
	private String comment;
	
	@Transient
	private List<Payment> payments;
	
	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS(CC_SBI_SIMCLK_250220201915285920000)
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Select this option if user wants to pay for current transaction amount using DC or Savings Account in future. 
	 * 2. If user tries to pay using other payment modes restrict the user and pay using previous what selected.
	 */
	@Field(value = "ASSIGN_PAYMENT_BY_ID")
	private String assignPaymentById;
	
	/**
	 * 1. PARENT_PAYMENT_ID is mandatory when user payment is less than actual payment.</br>
	 * 2. If user paid 10000 as single payment PAYMENT_BY_ID = 1, PARENT_PAYMENT_ID = null 
	 * </br>
	 * 3. If user payment is 10000, if the payment is less than 10000 i.e 9999.99,
	 * insert PAYMENT record as child if amount received payment is less than actual payment.
	 * </br>
	 * 4. If user paid 10000 in more than two payments,
	 *  PAYMENT_BY_ID = 1 AND PARENT_PAYMENT_ID = null, 
	 * 	PAYMENT_BY_ID = 2 AND PARENT_PAYMENT_ID = 1,
	 *  PAYMENT_BY_ID = 3 AND PARENT_PAYMENT_ID = 1
	 * </br>
	 */
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;

	@Field("RATE_YOUR_PURCHASE_ID")
	private String rateYourPurchaseId;

	@Field(value = "OFFER_EXPENDITURE_ID")
	private String offerExpenditureId;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
	
}
