package com.javacosmos.lombok;

import lombok.val;

/*
 * val is a shortcut to create final variable.
 * 
 * It has been replaced by final var.
 */

public class ValExample {
  public void demonstration() {
    // val is a final variable
    val name = "Java Cosmos";

    System.out.println(name);

    // name = "Java Cosmos"; // Compilation error
  }
}
