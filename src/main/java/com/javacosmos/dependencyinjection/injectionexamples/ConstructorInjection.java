package com.javacosmos.dependencyinjection.injectionexamples;

import org.springframework.stereotype.Component;

import com.javacosmos.dependencyinjection.DependencyExample;

import jakarta.annotation.PostConstruct;

@Component
public class ConstructorInjection {
  private DependencyExample constructorInjectionExample;

  // @Autowired // Optional after Spring 4.3
  // Only required if there is more than one constructor
  // and you want to specify which one to use for injection
  public ConstructorInjection(DependencyExample value) {
    this.constructorInjectionExample = value;
  }

  @PostConstruct
  public void printConstructorInjection() {
    this.constructorInjectionExample.print("Constructor injection");
  }
}
