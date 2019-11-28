package com.spring.transaction.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.spring.transaction.model.Bank;
import com.spring.transaction.test.model.User;
import com.spring.transaction.test.model.Wallet;
import com.spring.transaction.test.service.WalletService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringBootDemoTestApplication {

	@Autowired private static WalletService walletService;
	
	public static void main(String[] args) {

		// For XML
//		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		insertCodeDocumentsFromJSON(mongoOperation);
//		crudOperationsOfUser(mongoOperation);
		
//		insertBankDocumentsFromJSON(mongoOperation);
		
//		insertWalletDocumentsFromJSON();
		
		((AnnotationConfigApplicationContext) ctx).close();//simple casting
	}
	
	private static void insertCodeDocumentsFromJSON(MongoOperations mongoOperation) {
		String resourceLocation = "classpath:json/";
		try {
			File file = ResourceUtils.getFile(resourceLocation);
			String insertFilesFolder = "put";//Insert Documents Folder
			Files.walk(Paths.get(file.toURI()))
			.filter(Files::isDirectory)
			.filter(f-> {
				String jsonSubFolder = f.toFile().getPath();
				//lastIndexOf("\\") gets \json. lastIndexOf("\\")+1 gets json.
				if(insertFilesFolder.equals(jsonSubFolder.substring(jsonSubFolder.lastIndexOf("\\")+1))) {
					return true;
				}
				return false;
			})
//			.filter(f->{
			//filter code files
//				return f.toFile().listFiles((filterCodeDocuments)->{return filterCodeDocuments.toString().contains("code");}) != null;
//			})
			.forEach(f -> {
				for(File jsonFile : f.toFile().listFiles()) {
					String fileName = jsonFile.getName();
					//insert JSON data into Documents
					if(fileName.contains("code")) {
						String collectionName = fileName.substring(fileName.indexOf("-") + 1, fileName.lastIndexOf(".")).toUpperCase();
						System.out.println("Reading JSON file: "+ jsonFile +", Insert data into: "+ collectionName);
						
//						BasicDBObject basicDBObject = BasicDBObject.parse(new ObjectMapper().readValues(new JsonFactory().createJsonParser(jsonFile), valueType));
//						String json = basicDBObject.toJson();
//						System.out.println(json);
						
//						Mongo mongo = new Mongo("localhost", 27017);
//						DB db = mongo.getDB("trans");
//						DBCollection collection = db.getCollection(collectionName);
						
								/*
								 * //Example 1 
								 * Runtime r = Runtime.getRuntime();
								 * File dir=new
								 * File("D:/uday/backup/mongodb-win32-x86_64-enterprise-windows-64-4.0.1/bin/");
								 * //dir is the path to where your mongoimport is. try { Process p =
								 * r.exec("C:/windows/system32/cmd.exe /c mongoimport --db mydb --collection "+
								 * collectionName +" --type json --file "+ fileName +" --headerline" ,null,
								 * dir); } catch (IOException e) { e.printStackTrace(); }
								 */
						
//						mongoOperation.execute(collectionName, action)
						
						//Example 2
//						try {
//							JsonParser jsonParser = new JsonFactory().createParser(jsonFile);
//							Class valueType = Bank.class;
//							Iterator<?> iterator = new ObjectMapper().readValues(jsonParser, valueType);
//							while(iterator.hasNext()) {
//								Object next = iterator.next();
////								mongoOperation.save(next);
//							}
//						} catch (JsonParseException e) {
//							e.printStackTrace();
//					    } catch (JsonMappingException e) {
//					    	e.printStackTrace();
//					    } catch (IOException e) {
//					    	e.printStackTrace();
//					    }
					}
				}
			});
			
//			List<Bank> list = new ObjectMapper().readValue(file, new TypeReference<List<Bank>>() {});
//			list.forEach(bank->{
//				if (bank.getBankId()==null) {
//					Bank findOne = mongoOperation.findOne(new Query(Criteria.where("BANK_NAME").is(bank.getBankName())), Bank.class);
//					if (findOne == null || findOne.getBankId() == null) {
//						mongoOperation.insert(bank);
//						log.warn("insertBankDocumentsFromJSON: {} is inserted", bank);
//					} else {
//						log.warn("BankName: {} is trying to insert again", bank.getBankName());
//					}
//				} else {
//					log.warn("BankName: {} is trying to update", bank.getBankName());
//				}
//			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insertWalletDocumentsFromJSON() {
		try {
			List<Wallet> wallets = new ObjectMapper().readValue(ResourceUtils.getFile("classpath:json/put/put-wallet_code.json"), new TypeReference<List<Wallet>>() {});
			walletService.saveAll(wallets);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertBankDocumentsFromJSON(MongoOperations mongoOperation) {
		String resourceLocation = "classpath:json/put/put-bank_code.json";
		try {
			File file = ResourceUtils.getFile(resourceLocation);
			List<Bank> list = new ObjectMapper().readValue(file, new TypeReference<List<Bank>>() {});
			list.forEach(bank->{
				if (bank.getBankId()==null) {
					Bank findOne = mongoOperation.findOne(new Query(Criteria.where("BANK_NAME").is(bank.getBankName())), Bank.class);
					if (findOne == null || findOne.getBankId() == null) {
						mongoOperation.insert(bank);
						log.warn("insertBankDocumentsFromJSON: {} is inserted", bank);
					} else {
						log.warn("BankName: {} is trying to insert again", bank.getBankName());
					}
				} else {
					log.warn("BankName: {} is trying to update", bank.getBankName());
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void crudOperationsOfUser(MongoOperations mongoOperation) {
		User user = new User("test", "password123");

		// save
		mongoOperation.save(user);

		// now user object got the created id.
		System.out.println("1. user : " + user);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"), User.class);

		// find the updated user object
		User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
		mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());
	}

}