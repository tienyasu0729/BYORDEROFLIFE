package com.codegym.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(){
        return "/show";
    }

    @RequestMapping(value = "/swap", method = RequestMethod.POST)
    public String swap(@RequestParam Double moneyNeedSwap, @RequestParam int exchangeRace, Model model){
        model.addAttribute("value", moneyNeedSwap * exchangeRace);
        return "/valueSwap";
    }
}
