package com.javacosmos.database.hibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javacosmos.database.hibernate.dtos.ProductDTO;
import com.javacosmos.database.hibernate.exceptions.ProductNotFoundException;
import com.javacosmos.database.hibernate.model.Product;
import com.javacosmos.database.hibernate.repositories.HibernateProductRepository;

import lombok.NonNull;

@Service
public class HibernateProductService {
  private HibernateProductRepository repository;

  public HibernateProductService(HibernateProductRepository repository) {
    this.repository = repository;
  }

  public Product create(ProductDTO productDTO) {
    Product product = new Product(productDTO);

    return repository.save(product);
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

    if (productDTO.ownerId() != null) {
      product.setOwnerId(productDTO.ownerId());
    }

    if (productDTO.price() != null) {
      product.setPrice(productDTO.price());
    }

    if (productDTO.categoryId() != null) {
      product.setCategoryId(productDTO.categoryId());
    }

    return repository.save(product);
  }

  public void delete(@NonNull String id) {
    repository.deleteById(id);
  }
}
