package com.javacosmos.database.hibernate.model;

import java.util.UUID;

import com.javacosmos.database.hibernate.dtos.ProductDTO;

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

@Table(name = "products")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
  @Id
  @GeneratedValue
  private UUID id;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String description;

  @Column(name = "owner_id", nullable = false)
  private UUID ownerId;

  @Column(nullable = false)
  private Integer price;

  @Column(name = "category_id", nullable = false)
  private UUID categoryId;

  public Product(ProductDTO productDTO) {
    this.title = productDTO.title();
    this.description = productDTO.description();
    this.ownerId = productDTO.ownerId();
    this.price = productDTO.price();
    this.categoryId = productDTO.categoryId();
  }
}
