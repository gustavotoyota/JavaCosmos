package com.javacosmos.springweb.templateengines.thymeleaf;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExampleController {
  @GetMapping
  public String test(Model model) throws IOException {
    model.addAttribute("userName", "(user passed by model)");

    return "thymeleaf-example/thymeleaf-example.html";
  }
}
