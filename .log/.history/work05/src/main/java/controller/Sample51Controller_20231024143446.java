package controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Sample51Controller {

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }
}
