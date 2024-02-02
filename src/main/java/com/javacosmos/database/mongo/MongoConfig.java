package com.javacosmos.database.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
  @Bean
  public MongoDatabaseFactory mongoDbFactory() {
    return new SimpleMongoClientDatabaseFactory(
        "mongodb://mongo_user:mongo_password@localhost:27017/javacosmos?authSource=admin");
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    return new MongoTemplate(mongoDbFactory());
  }
}
