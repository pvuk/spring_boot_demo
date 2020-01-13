package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * <p>
 * 	<ol>
 * 		<li>NEW_OPTION is accessible in document OTHER_OPTION. Both documents OTHER_OPTION and NEW_OPTION_REQUEST_DETAILS are dependent.</li>
 * 		<li><b>***** Please look into JSON(put-new_option_request.json(document NEW_OPTION_REQUEST)) file which documents supports this feature.</b></li>
 * 	</ol>
 * </p>
 * 
 * <ul><b>Following are conditions regarding OPTION_NAME would be processed by TechnicalTeam.</b>
 * 	<li>when new option is requested by user give temporary OPTION_NAME access to user.</li>
 * 	<li>Send notification to user when CONFIRM_BY(Mail notification only! not who confirmed), need approval from APPROVED_BY / REJECTED_BY for further proceeding.</li>
 * 	<li><b>**** Once APPROVED_OPTION_NAME is APPROVED_BY, then insert this requested APPROVED_OPTION_NAME in foreign_key documents.</b></li>
 * 	<li>Send notification to user when NEW_OPTION is changed to 'Y' when APPROVED_BY(Mail notification only! not who confirmed), OPTION_NAME is updated to APPROVED_OPTION_NAME as per T&C.</li>
 * 	<li>Once APPROVED_BY 'Y' then NEW_OPTION in foreign_key documents should be inserted with <b>APPROVED_OPTION_NAME</b></li>	
 * 	<li>Display DESCRIPTION (insert field as per document it is description / as per document fieldName) in control from documents(NEW_OPTION is 'Y') once APPROVED_BY, don't display OPTION_NAME in control !.</li>
 * 	<li>Only one case APPROVED_BY / REJECTED_BY should be APPROVED / REJECTED('Y'/'N').</li>
 * 	<li>Send notification to all USERS, down time(Timings) in project and release updates as brief points(new options added in controls, etc.,).</li>
 * 	<li>when user request new option TEMPORARY_OPTION is 'Y' in following cases CONFIRM 'Y' / APPROVED 'Y' / REJECTED 'Y'. until NEW_OPTION is 'Y'</li>
 * 	<li>Once NEW_OPTION is 'Y' then TEMPORARY_OPTION 'N'(update should be done in both cases(APPROVED_OPTION_NAME), but one record should be inserted in document(NEW_OPTION). <b>see Point 1. 1)</b></li>
 * 	<li><ol>
 * 			<li>1. If the same OPTION_NAME is requested by some other users in feature if it is APPROVED_BY then send <b>notifications</b> to REQUESTED_BY</li>
 * 			<li>If OPTION_NAME is REJECTED then TEMPORARY_OPTION should be accessible only to REQUESTED_BY</li>	
 * 		</ol>
 * 	</li>
 * </ul>
 * 
 * @author venkataudaykiranp
 * @since Fri 29-Nov-2019 17:46
 */
@Data
@Document(collection = "NEW_OPTION_REQUEST_DETAILS")
public class NewOptionRequestDetails {
	
	@Id															
	@Field(value = "NEW_OPTION_REQUEST_DETAILS_ID")				private String newOptionRequestDetailsId;

	@NotNull(message = "Option Name is required field.")
	@Field(value = "OPTION_NAME")								private String optionName;
	
	@Field(value = "APPROVED_OPTION_NAME")						private String approvedOptionName;
	
	@Field(value = "SCREEN_NAME")								private String screenName;
	@Field(value = "CONTROL_NAME")								private String controlName;
	
	@NotNull(message = "Collection Name is required field.")
	@Field(value = "COLLECTION_NAME")							private String collectionName;
	
	@NotNull(message = "Entity Name is required field.")
	@Field(value = "ENTITY_NAME")								private String entityName;
	
	/**
	 * 1. If OPTION_NAME is REJECTED then TEMPORARY_OPTION should be accessible only to REQUESTED_BY
	 */
	@Type(type = "yes_no")
	@Field(value = "TEMPORARY_OPTION")							private Boolean temporaryOption;
	
	/**
	 * 1. value should be saved 'Y' / 'N'. Database DataType CHAR(1).
	 */
	@Type(type = "yes_no")
	@Field(value = "CONFIRM") 									private Boolean confirm;
	
	@Field(value = "CONFIRM_ON")								private Date confirmOn;
	@Field(value = "CONFIRM_BY") 								private String confirmBy;
	
	@Type(type = "yes_no")
	@Field(value = "APPROVED") 									private Boolean approved;
	
	@Field(value = "APPROVED_BY") 								private String approvedBy;
	@Field(value = "APPROVED_ON")								private Date approvedOn;
	
	@Type(type = "yes_no")
	@Field(value = "REJECTED") 									private Boolean rejected;
	
	@Field(value = "REJECTED_BY") 								private String rejectedBy;
	@Field(value = "REJECTED_ON")								private Date rejectedOn;
	@Field(value = "REJECTED_COMMENT")							private String rejectedComment;
	
	/**
	 * 1. Use CUSTOMER_ID to insert.
	 */
	@NotNull(message="Requested By is required field.")
	@Field(value="REQUESTED_BY")								private String requestedBy;
}
