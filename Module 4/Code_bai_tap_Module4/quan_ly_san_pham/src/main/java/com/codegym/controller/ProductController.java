package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController{
    @Autowired
    private IProductService service;

    @GetMapping(value = {"", "/list"})
    public String showList(Model model) {
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Product product, Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute Product product) {
        ModelAndView modelAndView;
        product.setId((int) (Math.random() * 10000));
        if (service.save(product)) {
            modelAndView = new ModelAndView("redirect:/product");
        } else {
            String msg = "Loi";
            modelAndView = new ModelAndView("create", "msg", msg);
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public ModelAndView doUpdate(@ModelAttribute Product product) {
        ModelAndView modelAndView;
        if (service.update(product)) {
            modelAndView = new ModelAndView("redirect:/product");
        } else {
            String msg = "Loi";
            modelAndView = new ModelAndView("update", "msg", msg);
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @PostMapping("/search")
    public ModelAndView doSearch(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = service.search(search);
        modelAndView.addObject("products", products);
        modelAndView.addObject("search", search);
        return modelAndView;
    }
}