package com.javacosmos.database.mongo.domain.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.javacosmos.database.mongo.domain.category.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  private String id;

  private String title;
  private String description;
  private String ownerId;
  private Integer price;
  private Category category;

  public Product(ProductDTO productDTO) {
    this.title = productDTO.title();
    this.description = productDTO.description();
    this.ownerId = productDTO.ownerId();
    this.price = productDTO.price();
  }
}
