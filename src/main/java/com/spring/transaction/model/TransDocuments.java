package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author P V UdayKiran
 *
 * @Date: Fri 06-Dec-2019 20:45
 */
@Data
@Document(collection = "TRANS_DOCUMENTS_CODE")
public class TransDocuments {
	
	@Id
	@Field(value = "TRANS_DOCUMENTS_ID")
	private String transDocumentsId;
	
	@Indexed(unique = true, name = "COLLECTION_NAME_INDEX", direction = IndexDirection.ASCENDING)
	@NotBlank(message = "Collection Name is required field.")
	@Field(value = "COLLECTION_NAME")
	private String collectionName;
}
