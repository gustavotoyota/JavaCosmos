package com.javacosmos.database.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.javacosmos.database.mongo.dtos.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  private String id;

  private String title;
  private String description;
  private String ownerId;

  public Category(CategoryDTO categoryDTO) {
    this.title = categoryDTO.title();
    this.description = categoryDTO.description();
    this.ownerId = categoryDTO.ownerId();
  }
}
