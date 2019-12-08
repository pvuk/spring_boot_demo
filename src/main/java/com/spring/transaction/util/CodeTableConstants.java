package com.spring.transaction.util;

public final class CodeTableConstants {
	
	public interface Entity {
		public static final String BANK_ACCOUNT_STATUS_CODE 					= "BANK_ACCOUNT_STATUS_CODE";
		public static final String BANK_ACCOUNT_TYPE_CODE 						= "BANK_ACCOUNT_TYPE_CODE";
		public static final String BANK_BRANCH_CODE 							= "BANK_BRANCH_CODE";
		public static final String BANK_BRANCH_STATUS_CODE 						= "BANK_BRANCH_STATUS_CODE";
		public static final String BANK_CODE 									= "BANK_CODE";
		public static final String BANK_STATUS_CODE 							= "BANK_STATUS_CODE";
		public static final String BANK_TYPE_CODE 								= "BANK_TYPE_CODE";
		public static final String CARD_CATEGORY_CODE 							= "CARD_CATEGORY_CODE";
		public static final String CARD_STATUS_CODE 							= "CARD_STATUS_CODE";
		public static final String CARD_TYPE_AUTHORIZATION_CODE 				= "CARD_TYPE_AUTHORIZATION_CODE";
		public static final String CARD_TYPE_CODE 								= "CARD_TYPE_CODE";
		public static final String CREDIT_CARD_CODE 							= "CREDIT_CARD_CODE";
		public static final String DEBIT_CARD_CODE 								= "DEBIT_CARD_CODE";
		public static final String EMPLOYMENT_TYPE_CODE 						= "EMPLOYMENT_TYPE_CODE";
		public static final String GIFT_CARD_STATUS_CODE 						= "GIFT_CARD_STATUS_CODE";
		public static final String GIFT_CARD_TYPE_CODE 							= "GIFT_CARD_TYPE_CODE";
		public static final String LEGEND_CODE 									= "LEGEND_CODE";
		public static final String NET_BANKING_CODE 							= "NET_BANKING_CODE";
		public static final String OFFER_STATUS_CODE 							= "OFFER_STATUS_CODE";
		public static final String OFFER_TYPE_CODE 								= "OFFER_TYPE_CODE";
		public static final String PAYMENT_FROM_CODE 							= "PAYMENT_FROM_CODE";
		public static final String PAYMENT_INSTALLMENT_CODE 					= "PAYMENT_INSTALLMENT_CODE";
		public static final String PAYMENT_STATUS_CODE 							= "PAYMENT_STATUS_CODE";
		public static final String PAYMENT_TO_CODE 								= "PAYMENT_TO_CODE";
		public static final String PAYMENT_TYPE_CODE 							= "PAYMENT_TYPE_CODE";
		public static final String PROFESSION_CODE 								= "PROFESSION_CODE";
		public static final String REMAINDER_STATUS_CODE 						= "REMAINDER_STATUS_CODE";
		public static final String SPEND_STATUS_CODE 							= "SPEND_STATUS_CODE";
		public static final String SPEND_TYPE_CODE 								= "SPEND_TYPE_CODE";
		public static final String TRANSACTION_STATUS_CODE 						= "TRANSACTION_STATUS_CODE";
		public static final String TRANS_DOCUMENTS_CODE 						= "TRANS_DOCUMENTS_CODE";
		public static final String UPI_APP_CODE 								= "UPI_APP_CODE";
		public static final String USER_STATUS_CODE 							= "USER_STATUS_CODE";
		public static final String UTILITY_PAYMENT_CODE 						= "UTILITY_PAYMENT_CODE";
		public static final String WALLET_CODE 									= "WALLET_CODE";
		public static final String WALLET_STATUS_CODE 							= "WALLET_STATUS_CODE";
		public static final String YEARS_OF_EXPERIENCE_CODE 					= "YEARS_OF_EXPERIENCE_CODE";
	}

	public interface Column {
		public static final String BANK_TYPE_ID 								= "BANK_TYPE_ID";
		public static final String CODE 										= "CODE";
	}
	
	public interface Bank {
		public static final String CODE_PUBLIC 									= "public";
		public static final String CODE_PRIVATE 								= "private";
		public static final String BANK_ID_VALUE								= "5cece8c83d495818d0bd9f80";
	}
	
	public interface Bean {
		public static final String PUBLIC_BANK_BANKTYPE 						= "publicBank";
		public static final String PRIVATE_BANK_BANKTYPE 						= "privateBank";
		public static final String BANK_SERVICE 								= "bankService";
	}
}
