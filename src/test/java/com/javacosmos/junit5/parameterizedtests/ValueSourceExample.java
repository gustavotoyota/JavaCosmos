package com.javacosmos.junit5.parameterizedtests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceExample {
  @ParameterizedTest
  @ValueSource(doubles = { 4.0, 9.0, 16.0, 25.0 })
  void testSquareRoot(double input) {
    double result = Math.sqrt(input);
    assertTrue(result >= 0, "Square root should be non-negative");
  }
}
