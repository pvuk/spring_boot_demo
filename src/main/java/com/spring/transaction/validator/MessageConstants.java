package com.spring.transaction.validator;

public interface MessageConstants {

	public static final String SUCCESS_SAVE 	= "Record Saved Successfully.";
	public static final String SUCCESS_UPDATE 	= "Record Updated Successfully.";
	public static final String SUCCESS_DELETE 	= "Record Deleted Successfully.";
	public static final String ERROR_MESSAGE 	= "Something went wrong. Please Contact Trans IT Support.";
	public static final String PLEASE_CONTACT_TRANS_IT_SUPPORT = "Please Contact Trans IT Support.";
	public static final String WORKING_IN_PROGRESS = "Working in progress. ";
	public static final String ID_NOT_FOUND = "Id not found / Invalid Id. ";
	
	public interface STATUS {
		public static final String SUCCESS = "Success";
		public static final String ERROR = "Error";
		public static final String WARNING = "Warning";
	}
}
