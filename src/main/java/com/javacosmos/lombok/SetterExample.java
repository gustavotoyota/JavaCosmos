package com.javacosmos.lombok;

import lombok.Setter;

/*
 * @Setter is a shortcut to create setter methods.
 */

public class SetterExample {
  private @Setter String name;

  public void demonstration() {
    setName("Lombok"); // Setting the value of the field
  }
}
