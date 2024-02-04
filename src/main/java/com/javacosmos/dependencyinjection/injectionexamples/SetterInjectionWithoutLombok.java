package com.javacosmos.dependencyinjection.injectionexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacosmos.dependencyinjection.DependencyExample;

import jakarta.annotation.PostConstruct;

@Component
public class SetterInjectionWithoutLombok {
  private DependencyExample setterInjectionNativeExample;

  @Autowired
  public void setterNativeExample(DependencyExample value) {
    this.setterInjectionNativeExample = value;
  }

  @PostConstruct
  public void printSetterInjectionNative() {
    this.setterInjectionNativeExample.print("Setter native injection");
  }
}
