package com.javacosmos.lombok;

import lombok.NonNull;

/*
 * @NonNull is a shortcut to create not null validation.
 */

public class NonNullExample {
  private @NonNull String name;

  public void demonstration(@NonNull String arg) {
    // arg will be validated for null

    name = "Lombok"; // No problem
    name = null; // NullPointerException
  }
}
