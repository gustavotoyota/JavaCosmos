package com.javacosmos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
  @GetMapping("/")
  public String rootGetPath() {
    return "Hello World! GET method";
  }

  @PostMapping("/")
  public String rootPostPath() {
    return "Hello World! POST method";
  }
}
