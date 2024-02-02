package com.javacosmos.controllermappings;

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
    return "<div>JavaCosmos links:</div>" +
        "<br/>" +
        "<div><a href=\"/jsp\">JSP example</a></div>" +
        "<div><a href=\"/thymeleaf\">Thymeleaf example</a></div>" +
        "<br/>" +
        "<div><a href=\"/files\">File upload</a></div>" +
        "<br/>" +
        "<div><a href=\"/form-auth/test\">Form login</a></div>" +
        "<div><a href=\"/basic-auth/test\">Basic HTTP auth</a></div>";
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
