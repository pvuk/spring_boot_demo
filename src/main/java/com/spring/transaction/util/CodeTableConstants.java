package com.spring.transaction.util;

public final class CodeTableConstants {
	
	public interface Entity {
		public static final String BANK_TYPE 											= "BANK_TYPE_CODE";
	}

	public interface Column {
		public static final String BANK_TYPE_ID 										= "BANK_TYPE_ID";
		public static final String CODE 												= "CODE";
	}
	
	public interface Bank {
		public static final String CODE_PUBLIC 											= "public";
		public static final String CODE_PRIVATE 										= "private";
		public static final String BANK_ID_VALUE										= "5cece8c83d495818d0bd9f80";
	}
	
	public interface Bean {
		public static final String PUBLIC_BANK_BANKTYPE 								= "publicBank";
		public static final String PRIVATE_BANK_BANKTYPE 								= "privateBank";
		public static final String BANK_SERVICE 										= "bankService";
	}
}
