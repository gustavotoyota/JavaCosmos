package com.javacosmos.database.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.dtos.CategoryDTO;
import com.javacosmos.database.mongo.exceptions.CategoryNotFoundException;
import com.javacosmos.database.mongo.model.Category;
import com.javacosmos.database.mongo.repositories.MongoCategoryRepository;

import lombok.NonNull;

@Service
public class MongoCategoryService {
  private MongoCategoryRepository repository;

  public MongoCategoryService(MongoCategoryRepository categoryRepository) {
    this.repository = categoryRepository;
  }

  public Category create(CategoryDTO categoryDTO) {
    Category category = new Category(categoryDTO);

    return repository.save(category);
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
