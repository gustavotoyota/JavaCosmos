package com.javacosmos.database.mongo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacosmos.database.mongo.domain.product.Product;
import com.javacosmos.database.mongo.domain.product.ProductDTO;
import com.javacosmos.database.mongo.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO) {
    Product product = service.insert(productDTO);

    return ResponseEntity.ok(product);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {
    List<Product> categories = service.getAll();

    return ResponseEntity.ok(categories);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productDTO) {
    Product product = service.update(id, productDTO);

    return ResponseEntity.ok(product);
  }
}
