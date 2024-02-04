package com.javacosmos.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class DependencyExample {
  public void print(String type) {
    System.out.println(type + " example.");
  }
}