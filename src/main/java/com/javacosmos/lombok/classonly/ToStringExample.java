package com.javacosmos.lombok.classonly;

import lombok.ToString;

/*
 * @ToString is a shortcut to create toString method.
 */

@ToString
public class ToStringExample {
  private String field1;
  private int field2;

  public void demonstration() {
    System.out.println(this); // Printing the result of toString()
  }
}
