package com.javacosmos.lombok.classonly;

import lombok.Value;

/*
 * @Value is a shortcut to create immutable classes.
 * 
 * It is the immutable variant of @Data, without @Setters and with @AllArgsConstructor instead of @RequiredArgsConstructor.
 * All fields are made private and final by default, and setters are not generated.
 * The class itself is also made final by default, because immutability is not something that can be forced onto a subclass.
 * 
 * Like @Data, useful toString(), equals() and hashCode() methods are also generated,
 * each field gets a getter method, and a constructor that covers every argument
 * (except final fields that are initialized in the field declaration) is also generated.
 * 
 * In practice, @Value is shorthand for: final @ToString @EqualsAndHashCode
 * @AllArgsConstructor @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) @Getter
 */

@Value
public class ValueExample {
  private String name;
  private int age;

  public void demonstration() {
    // Getters

    System.out.println(getName());
    System.out.println(getAge());

    // Equals

    if (this.equals(this)) {
      System.out.println("Equals");
    }

    // HashCode

    System.out.println(hashCode());

    // toString

    System.out.println(this);

    // Constructor

    new ValueExample("John", 30); // All fields in constructor
  }
}
