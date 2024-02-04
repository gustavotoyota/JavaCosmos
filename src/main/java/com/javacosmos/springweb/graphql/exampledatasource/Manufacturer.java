package com.javacosmos.springweb.graphql.exampledatasource;

import java.util.Arrays;
import java.util.List;

public record Manufacturer(String id, String name, String country) {

  private static final List<Manufacturer> list = Arrays.asList(
      new Manufacturer("manufacturer-1", "Tesla", "USA"),
      new Manufacturer("manufacturer-2", "BMW", "Germany"),
      new Manufacturer("manufacturer-3", "Audi", "Germany"));

  public static Manufacturer findById(String id) {
    return list.stream().filter(manufacturer -> manufacturer.id().equals(id)).findFirst().orElse(null);
  }
}
