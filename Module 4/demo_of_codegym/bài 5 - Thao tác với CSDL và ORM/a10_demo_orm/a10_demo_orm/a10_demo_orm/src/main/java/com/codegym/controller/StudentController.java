package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IServiceStudent serviceStudent;
    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"JS","PHP","JAVA","SQL"};
    }
    @GetMapping("")
    public String showList(ModelMap model){
        List<Student> studentList = serviceStudent.findAll();
        model.addAttribute("studentList",studentList);
        return "/list";
    }
    @GetMapping(value = "/create")
    public String showFormAdd(Model model){
         model.addAttribute("student", new Student());
//         model.addAttribute("languages", new String[]{"JS","PHP","JAVA","SQL"});
         return "create";
    }
    @GetMapping("/detail")
    public String showDetail1(@RequestParam int id, Model model){
        // database
        model.addAttribute("student",serviceStudent.findById(id));

        return "detail";
    }
    @GetMapping("/detail/{id}")
    public String showDetail2(@PathVariable int id, Model model){
        // database
        model.addAttribute("student",serviceStudent.findById(id));

        return "detail";
    }
//    @GetMapping("/delete/{id}")
    @GetMapping("/delete/*/{id:[0-9]}/{name}")
    public String delete(@PathVariable int id,@PathVariable String name, Model model){
        System.out.println(id);
        System.out.println(name);

        return "detail";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Student student, RedirectAttributes redirect){
       boolean check= serviceStudent.add(student);
       String mess = "Thêm mới không thành công";
       if (check){
           mess ="Thêm mới thành công";
           redirect.addFlashAttribute("mess",mess);
           return "redirect:/student";
       }
        return "redirect:/student/create";
    }
}
