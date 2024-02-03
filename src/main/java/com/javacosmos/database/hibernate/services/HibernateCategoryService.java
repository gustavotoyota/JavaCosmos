package com.javacosmos.database.hibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javacosmos.database.hibernate.dtos.CategoryDTO;
import com.javacosmos.database.hibernate.exceptions.CategoryNotFoundException;
import com.javacosmos.database.hibernate.model.Category;
import com.javacosmos.database.hibernate.repositories.HibernateCategoryRepository;

import lombok.NonNull;

@Service
public class HibernateCategoryService {
  private HibernateCategoryRepository repository;

  public HibernateCategoryService(HibernateCategoryRepository repository) {
    this.repository = repository;
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

    if (categoryDTO.ownerId() != null) {
      category.setOwnerId(categoryDTO.ownerId());
    }

    repository.save(category);

    return category;
  }
}
