package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.model.Category;

public interface MongoCategoryRepository extends MongoRepository<Category, String> {
}
