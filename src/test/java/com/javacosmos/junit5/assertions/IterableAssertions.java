package com.javacosmos.junit5.assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IterableAssertions {
  @Test
  void testArrayEquals() {
    int[] expected = { 1, 2, 3 };
    int[] actual = { 1, 2, 3 };
    assertArrayEquals(expected, actual);
  }

  @Test
  void testIterableEquals() {
    assertIterableEquals(
        Arrays.asList("a", "b", "c"),
        Arrays.asList("a", "b", "c"));
  }

  @Test
  void testLinesMatch() {
    /*
     * assertLinesMatch works with regular expressions and fast-forward markers.
     * 
     * A valid fast-forward marker is an expected line that starts and ends with the
     * literal >> and contains at least 4 characters (>>>>).
     * 
     * If there's a number in the fast-forward marker, that number of lines will be
     * skipped. Else, lines are skipped until the first matching subsequent expected
     * line is found.
     */

    List<String> expected = Arrays.asList(
        "Test run finished after \\d+ ms",
        ">> 3 >>",
        "Hello");

    List<String> actual = Arrays.asList(
        "Test run finished after 100 ms",
        "Skipped",
        "Skipped",
        "Skipped",
        "Hello");

    assertLinesMatch(expected, actual);
  }
}
