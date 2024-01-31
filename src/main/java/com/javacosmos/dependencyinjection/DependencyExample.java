package com.javacosmos.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
class DependencyExample {
  public void print(String type) {
    System.out.println(type + " example.");
  }
}