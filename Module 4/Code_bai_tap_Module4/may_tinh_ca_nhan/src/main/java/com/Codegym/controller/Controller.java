package com.Codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/show")
public class Controller {
    @GetMapping("")
    public String show(){
        return "/caculator";
    }
    @PostMapping("/caculator")
    public String caulator(@RequestParam double first, double second, String calculation, Model model){
        switch (calculation){
            case "+":
                model.addAttribute("result", "Addition : " + (first + second));
                break;
            case "-":
                model.addAttribute("result", "Subtraction : " + (first - second));
                break;
            case "x":
                model.addAttribute("result", "Multiplication : " + (first * second));
                break;
            case "/":
                model.addAttribute("result", "Division : " + (first / second));
                break;
        }
        return "/caculator";
    }
}
