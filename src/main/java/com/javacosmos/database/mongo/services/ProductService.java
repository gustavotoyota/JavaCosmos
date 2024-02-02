package com.javacosmos.database.mongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.domain.category.Category;
import com.javacosmos.database.mongo.domain.category.exceptions.CategoryNotFoundException;
import com.javacosmos.database.mongo.domain.product.Product;
import com.javacosmos.database.mongo.domain.product.ProductDTO;
import com.javacosmos.database.mongo.domain.product.exceptions.ProductNotFoundException;
import com.javacosmos.database.mongo.repositories.ProductRepository;

import lombok.NonNull;

@Service
public class ProductService {
  private ProductRepository repository;
  private CategoryService categoryService;

  public ProductService(ProductRepository repository, CategoryService categoryService) {
    this.repository = repository;
    this.categoryService = categoryService;
  }

  public Product insert(ProductDTO productDTO) {
    Category category = categoryService.getById(productDTO.categoryId())
        .orElseThrow(CategoryNotFoundException::new);

    Product newProduct = new Product(productDTO);

    newProduct.setCategory(category);

    return repository.save(newProduct);
  }

  public List<Product> getAll() {
    return repository.findAll();
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

    if (productDTO.categoryId() != null) {
      this.categoryService.getById(productDTO.categoryId())
          .ifPresent(product::setCategory);
    }

    repository.save(product);

    return product;
  }

  public void delete(@NonNull String id) {
    repository.deleteById(id);
  }
}
