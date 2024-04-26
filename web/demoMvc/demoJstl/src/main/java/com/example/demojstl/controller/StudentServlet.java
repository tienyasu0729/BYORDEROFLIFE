package com.example.demojstl.controller;

import com.example.demojstl.bean.Student;
import com.example.demojstl.service.StudentService;
import com.example.demojstl.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService service = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                showList(request, response);
                break;
            case "detail":
                showDetail(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            case "update":
                break;
            default:
                showError(request, response);
        }
    }

    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/create.jsp").forward(request, response);
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("student", service.findById(id));
        request.getRequestDispatcher("/user/detail_jstl.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentsaaa", service.findAll());
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showError(request, response);
            return;
        }

        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "update":
                doUpdate(request, response);
                break;
            default:
                showError(request, response);
        }

    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int sex = Integer.parseInt(request.getParameter("sex"));
        Student student = new Student(id, name, sex);
        service.update(student);
        response.sendRedirect("/student?action=list");
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int sex = Integer.parseInt(request.getParameter("sex"));
        Student student = new Student(id, name, sex);
        service.create(student);
        response.sendRedirect("/student?action=list");
    }
}
