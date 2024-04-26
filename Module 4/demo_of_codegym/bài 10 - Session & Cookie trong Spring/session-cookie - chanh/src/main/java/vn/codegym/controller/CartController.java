package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.CartDto;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cart){
        return new ModelAndView("cart/list", "cart", cart);
    }
}
