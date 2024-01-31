package com.javacosmos.lombok.classonly;

import lombok.Builder;

/*
 * @Builder is a shortcut to create builder methods.
 */

@Builder
public class BuilderExample {
  private String name;
  private double price;

  public void demonstration() {
    BuilderExample.builder()
        .name(name)
        .price(price)
        .build(); // Building the object using the builder pattern
  }
}
