package com.javacosmos.lombok.classonlyannotations;

import lombok.Data;
import lombok.NonNull;

/*
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 * 
 * Generates getter, setter, equals, hashCode, toString, and constructor for all fields.
 */

@Data
public class DataAnnotation {
  private @NonNull String name;
  private int age;

  public void demonstration() {
    // Getters

    System.out.println(getName());
    System.out.println(getAge());

    // Setters

    setName("John");
    setAge(30);

    // Equals

    if (this.equals(this)) {
      System.out.println("Equals");
    }

    // HashCode

    System.out.println(hashCode());

    // toString

    System.out.println(this);

    // Constructor

    new DataAnnotation("John"); // Only required fields in constructor
  }
}