package com.javacosmos.junit5.assertions;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class TimeoutAssertions {
  @Test
  void testTimeout() {
    // assertTimeout waits until the operation is complete to fail the test.
    // For example, if the sleep time were 8 seconds, the test will fail after 8
    // seconds.

    assertTimeout(Duration.ofSeconds(2), () -> {
      // Some potentially time-consuming operation
      Thread.sleep(1000);
    });
  }

  @Test
  void testTimeoutPreemptively() {
    // assertTimeoutPreemptively fails immediately after the duration is exceeded.
    // For example, if the sleep time were 8 seconds, the test will fail after 2
    // seconds.

    assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
      // Some potentially time-consuming operation
      Thread.sleep(1000);
    });
  }
}
