package com.javacosmos.database.hibernate.model;

import java.util.UUID;

import com.javacosmos.database.hibernate.dtos.CategoryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {
  @Id
  @GeneratedValue
  private UUID id;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String description;

  @Column(name = "owner_id", nullable = false)
  private UUID ownerId;

  public Category(CategoryDTO categoryDTO) {
    this.title = categoryDTO.title();
    this.description = categoryDTO.description();
    this.ownerId = categoryDTO.ownerId();
  }
}