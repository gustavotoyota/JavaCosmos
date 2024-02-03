package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.model.Product;

public interface MongoProductRepository extends MongoRepository<Product, String> {
}
