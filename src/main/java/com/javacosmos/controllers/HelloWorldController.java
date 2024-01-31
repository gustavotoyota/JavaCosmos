package com.javacosmos.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  @GetMapping("/")
  public String get() {
    return "Hello World! GET method";
  }

  @PostMapping("/")
  public String post() {
    return "Hello World! POST method";
  }

  @PutMapping("/")
  public String put() {
    return "Hello World! PUT method";
  }

  @DeleteMapping("/")
  public String delete() {
    return "Hello World! DELETE method";
  }

  @PatchMapping("/")
  public String patch() {
    return "Hello World! PATCH method";
  }
}
