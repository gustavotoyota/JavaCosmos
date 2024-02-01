package com.javacosmos.springsecurity.formlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form-login")
public class FormLoginController {
  @GetMapping("")
  public String login() {
    return "login";
  }

  @PostMapping("")
  public String postLogin() {
    return "redirect:/";
  }
}
