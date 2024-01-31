package com.javacosmos.junit5.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class Others {
  @Test
  void testAll() {
    assertAll("Math operations",
        () -> assertEquals(4, 2 + 2),
        () -> assertEquals(6, 3 * 2),
        () -> assertEquals(8, 4 + 4));
  }

  @Test
  void testFail() {
    fail("This test will fail.");
  }
}
