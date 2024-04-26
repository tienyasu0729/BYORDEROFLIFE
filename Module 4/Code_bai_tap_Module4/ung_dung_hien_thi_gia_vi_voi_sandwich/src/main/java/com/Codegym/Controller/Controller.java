package com.Codegym.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(){
        return "/sanwich";
    }
    @PostMapping(value = "/postShow")
    public String showPost(@RequestParam String[] spice, Model model){
        String showSpice = Arrays.toString(spice);
        model.addAttribute("showSpice", showSpice);
        return "/sanwich";
    }
}
