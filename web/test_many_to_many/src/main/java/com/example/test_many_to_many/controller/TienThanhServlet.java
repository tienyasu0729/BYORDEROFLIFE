package com.example.test_many_to_many.controller;

import com.example.test_many_to_many.Service.Impl.IMiddServiceImpl;
import com.example.test_many_to_many.Service.Impl.RoleServiceImpl;
import com.example.test_many_to_many.Service.Impl.UserServiceImpl;
import com.example.test_many_to_many.model.Midd;
import com.example.test_many_to_many.model.Role;
import com.example.test_many_to_many.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private UserServiceImpl userService;
    private IMiddServiceImpl middService;
    private RoleServiceImpl roleService;


    public void init() {
        userService = new UserServiceImpl();
        middService = new IMiddServiceImpl();
        roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listUser(request, response);
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
        System.out.println();
        if (action2 == null) {
            action2 = "";
        }
        switch (action2) {
            case "addUserAndRole":
                add_user_and_role(request, response);
                break;
        }
        switch (action) {

        }
    }

    private void add_user_and_role(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String fullname = request.getParameter("fullName");
        String code = request.getParameter("code");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = null;
        try {
            birthdate = dateFormat.parse(request.getParameter("birthdate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime timeBuild = LocalDateTime.now();
        int idRole = Integer.parseInt(request.getParameter("idRole"));

        User user = new User(idUser, fullname, code, birthdate, timeBuild);
        Role role = new Role(idRole);
        Midd midd = new Midd(user, role);
        userService.add_user(user);
        middService.add_midd(midd);

        listUser(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMidd", middService.list_midd());
        request.setAttribute("listRole", roleService.display_role());
        request.getRequestDispatcher("listAndroid_Phone.jsp").forward(request, response);
    }

}
