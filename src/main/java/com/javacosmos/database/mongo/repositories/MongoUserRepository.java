package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.model.User;

public interface MongoUserRepository extends MongoRepository<User, String> {
}
