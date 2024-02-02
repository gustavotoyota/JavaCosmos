package com.javacosmos.database.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javacosmos.database.mongo.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
