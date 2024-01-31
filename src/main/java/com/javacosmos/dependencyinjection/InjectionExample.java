package com.javacosmos.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.Setter;

@Service
public class InjectionExample {
  // Field injection

  @Autowired
  private DependencyExample fieldInjectionExample;

  @PostConstruct
  public void printFieldInjection() {
    this.fieldInjectionExample.print("Field injection");
  }

  // Setter injection with Lombok

  @Setter(onMethod_ = @Autowired)
  private DependencyExample setterInjectionLombokExample;

  @PostConstruct
  public void printSetterInjectionLombok() {
    this.setterInjectionLombokExample.print("Setter Lombok injection");
  }

  // Setter injection without Lombok

  private DependencyExample setterInjectionNativeExample;

  @Autowired
  public void setterNativeExample(DependencyExample value) {
    this.setterInjectionNativeExample = value;
  }

  @PostConstruct
  public void printSetterInjectionNative() {
    this.setterInjectionNativeExample.print("Setter native injection");
  }

  // Constructor injection

  private DependencyExample constructorInjectionExample;

  @Autowired
  public InjectionExample(DependencyExample value) {
    this.constructorInjectionExample = value;
  }

  @PostConstruct
  public void printConstructorInjection() {
    this.constructorInjectionExample.print("Constructor injection");
  }
}
