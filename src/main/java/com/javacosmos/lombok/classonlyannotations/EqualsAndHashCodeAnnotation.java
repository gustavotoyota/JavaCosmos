package com.javacosmos.lombok.classonlyannotations;

import lombok.EqualsAndHashCode;

/*
 * @EqualsAndHashCode is a shortcut to create hashCode and equals methods.
 */

@EqualsAndHashCode
public class EqualsAndHashCodeAnnotation {
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
