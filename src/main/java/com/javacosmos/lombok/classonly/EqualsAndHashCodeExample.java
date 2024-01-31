package com.javacosmos.lombok.classonly;

import lombok.EqualsAndHashCode;

/*
 * @EqualsAndHashCode is a shortcut to create hashCode and equals methods.
 */

@EqualsAndHashCode
public class EqualsAndHashCodeExample {
  private String name;
  private double price;

  public void demonstration() {
    // Equals

    if (this.equals(this)) {
      System.out.println("Equals");
    }

    // HashCode

    System.out.println(this.hashCode());
  }
}
