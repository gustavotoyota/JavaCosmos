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

import com.javacosmos.database.mongo.dtos.ProductDTO;
import com.javacosmos.database.mongo.model.Product;
import com.javacosmos.database.mongo.services.MongoProductService;

@RestController
@RequestMapping("/mongo/product")
public class MongoProductController {
  private MongoProductService service;

  public MongoProductController(MongoProductService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
    Product product = service.create(productDTO);

    return ResponseEntity.ok(product);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {
    List<Product> categories = service.getAll();

    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable("id") String id) {
    Product product = service.getById(id).get();

    return ResponseEntity.ok(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productDTO) {
    Product product = service.update(id, productDTO);

    return ResponseEntity.ok(product);
  }
}
