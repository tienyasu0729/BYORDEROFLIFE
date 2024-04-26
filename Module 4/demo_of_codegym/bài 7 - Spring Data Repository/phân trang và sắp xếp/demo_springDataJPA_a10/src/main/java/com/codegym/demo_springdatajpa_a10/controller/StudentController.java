package com.codegym.demo_springdatajpa_a10.controller;

import com.codegym.demo_springdatajpa_a10.model.Student;
import com.codegym.demo_springdatajpa_a10.service.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IServiceStudent serviceStudent;

    @ModelAttribute("languages")
    public String[] getLanguages() {
        return new String[]{"JS", "PHP", "JAVA", "SQL"};
    }

    //    @GetMapping("")
//    public String showList(ModelMap model){
//        List<Student> studentList = serviceStudent.findAll();
//        model.addAttribute("studentList",studentList);
//        return "/list";
//    }
//    @GetMapping("")
//    public String showPage(@PageableDefault(page = 0, size = 2,sort = "name",direction = Sort.Direction.ASC) Pageable pageable, ModelMap model) {
//        Page<Student> studentPages = serviceStudent.findAll(pageable);
//        model.addAttribute("studentPages", studentPages);
//        return "/list";
//    }

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page ,
                           @RequestParam(defaultValue = "")String searchName,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,2,Sort.by("name").ascending().and(Sort.by("gender").descending()));
        Page<Student> studentPages = serviceStudent.findAll(pageable,searchName);
        model.addAttribute("studentPages", studentPages);
        model.addAttribute("searchName", searchName);
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showFormAdd(Model model) {
        model.addAttribute("student", new Student());
//         model.addAttribute("languages", new String[]{"JS","PHP","JAVA","SQL"});
        return "create";
    }

    @GetMapping("/detail")
    public String showDetail1(@RequestParam int id, Model model) {
        // database
        model.addAttribute("student", serviceStudent.findById(id));

        return "detail";
    }

    @GetMapping("/detail/{id}")
    public String showDetail2(@PathVariable int id, Model model) {
        // database
        model.addAttribute("student", serviceStudent.findById(id));

        return "detail";
    }

    //    @GetMapping("/delete/{id}")
    @GetMapping("/delete/*/{id:[0-9]}/{name}")
    public String delete(@PathVariable int id, @PathVariable String name, Model model) {
        System.out.println(id);
        System.out.println(name);

        return "detail";
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute Student student) {
        serviceStudent.add(student);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("mess", "Them moi thanh cong");
        List<Student> studentList = serviceStudent.findAll();
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }
}
