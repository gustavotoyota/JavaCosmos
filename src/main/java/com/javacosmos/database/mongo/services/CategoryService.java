package com.javacosmos.database.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.domain.category.Category;
import com.javacosmos.database.mongo.domain.category.CategoryDTO;
import com.javacosmos.database.mongo.domain.category.exceptions.CategoryNotFoundException;
import com.javacosmos.database.mongo.repositories.CategoryRepository;

import lombok.NonNull;

@Service
public class CategoryService {
  private CategoryRepository repository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.repository = categoryRepository;
  }

  public Category insert(CategoryDTO categoryDTO) {
    return repository.save(new Category(categoryDTO));
  }

  public List<Category> getAll() {
    return repository.findAll();
  }

  public Optional<Category> getById(@NonNull String id) {
    return repository.findById(id);
  }

  public Category update(@NonNull String id, CategoryDTO categoryDTO) {
    Category category = repository.findById(id)
        .orElseThrow(CategoryNotFoundException::new);

    if (category == null) {
      throw new CategoryNotFoundException();
    }

    if (categoryDTO.title() != null && !categoryDTO.title().isEmpty()) {
      category.setTitle(categoryDTO.title());
    }

    if (categoryDTO.description() != null && !categoryDTO.description().isEmpty()) {
      category.setDescription(categoryDTO.description());
    }

    repository.save(category);

    return category;
  }

  public void delete(@NonNull String id) {
    repository.deleteById(id);
  }
}
