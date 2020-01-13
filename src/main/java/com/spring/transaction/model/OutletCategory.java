package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author P V UdayKiran
 *
 * @Date: Sat 28-Dec-2019 19:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="OUTLET_CATEGORY_CODE")
public class OutletCategory {

	@Id
	@Field(value = "OUTLET_CATEGORY_ID", order = 1)					private String outletCategoryId;
	
	@Indexed(unique = true)
	@Field(value = "CODE", order = 2)								private String code;
	
	@Field(value = "POSITION", order = 3) 							private Long position;
	
	@NotNull(message = "Outlet Category is required field.")
	@Field(value = "DESCRIPTION", order = 4) 						private String description;
	
	@NotNull(message = "Outlet is required field.")
	@Field(value = "OUTLET_ID", order = 5)							private String outletId;
}
