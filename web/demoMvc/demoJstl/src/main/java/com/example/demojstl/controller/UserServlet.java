package com.example.demojstl.controller;

import com.example.demojstl.bean.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user/detail")
public class UserServlet extends HttpServlet {
    public static List<Student> students;

    @Override
    public void init() throws ServletException {
        super.init();
        students = new ArrayList<>();
        students.add(new Student("SV01", "Tai", 1, "Da Nang", 7.5f));
        students.add(new Student("SV02", "Nam", 1, "Quang Nam", 9.5f));
        students.add(new Student("SV03", "Luan", 0, "Da Nang", 6.5f));
        students.add(new Student("SV04", "Nhan", 1, "Quang Ngai", 5.0f));
        students.add(new Student("SV05", "Thao", 0, "<h1>Da Nang</h1>", 4.5f));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Student student = null;
        for (Student s: students) {
            if (s.getId().equals(id)) {
                student = s;
            }
        }
        request.setAttribute("student", student);
        request.setAttribute("students", students);
//        request.getRequestDispatcher("/user/detail.jsp").forward(request, response);
//        request.getRequestDispatcher("/user/detail_jstl.jsp").forward(request, response);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
