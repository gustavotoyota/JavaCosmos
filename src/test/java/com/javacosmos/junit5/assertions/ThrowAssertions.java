package com.javacosmos.junit5.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ThrowAssertions {
  @Test
  void testThrows() {
    assertThrows(ArithmeticException.class, () -> {
      System.out.println(1 / 0);
    });
  }

  @Test
  void testDoesNotThrow() {
    assertDoesNotThrow(() -> {
      System.out.println(1 / 1);
    });
  }
}
