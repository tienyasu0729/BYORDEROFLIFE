package com.example.thi_module_3_lan_2.controller;

import com.example.thi_module_3_lan_2.Service.Impl.TroServiceImpl;
import com.example.thi_module_3_lan_2.Service.Impl.TypeServiceImpl;
import com.example.thi_module_3_lan_2.model.Tro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "TroServlet", value = "/TroServlet")
public class TroServlet extends HttpServlet {
    private TroServiceImpl troService = new TroServiceImpl();
    private TypeServiceImpl typeService  = new TypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        list_tro(request,response);
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
            case "create_tro":
                addTro(request,response);
                break;
            case "delete_tro":
                deleteTro(request,response);
                break;

        }
    }
    private void list_tro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listTro", troService.display_tro());
        request.setAttribute("listType", typeService.display_type());
        request.getRequestDispatcher("display/listTro.jsp").forward(request,response);
    }

    private void addTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = dateFormat.parse(request.getParameter("startDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int idType = Integer.parseInt(request.getParameter("idType"));
        String note = request.getParameter("note");
        Tro tro = new Tro("1",name,phoneNumber,startDate,idType,note);
        troService.add_tro(tro);
        list_tro(request,response);
    }
    private void deleteTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] deleteTro = request.getParameterValues("delete[]");
        for (int i = 0; i < deleteTro.length; i++) {
            troService.delete(Integer.parseInt(deleteTro[i]));
        }
        list_tro(request,response);
    }


}
