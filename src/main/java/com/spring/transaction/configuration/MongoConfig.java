package com.spring.transaction.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

/**
 * https://stackoverflow.com/questions/21386449/spring-data-and-mongodb-simple-roll-back-with-spring-within-transactional
 * https://spring.io/blog/2018/06/28/hands-on-mongodb-4-0-transactions-with-spring-data
 * https://docs.spring.io/spring-data/mongodb/docs/2.1.0.M3/api/org/springframework/data/mongodb/MongoTransactionManager.html
 * https://mongodb.github.io/mongo-java-driver-reactivestreams/
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.host}")
    private String dbHost;

    @Value("${spring.data.mongodb.port}")
    private int dbPort;
    
//	@Bean
//	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
//		return new MongoTransactionManager(dbFactory);
//	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(dbHost, dbPort);
	}

	@Override
	public String getDatabaseName() {
		return dbName;
	}
}