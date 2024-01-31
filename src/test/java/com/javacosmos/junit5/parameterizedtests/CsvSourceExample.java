package com.javacosmos.junit5.parameterizedtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceExample {
  @ParameterizedTest
  @CsvSource({ "apple, 5", "banana, 6", "orange, 6" })
  void testStringLength(String input, int expectedLength) {
    int result = input.length();

    assertEquals(expectedLength, result);
  }
}
