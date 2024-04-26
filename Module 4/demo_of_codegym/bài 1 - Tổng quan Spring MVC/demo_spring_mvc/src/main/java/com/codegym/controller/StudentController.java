package com.codegym.controller;

import com.codegym.service.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentService2")
    private IServiceStudent serviceStudent;

    @RequestMapping(value = "/student-list",method = RequestMethod.GET)
    public String showList(Model model){
        model.addAttribute("mess", serviceStudent.showMessage());
        return "/list";
    }
}
