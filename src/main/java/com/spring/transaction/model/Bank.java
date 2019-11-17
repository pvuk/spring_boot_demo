package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_CODE")
public class Bank {

	@Id
	@Field(value = "BANK_ID", order = 1)
	private String bankId;

	@Field(value = "BANK_NAME", order = 2)
	@Indexed(unique = true)
	@NotBlank(message = "Bank Name is required field.")
	private String bankName;
	
	@Field(value = "ESTABLISHED_ON", order = 3)
	private Date establishedOn;
	
	@Field(value = "ESTABLISHED_YEAR", order = 4)
	private Long establishedYear;
	
	@Field(value = "HEAD_QUARTER", order = 5)
	private String headQuarter;
	
	@Field(value = "BRANCHES", order = 6)
	private Long branches;
	
	@Field(value = "REVENUES", order = 7)
	private BigDecimal revenues;
	
	@Transient
	private String strRevenues;
	
	@Field(value = "TOTAL_ASSETS", order = 9)
	private BigDecimal totalAssets;
	
	@Transient
	private String strTotalAssets;
	
	@Field(value = "NOTES", order = 11)
	private String notes;
	
	@Field(value = "REF_LINK", order = 12)
	private String refLink;
	
	/**
	 * 1. If not found user can add. Need to approve by Admin
	 */
	@Field(value = "IS_NEW", order = 13) 		private Boolean isNew;
	@Field(value = "APPROVED", order = 14) 		private Boolean approved;
	@Field(value = "APPROVED_BY", order = 15) 	private Boolean approvedBy;
	@Field(value = "REJECTED", order = 16) 		private Boolean rejected;
	@Field(value = "REJECTED_BY", order = 17) 	private Boolean rejectedBy;
	
	@DBRef
	@Field(value="BANK_TYPE", order = 18)
	private BankType bankType;

	@Field(value="CUSTOMER_ID", order = 19)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
	
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
	
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", establishedOn=" + establishedOn
				+ ", establishedYear=" + establishedYear + ", headQuarter=" + headQuarter + ", branches=" + branches
				+ ", revenues=" + revenues + ", strRevenues=" + strRevenues + ", totalAssets=" + totalAssets
				+ ", strTotalAssets=" + strTotalAssets + ", notes=" + notes + ", refLink=" + refLink + ", bankType="
				+ bankType + ", errorMessageMap=" + errorMessageMap + "]";
	}
	
}
