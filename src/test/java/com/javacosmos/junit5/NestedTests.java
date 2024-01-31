package com.javacosmos.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTests {
  @Test
  void testAddition() {
    assertEquals(5, 2 + 3);
  }

  @Nested
  class SubtractionTests {
    @Test
    void testSubtractionWithPositiveResult() {
      assertEquals(1, 3 - 2);
    }

    @Test
    void testSubtractionWithNegativeResult() {
      assertEquals(-2, 3 - 5);
    }
  }
}
