package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/email")
public class Controller {

    @ModelAttribute("language")
    public String[] language() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("size")
    public String[] size() {
        return new String[]{"5", "10", "15", "25", "50", "100"};
    }

    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("email");
        modelAndView.addObject("email", new Email());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView update(@ModelAttribute Email email) {
        System.out.println(email);
        return showForm();
    }

}

