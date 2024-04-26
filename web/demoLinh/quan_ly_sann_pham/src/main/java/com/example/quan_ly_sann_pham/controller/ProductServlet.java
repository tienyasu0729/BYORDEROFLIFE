package com.example.quan_ly_sann_pham.controller;


import com.example.quan_ly_sann_pham.model.Product;
import com.example.quan_ly_sann_pham.service.CategoryService;
import com.example.quan_ly_sann_pham.service.CategoryServiceImpl;
import com.example.quan_ly_sann_pham.service.ProductService;
import com.example.quan_ly_sann_pham.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = "/list")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;

    public void init() {
        productService = new ProductServiceImpl();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listProduct(request, response);
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        System.out.println("get");
//        System.out.println(action);
//        switch (action) {
//            case "create":
//                showNewForm(request, response);
//                break;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
//            case "edit":
//                edit(request, response);
//                break;
//            case "delete":
//                deleteNhanVien(request, response);
//                break;
//            default:
//                listProduct(request, response);
//                break;
//        }
            default:
                listProduct(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String action2 = request.getParameter("action2");
        if (action == null) {
            action = "";
        }
        if (action2 == null) {
            action2 = "";
        }
        switch (action2) {
            case "Save":
                insertProduct(request, response);
                break;
            case "Edit":
            case "edit":
                edit(request, response);
                updateUser(request, response);
                break;
            case "search":
                searchByCountry(request, response);
                break;
            case "delete":
                deleteNhanVien(request, response);
                break;
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "list":
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.listProduct();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCategory", categoryService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String editId = request.getParameter("idEdit");
        request.setAttribute("listCategory", categoryService.findAll());
        request.setAttribute("product", editId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String editId = request.getParameter("idEdit");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String [] colorAfter = request.getParameterValues("color");
        String color = Arrays.toString(colorAfter);
        color = color.substring(1, color.length() - 1);
        String description = request.getParameter("description");
        String category = request.getParameter("category");
//        Product product = productService.findById(maCongViec);
        Product product = new Product(editId, name, price, quantity, color, description, category);
        productService.update(product);
        response.sendRedirect("/list");

    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) {
        productService.delete(request.getParameter("id"));
        //        int check = productService.delete(request.getParameter("id"));
//        if (check == 0){
//            request.setAttribute("deleteById", "Xoá sản phẩm không thành công");
//        }else {
//            request.setAttribute("deleteById", "Xoá sản phẩm thành công");
//        }
//        try {
//            request.getRequestDispatcher("/list.jsp").forward(request,response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            response.sendRedirect("/list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findName = request.getParameter("findName");
        List<Product> listProduct = productService.findByNameOfProduct(findName);
        request.setAttribute("listFindByName", listProduct);
        request.getRequestDispatcher("/findByName.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String [] colorAfter = request.getParameterValues("color");
        String color = Arrays.toString(colorAfter);
        color = color.substring(1, color.length() - 1);
        String description = request.getParameter("description");
        String category = request.getParameter("category");
//        Product product = productService.findById(maCongViec);
        Product product = new Product(id, name, price, quantity, color, description, category);
        productService.add(product);
        response.sendRedirect("/list?isCreate=true");
    }

}
