package com.javacosmos.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form-auth")
public class FormAuthController {
  @GetMapping("/login")
  public String login() {
    return "form-auth/login";
  }

  @GetMapping("/test")
  public String test() {
    return "form-auth/test";
  }
}
