package com.spring.transaction.configuration;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

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
	
	public MongoCollection<Document> getCollection(String collectionName){
		MongoCollection<org.bson.Document> dbCollection = mongoClient().getDatabase(getDatabaseName()).getCollection(collectionName);
		return dbCollection;
	}
	
	//https://stackoverflow.com/questions/21386449/spring-data-and-mongodb-simple-roll-back-with-spring-within-transactional
//	public MongoTemplate fetchMongoTemplate(int projectId) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
//        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
//        // Don't save _class to mongo
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        MongoDbFactory customizedDBFactory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
//        MongoTemplate mongoTemplate = new MongoTemplate(customizedDBFactory,mappingMongoConverter);
//        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(customizedDBFactory);
//        return mongoTemplate;
//    }
}