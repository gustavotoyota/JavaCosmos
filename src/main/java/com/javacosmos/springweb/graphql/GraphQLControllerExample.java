package com.javacosmos.springweb.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.javacosmos.springweb.graphql.exampledatasource.Car;
import com.javacosmos.springweb.graphql.exampledatasource.Manufacturer;

@Controller
public class GraphQLControllerExample {
  @QueryMapping
  public Car carById(@Argument String id) {
    return Car.findById(id);
  }

  @SchemaMapping
  public Manufacturer manufacturer(Car car) {
    return Manufacturer.findById(car.manufacturerId());
  }
}
