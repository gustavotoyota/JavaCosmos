package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.domain.user.User;

public interface UserRepository extends MongoRepository<User, String> {
}
