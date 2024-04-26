package com.example.quan_ly_nhan_su.controller;

import com.example.quan_ly_nhan_su.service.IEmployeeService;
import com.example.quan_ly_nhan_su.service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeListServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "List":
                listEmployee(request,response);
                break;
            case "Add":
                addNewEmployee(request,response);
                break;
        }
    }



    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeList", this.employeeService.listEmployee());
        request.getRequestDispatcher("users/listEmployee.jsp").forward(request,response);
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {

    }
}
