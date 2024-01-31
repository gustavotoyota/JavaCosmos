package com.javacosmos.lombok;

import lombok.Getter;

/*
 * @Getter is a shortcut to create getter methods.
 */

public class GetterExample {
  private @Getter String name;

  public void demonstration() {
    System.out.println(getName()); // Printing the result of the getter
  }
}
