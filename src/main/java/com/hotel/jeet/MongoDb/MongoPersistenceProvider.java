package com.hotel.jeet.MongoDb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@PropertySource("classpath:mongoDb.properties")
public class MongoPersistenceProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoPersistenceProvider.class);

	static final String DB_HOST = "mongo.db.host";
	static final String DB_PORT = "mongo.db.port";

	static final String DB_USERNAME = "mongo.db.username";
	static final String DB_NAME = "mongo.db.name";
	static final String DB_CRED = "mongo.db.password";
	static final String DATABASE = "database";
	
	@Value("${mongo.db.host}")
	private String mongoDbHost;
	
	@Value("${mongo.db.port}")
	private int mongoDbPort;
	
	@Value("${mongo.db.name}")
	private String mongoDbName;
	
	@Value("${mongo.db.username}")
	private String mongoDbUsername;
	
	@Value("${mongo.db.password}")
	private String mongoDbPassword;



	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
	
		LOGGER.debug("Enter : {}", "mongoDbFactory");

		ServerAddress serverAddress = new ServerAddress(mongoDbHost,mongoDbPort);

		MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(
				mongoDbUsername, mongoDbName,mongoDbPassword.toCharArray());

		List<MongoCredential> list = new ArrayList<>();
		list.add(mongoCredential);

		MongoClient mongoClient = new MongoClient(serverAddress);

		return new SimpleMongoDbFactory(mongoClient, mongoDbName);
}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		LOGGER.debug("Enter : {}", "mongoTemplate");
		return new MongoTemplate(mongoDbFactory());
	}
}
