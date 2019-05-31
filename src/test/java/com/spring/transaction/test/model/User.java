package com.spring.transaction.test.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String id;

	String username;

	String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}