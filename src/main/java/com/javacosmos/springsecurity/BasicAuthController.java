package com.javacosmos.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic-auth")
public class BasicAuthController {
  @GetMapping("/test")
  public String test() {
    return "basic-auth/test";
  }
}
