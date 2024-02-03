package com.javacosmos.database.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.dtos.ProductDTO;
import com.javacosmos.database.mongo.exceptions.ProductNotFoundException;
import com.javacosmos.database.mongo.model.Product;
import com.javacosmos.database.mongo.repositories.MongoProductRepository;

import lombok.NonNull;

@Service
public class MongoProductService {
  private MongoProductRepository repository;

  public MongoProductService(MongoProductRepository repository) {
    this.repository = repository;
  }

  public Product create(ProductDTO productDTO) {
    Product newProduct = new Product(productDTO);

    return repository.save(newProduct);
  }

  public List<Product> getAll() {
    return repository.findAll();
  }

  public Optional<Product> getById(@NonNull String id) {
    return repository.findById(id);
  }

  public Product update(@NonNull String id, ProductDTO productDTO) {
    Product product = repository.findById(id)
        .orElseThrow(ProductNotFoundException::new);

    if (product == null) {
      throw new ProductNotFoundException();
    }

    if (productDTO.title() != null && !productDTO.title().isEmpty()) {
      product.setTitle(productDTO.title());
    }

    if (productDTO.description() != null && !productDTO.description().isEmpty()) {
      product.setDescription(productDTO.description());
    }

    if (productDTO.price() != null) {
      product.setPrice(productDTO.price());
    }

    if (productDTO.categoryId() != null && !productDTO.categoryId().isEmpty()) {
      product.setCategoryId(productDTO.categoryId());
    }

    repository.save(product);

    return product;
  }

  public void delete(@NonNull String id) {
    repository.deleteById(id);
  }
}
