package com.javacosmos.junit4;

import org.junit.Assert;
import org.junit.Test;

public class Assertions {
  @Test
  public void testEquals() {
    Assert.assertEquals(4, 2 + 2);
  }

  @Test
  public void testNotEquals() {
    Assert.assertNotEquals(5, 3 + 3);
  }

  @Test
  public void testTrue() {
    Assert.assertTrue(4 > 2);
  }

  @Test
  public void testFalse() {
    Assert.assertFalse(3 < 1);
  }

  @Test
  public void testNull() {
    Assert.assertNull(null);
  }

  @Test
  public void testNotNull() {
    Assert.assertNotNull("Hello");
  }

  @Test
  public void testSame() {
    String s1 = "abc";
    String s2 = "abc";
    Assert.assertSame(s1, s2);
  }

  @Test
  public void testNotSame() {
    String s1 = new String("abc");
    String s2 = new String("abc");
    Assert.assertNotSame(s1, s2);
  }

  @Test
  public void testThrows() {
    Assert.assertThrows(ArithmeticException.class, () -> {
      System.out.println(1 / 0);
    });
  }

  @Test
  public void testArrayEquals() {
    int[] expected = { 1, 2, 3, 4 };
    int[] actual = { 1, 2, 3, 4 };
    Assert.assertArrayEquals(expected, actual);
  }

  @Test
  public void testFail() {
    Assert.fail("This test should fail!");
  }
}
