package com.example.exercise_hrm.controller;

import com.example.exercise_hrm.model.Employee;
import com.example.exercise_hrm.service.EmployeeService;
import com.example.exercise_hrm.service.JobService;
import com.example.exercise_hrm.service.impl.EmployeeServiceImpl;
import com.example.exercise_hrm.service.impl.JobServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EmployeeServlet", value = "")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;
    private JobService jobService;

    @Override
    public void init() throws ServletException {
        super.init();
        employeeService = new EmployeeServiceImpl();
        jobService = new JobServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.setAttribute("list", jobService.findAll());
                request.getRequestDispatcher("/create.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            case "searchTime":
            case "submit":
                searchTimeEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeList", employeeService.findAll());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("list", employee);
        request.setAttribute("listJob", jobService.findAll());
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        request.setAttribute("employeeList", employeeService.findAll());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameJob = request.getParameter("jobName");
        request.setAttribute("employeeList", employeeService.findByNameJob(nameJob));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int salary = Integer.parseInt((request.getParameter("salary")));
        int jobCode = Integer.parseInt(request.getParameter("jobCode"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date birthday = null, startDate = null, endDate = null;
        try {
            birthday = dateFormat.parse(request.getParameter("birthday"));
            startDate = dateFormat.parse(request.getParameter("startdate"));
            endDate = dateFormat.parse(request.getParameter("enddate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeService.add(new Employee(name, birthday, address, startDate, endDate, salary, jobCode));
        response.sendRedirect("/");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int salary = Integer.parseInt((request.getParameter("salary")));
        int jobCode = Integer.parseInt(request.getParameter("jobCode"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date birthday = null, startDate = null, endDate = null;
        try {
            birthday = dateFormat.parse(request.getParameter("birthday"));
            startDate = dateFormat.parse(request.getParameter("startdate"));
            endDate = dateFormat.parse(request.getParameter("enddate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeService.update(new Employee(name, birthday, address, startDate, endDate, salary, jobCode));
        response.sendRedirect("/");
    }

    private void searchTimeEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("submit".equals(request.getParameter("action"))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
                Date startDate = dateFormat.parse(request.getParameter("dayStart"));
                Date endDate = dateFormat.parse(request.getParameter("dayEnd"));

                // Chuyển đổi java.util.Date thành java.sql.Date
                java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
                java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
                request.setAttribute("employeeList", employeeService.search(sqlStartDate, sqlEndDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("/searchTime.jsp").forward(request, response);
    }

//    private void submit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        try {
//            Date startDate = dateFormat.parse(request.getParameter("dayStart"));
//            Date endDate = dateFormat.parse(request.getParameter("dayEnd"));
//
//            // Chuyển đổi java.util.Date thành java.sql.Date
//            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
//            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
//            request.setAttribute("employeeList", employeeService.search(sqlStartDate, sqlEndDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        request.getRequestDispatcher("/searchTime.jsp").forward(request, response);
//    }
}
