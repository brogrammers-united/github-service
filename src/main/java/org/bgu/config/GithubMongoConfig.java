package org.bgu.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class GithubMongoConfig extends AbstractMongoConfiguration {

	private final Properties props = getGhProperties();
	
	@Bean("ghMongoClient")
	@Override
	public MongoClient mongoClient() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		builder.alwaysUseMBeans(true);
		builder.sslEnabled(false);
		builder.connectionsPerHost(50);
		builder.connectTimeout(1000);
		builder.minConnectionsPerHost(15);
		return new MongoClient(new ServerAddress("127.0.0.1", 27017), MongoCredential.createCredential(props.getProperty("mongo.username"), props.getProperty("mongo.database"), props.getProperty("mongo.password").toCharArray()),
				builder.build());
	}

	@Override
	protected String getDatabaseName() {
		return props.getProperty("mongo.database");
	}
	
	@Bean("ghMongoDbFactory")
	@Override
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
	}
	
	@Bean("ghMongoTemplate")
	@Override
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

	private final Properties getGhProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("gh-mongodb.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load class path resource gh-mongodb.properties");
		}
		return props;
	}
}
