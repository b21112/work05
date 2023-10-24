package oit.is.apple.work05.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.apple.work05.model.FruitMapper;
import oit.is.apple.work05.model.Fruit;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  @Autowired
  private FruitMapper fruitMapper;

  @GetMapping("step1")
  public String sample51(Principal prin, ModelMap model) {
    String name = prin.getName();
    model.addAttribute("name", name);
    return "sample51.html";
  }

  @GetMapping("step2")
  public String sample52(ModelMap model) {
    ArrayList<Fruit> fruits = fruitMapper.selectAllFruits();
    model.addAttribute("fruits", fruits);
    return "sample51.html";
  }

  @GetMapping("step3")
  @Transactional
  public String sample53(@RequestParam Integer id, ModelMap model) {
    Fruit fruit3 = fruitMapper.selectById(id);
    model.addAttribute("fruit3", fruit3);

    fruitMapper.deleteFruitById(id);

    ArrayList<Fruit> fruits = fruitMapper.selectAllFruits();
    model.addAttribute("fruits", fruits);
    return "sample51.html";
  }

  @GetMapping("step4")
  @Transactional
  public String sample54(@RequestParam Integer id, ModelMap model) {
    Fruit fruit4 = fruitMapper.selectById(id);
    model.addAttribute("fruit4", fruit4);

    ArrayList<Fruit> fruits = fruitMapper.selectAllFruits();
    model.addAttribute("fruits", fruits);
    return "sample51.html";
  }

  @PostMapping("step5")
  @Transactional
  public String sample55(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer price,
      ModelMap model) {

    Fruit fruit = new Fruit(id, name, price);
    // update
    fruitMapper.updateFruitById(fruit);
    // フルーツリストを取得
    ArrayList<Fruit> fruits = fruitMapper.selectAllFruits();
    model.addAttribute("fruits", fruits);

    return "sample51.html";
  }

}
