package com.javacosmos.lombok.classonlyannotations;

import lombok.ToString;

/*
 * @ToString is a shortcut to create toString method.
 */

@ToString
public class ToStringAnnotation {
  private String field1;
  private int field2;

  public void demonstration() {
    System.out.println(this); // Printing the result of toString()
  }
}
