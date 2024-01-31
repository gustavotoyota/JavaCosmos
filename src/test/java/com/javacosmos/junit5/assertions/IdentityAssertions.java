package com.javacosmos.junit5.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IdentityAssertions {
  @Test
  void testEquals() {
    assertEquals(5, 2 + 3);
  }

  @Test
  void testTrue() {
    assertTrue(4 > 2);
  }

  @Test
  void testFalse() {
    assertFalse(3 < 1);
  }

  @Test
  void testNull() {
    assertNull(null);
  }

  @Test
  void testNotNull() {
    assertNotNull("Hello");
  }

  @Test
  void testSame() {
    String s1 = "abc";
    String s2 = "abc";
    assertSame(s1, s2);
  }

  @Test
  void testNotSame() {
    String s1 = new String("abc");
    String s2 = new String("abc");
    assertNotSame(s1, s2);
  }

  @Test
  void testInstanceOf() {
    assertInstanceOf(Object.class, new Object());
  }
}
