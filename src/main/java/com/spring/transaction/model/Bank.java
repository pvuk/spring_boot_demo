package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	@NotNull(message = "Bank Name Can't be empty.")
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
	
	private BigDecimal revenues;
	
	@Field(value = "REVENUES", order = 7)
	private String strRevenues;
	
	private BigDecimal totalAssets;
	
	@Field(value = "TOTAL_ASSETS", order = 8)
	private String strTotalAssets;
	
	@Field(value = "NOTES", order = 9)
	private String notes;
	
	@Field(value = "REF_LINK", order = 10)
	private String refLink;
	
	@DBRef
	@Field(value="BANK_TYPE")
	private BankType bankType;

	@Field(value = "ERROR_MESSAGE_MAP", order = 11)
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
