package com.javacosmos.database.hibernate.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacosmos.database.hibernate.dtos.CategoryDTO;
import com.javacosmos.database.hibernate.model.Category;
import com.javacosmos.database.hibernate.services.HibernateCategoryService;

@RestController
@RequestMapping("/hibernate/category")
public class HibernateCategoryController {
  private HibernateCategoryService service;

  public HibernateCategoryController(HibernateCategoryService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Category>> get() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(String id) {
    return ResponseEntity.ok(service.getById(id).get());
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
    return ResponseEntity.ok(service.create(categoryDTO));
  }
}
