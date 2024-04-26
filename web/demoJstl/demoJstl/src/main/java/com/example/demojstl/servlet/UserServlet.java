package com.example.demojstl.servlet;

import com.example.demojstl.modal.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/userggg")
public class UserServlet extends HttpServlet {
    private List<Student> students;

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

        if (id != null) {
            Student student = null;
            for (Student s : students) {
                if (s.getId().equals(id)) {
                    student = s;
                }
            }
            request.setAttribute("student", student);
            request.getRequestDispatcher("/user/detail.jsp").forward(request, response);
//        request.getRequestDispatcher("/user/detail_jstl.jsp").forward(request, response);
        } else {
            request.setAttribute("students", students);
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
