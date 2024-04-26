package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.Scanner;

@Controller
@RequestMapping(value = "/shop")
// tạo session tên cart
@SessionAttributes("cart")
public class ProductController {
    // mapping biến cart với biến session cart
    @ModelAttribute("cart")
    public CartDto initCart(){
        System.out.println("cart------------------------");
        return new CartDto();
    }
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showListPage(Model model,@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                                     @CookieValue(value = "productId",
                                                  required = false,
                                                  defaultValue = "-1")Long id){
//                    Hiện thị sản phầm xem gần nhất
                    model.addAttribute("historyProduct",productService.findById(id));
                    if (cartDto!=null){
                        model.addAttribute("cart",cartDto);
                    }
        return new ModelAndView("product/list", "productList", productService.findAll());
    }

//    @GetMapping
//    public ModelAndView showListPage(Model model,@SessionAttribute(value = "cart", required = false) CartDto cartDto,
//                                     @CookieValue(value = "productId",
//                                             required = false,
//                                             defaultValue = "-1")Long id){
////                    Hiện thị sản phầm xem gần nhất
//        model.addAttribute("historyProduct",productService.findById(id));
//        if (cartDto!=null){
//            model.addAttribute("cart",cartDto);
//        }
//        return new ModelAndView("product/list", "productList", productService.findAll());
//    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id,HttpServletResponse response) {
        // tạo Cookie để lưu lịch sử xem sản phẩm gần nhất
        Cookie cookie = new Cookie("productId",id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("product/detail",
                "product", productService.findById(id));
    }

// thêm mới vào giỏ hàng
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,@SessionAttribute(value = "cart")CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto  productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }



//    @GetMapping("/add/{id}")
//    public String addToCart(@PathVariable Long id,
//                            @SessionAttribute("cart") CartDto cart) {
//        Product productOption = productService.findById(id);
//        if (productOption!=null) {
//            ProductDto productDto = new ProductDto();
//            BeanUtils.copyProperties(productOption, productDto);
//            cart.addProduct(productDto);
//        }
//        return "redirect:/cart";
//    }

//    @GetMapping("/add/{id}")
//    public String addToCart(@PathVariable Long id,@SessionAttribute(value = "cart")CartDto cart) {
//        Product product = productService.findById(id);
//        if (product!=null){
//            ProductDto  productDto = new ProductDto();
//            BeanUtils.copyProperties(product,productDto);
//            cart.addProduct(productDto);
//        }
//        return "redirect:/cart";
//    }
}