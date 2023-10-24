package oit.is.apple.work05.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Sample51Controller {

  @GetMapping("step1")
  public String sample51(Principal prin, ModelMap model) {
    String name = prin.getName();
    model.addAttribute("name", name);
    return "sample51.html";
  }
}
