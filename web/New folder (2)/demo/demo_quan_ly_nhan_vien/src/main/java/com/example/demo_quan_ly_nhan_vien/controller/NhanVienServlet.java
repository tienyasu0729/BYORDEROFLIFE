package com.example.demo_quan_ly_nhan_vien.controller;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;
import com.example.demo_quan_ly_nhan_vien.model.NhanVien;
import com.example.demo_quan_ly_nhan_vien.service.CongViecService;
import com.example.demo_quan_ly_nhan_vien.service.CongViecServiceImpl;
import com.example.demo_quan_ly_nhan_vien.service.NhanVienService;
import com.example.demo_quan_ly_nhan_vien.service.NhanVienServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = "/nhan-vien")
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nhanVienService;
    private CongViecService congViecService;

    public void init() {
        nhanVienService = new NhanVienServiceImpl();
        congViecService = new CongViecServiceImpl();
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
                showNewForm(request, response);
                break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteNhanVien(request, response);
//                    break;
            default:
                listNhanVien(request, response);
                break;
        }
    }

    private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNhanVien = nhanVienService.findAll();
        request.setAttribute("listNhanVien", listNhanVien);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCongViec", congViecService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
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
                insertUser(request, response);
                break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
//                case "search":
//                    searchByCountry(request, response);
//                    break;
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String maCongViec = request.getParameter("maCongViec");
        CongViec congViec = congViecService.findById(maCongViec);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date ngaySinh = null, ngayKetThucLam = null, ngayBatDauLam = null;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            ngayBatDauLam = dateFormat.parse(request.getParameter("ngayBatDauLam"));
            ngayKetThucLam = dateFormat.parse(request.getParameter("ngayKetThucLam"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec);
        nhanVienService.add(nhanVien);
        response.sendRedirect("/nhan-vien?isCreate=true");
    }
}
