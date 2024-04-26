package com.example.retake_module_3.controller;

import com.example.retake_module_3.Service.Impl.Android_PhoneServiceImpl;
import com.example.tien_thanh.Service.IAndroid_PhoneService;
import com.example.tien_thanh.Service.ICccdService;
import com.example.tien_thanh.Service.IDetailService;
import com.example.tien_thanh.Service.Impl.Android_PhoneServiceImpl;
import com.example.tien_thanh.Service.Impl.CccdServiceImpl;
import com.example.tien_thanh.Service.Impl.DetailServiceImpl;
import com.example.tien_thanh.model.Android_Phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private Android_PhoneServiceImpl service = new Android_PhoneServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        list(request,response);
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

        }
        switch (action) {

        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", service.list());

        request.getRequestDispatcher("").forward(request,response);
    }

}
