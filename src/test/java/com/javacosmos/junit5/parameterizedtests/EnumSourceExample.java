package com.javacosmos.junit5.parameterizedtests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceExample {
  private enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
  }

  @ParameterizedTest
  @EnumSource(value = Day.class, names = { "SATURDAY", "SUNDAY" })
  void testIsWeekend(Day day) {
    boolean isWeekend = day == Day.SATURDAY || day == Day.SUNDAY;

    assertTrue(isWeekend);
  }
}
