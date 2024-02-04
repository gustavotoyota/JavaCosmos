package com.javacosmos.lombok.classonlyannotations;

import lombok.Builder;

/*
 * @Builder is a shortcut to create builder methods.
 */

@Builder
public class BuilderAnnotation {
  private String name;
  private double price;

  public void demonstration() {
    BuilderAnnotation.builder()
        .name(name)
        .price(price)
        .build(); // Building the object using the builder pattern
  }
}
