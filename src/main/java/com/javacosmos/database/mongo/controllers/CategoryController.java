package com.javacosmos.database.mongo.controllers;

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

import com.javacosmos.database.mongo.domain.category.Category;
import com.javacosmos.database.mongo.domain.category.CategoryDTO;
import com.javacosmos.database.mongo.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
  private CategoryService service;

  public CategoryController(CategoryService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryDTO) {
    Category category = service.insert(categoryDTO);

    return ResponseEntity.ok(category);
  }

  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = service.getAll();

    return ResponseEntity.ok(categories);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO categoryDTO) {
    Category category = service.update(id, categoryDTO);

    return ResponseEntity.ok(category);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
