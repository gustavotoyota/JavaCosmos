package com.javacosmos.dependencyinjection.injectionexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacosmos.dependencyinjection.DependencyExample;

import jakarta.annotation.PostConstruct;
import lombok.Setter;

@Component
public class SetterInjectionWithLombok {
  @Setter(onMethod_ = @Autowired)
  private DependencyExample setterInjectionLombokExample;

  @PostConstruct
  public void printSetterInjectionLombok() {
    this.setterInjectionLombokExample.print("Setter Lombok injection");
  }
}
