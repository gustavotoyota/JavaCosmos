package com.javacosmos.junit5.parameterizedtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MethodSourceExample {
  @ParameterizedTest
  @MethodSource("additionTestData")
  void testAddition(int num1, int num2, int expectedResult) {
    assertEquals(expectedResult, num1 + num2);
  }

  private static Stream<Object[]> additionTestData() {
    return Stream.of(
        new Object[] { 1, 1, 2 },
        new Object[] { 2, 3, 5 },
        new Object[] { 0, 0, 0 },
        new Object[] { -1, 1, 0 });
  }
}
