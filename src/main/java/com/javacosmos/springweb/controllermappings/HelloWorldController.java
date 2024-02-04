package com.javacosmos.springweb.controllermappings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
  @GetMapping("/")
  public String get() {
    return "home-page/home-page.html";
  }

  @PostMapping("/")
  @ResponseBody
  public String post() {
    return "Hello World! POST method";
  }

  @PutMapping("/")
  @ResponseBody
  public String put() {
    return "Hello World! PUT method";
  }

  @DeleteMapping("/")
  @ResponseBody
  public String delete() {
    return "Hello World! DELETE method";
  }

  @PatchMapping("/")
  @ResponseBody
  public String patch() {
    return "Hello World! PATCH method";
  }
}
