package com.javacosmos.lombok;

import lombok.Getter;

/*
 * @Getter is a shortcut to create getter methods.
 * 
 * With @Getter(lazy=true), you can let lombok generate a getter which will calculate
 * a value once, the first time this getter is called, and cache it from then on.
 */

public class LazyGetterAnnotation {
  private final @Getter(lazy = true) String name = "Lombok";

  public void demonstration() {
    System.out.println(getName()); // Printing the result of the getter
  }
}