package com.spring.transaction.configuration;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
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
    
//    private com.mongodb.client.MongoClient codecMongoClient;
    
//	@Bean
//	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
//		return new MongoTransactionManager(dbFactory);
//	}

	@Override
	public MongoClient mongoClient() {
		
//		MongoClientURI uri = new MongoClientURI(
//			    "mongodb+srv://admin:<kNwfZnvUI3JFwnm3>@cluster0-shared-00-00-mongodb-ruk1a.mongodb.net/test?retryWrites=true");
//
//			MongoClient mongoClient = new MongoClient(uri);
//			MongoDatabase database = mongoClient.getDatabase("test");
//		return mongoClient;
//		this.codecMongoClient = codecMongoClient != null ? this.codecMongoClient : getMongoClientCodec();
		return new MongoClient(dbHost, dbPort);
	}
	
	/**
	 * Ref: http://mongodb.github.io/mongo-java-driver/3.7/driver/getting-started/quick-start-pojo/
	 * @return mongoClient
	 */
	private com.mongodb.client.MongoClient getMongoClientCodec() {
		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(getPojoCodecRegistry()).build();
		com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient;
	}

	private CodecRegistry getPojoCodecRegistry() {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		return pojoCodecRegistry;
	}

	@Override
	public String getDatabaseName() {
		return dbName;
	}
	
	@Bean
    public MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(mongoClient(),dbName);
    }
	
	public MongoCollection<Document> getCollection(String collectionName){
		MongoCollection<org.bson.Document> dbCollection = mongoClient().getDatabase(getDatabaseName()).getCollection(collectionName);
		dbCollection.withCodecRegistry(getPojoCodecRegistry());
		return dbCollection;
	}
	
	@Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
	
//	@Bean
//    public MongoTemplate mongoTemplate() {
//		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
//        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
//        // Don't save _class to mongo
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(),mappingMongoConverter);
//        mongoTemplate.setSessionSynchronization(SessionSynchronization.ALWAYS);
//        return mongoTemplate;
//    }
//	
//	//https://stackoverflow.com/questions/21386449/spring-data-and-mongodb-simple-roll-back-with-spring-within-transactional
//	public MongoTemplate fetchMongoTemplate(int projectId) {
//		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
//        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
//        // Don't save _class to mongo
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        MongoDbFactory customizedDBFactory = new SimpleMongoDbFactory(mongoClient(), dbName+"_"+projectId);
//        MongoTemplate mongoTemplate = new MongoTemplate(customizedDBFactory,mappingMongoConverter);
//        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(customizedDBFactory);
//        return mongoTemplate;
//    }
//	
//	@Bean
//    public MongoTransactionManager mongoTransactionManager() {
//        return new MongoTransactionManager(mongoDbFactory());
//    }
}