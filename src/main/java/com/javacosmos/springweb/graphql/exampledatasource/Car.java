package com.javacosmos.springweb.graphql.exampledatasource;

import java.util.Arrays;
import java.util.List;

public record Car(String id, String model, int year, String manufacturerId) {

  private static final List<Car> list = Arrays.asList(
      new Car("car-1", "Model S", 2020, "manufacturer-1"),
      new Car("car-2", "3 Series", 2019, "manufacturer-2"),
      new Car("car-3", "A4", 2021, "manufacturer-3"));

  public static Car findById(String id) {
    return list.stream().filter(car -> car.id().equals(id)).findFirst().orElse(null);
  }
}
