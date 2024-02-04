package com.javacosmos.springweb.templateengines.jsp;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JSPExampleController {
  @GetMapping
  public String test(Model model) throws IOException {
    model.addAttribute("userName", "(user passed by model)");

    return "jsp-example.jsp";
  }
}
