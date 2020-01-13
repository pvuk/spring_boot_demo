package com.spring.transaction.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="REFERENCE_DATA")
public class ReferenceData {
	
	@Id
	@Field(value = "REFERENCE_DATA_ID")
	private ObjectId referenceDataId;
	
	@Field(value = "CLASS_NAME")
	private String className;
	
	@Field(value = "PACKAGE_NAME")
	private String packageName;
	
	@Field(value = "SOURCE_REFERENCE")
	private String sourceReference;
}
