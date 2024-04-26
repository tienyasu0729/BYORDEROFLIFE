package com.example.hienthidanhsachkhachhang.servlet;

import com.example.hienthidanhsachkhachhang.modal.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cusServlet", value = "/c")
public class cusServlet extends HttpServlet {
    private List<Customer> customers;
    @Override
    public void init() throws ServletException {
        super.init();
        customers = new ArrayList<>();
        customers.add(new Customer("Mai Văn Hoàn", "1983-08-20","Hà Nội","webapp/data/Picture1.png"));
        customers.add(new Customer("Nguyễn Văn Nam", "1983-08-21","Bắc Giang","Picture2.png"));
        customers.add(new Customer("Nguyễn Thái Hoà", "1983-08-22","Nam Định","Picture3.png"));
        customers.add(new Customer("Trần Đăng Khoa", "1983-08-17","Hà Tây","Picture4.png"));
        customers.add(new Customer("Nguyễn Đình Thi", "1983-08-19","Hà Nội","Picture5.png"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/user/jstl.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
