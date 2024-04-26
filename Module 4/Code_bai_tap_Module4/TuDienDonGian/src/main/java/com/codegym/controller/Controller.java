package com.codegym.controller;

import com.codegym.Service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IDictionary service;

    @GetMapping("/dictionary")
    public String index() {
        return "dictionary";
    }

    @PostMapping("/US")
    public String submit(@RequestParam String US, Model model) {
        model.addAttribute("VN", service.checkText(US));
        return "dictionary";
    }
}
