package com.javacosmos.dependencyinjection.injectionexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacosmos.dependencyinjection.DependencyExample;

import jakarta.annotation.PostConstruct;

@Component
public class FieldInjection {
  @Autowired
  private DependencyExample fieldInjectionExample;

  @PostConstruct
  public void printFieldInjection() {
    this.fieldInjectionExample.print("Field injection");
  }
}
