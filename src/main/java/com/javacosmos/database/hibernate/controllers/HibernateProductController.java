package com.javacosmos.database.hibernate.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacosmos.database.hibernate.dtos.ProductDTO;
import com.javacosmos.database.hibernate.model.Product;
import com.javacosmos.database.hibernate.services.HibernateProductService;

@RestController
@RequestMapping("/hibernate/product")
public class HibernateProductController {
  private HibernateProductService service;

  public HibernateProductController(HibernateProductService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Product>> get() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(String id) {
    return ResponseEntity.ok(service.getById(id).get());
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
    return ResponseEntity.ok(service.create(productDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable String id, @RequestBody ProductDTO productDTO) {
    return ResponseEntity.ok(service.update(id, productDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);

    return ResponseEntity.ok().build();
  }
}
