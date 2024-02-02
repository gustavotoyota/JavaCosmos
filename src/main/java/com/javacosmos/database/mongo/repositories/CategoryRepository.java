package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.domain.category.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
