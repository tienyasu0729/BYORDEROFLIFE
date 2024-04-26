package com.codegym.demo_springdatajpa_a10.controller;

import com.codegym.demo_springdatajpa_a10.dto.StudentDto;
import com.codegym.demo_springdatajpa_a10.model.Student;
import com.codegym.demo_springdatajpa_a10.service.IServiceStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("studentDto", new StudentDto());
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
    public String save(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // copy studentDto => student
        new StudentDto().validate(studentDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        serviceStudent.add(student);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/student";
    }
}
