package org.example.practicalexam.controller;


import org.example.practicalexam.Service.IMagazineService;
import org.example.practicalexam.Service.Impl.IMagazineServiceImpl;
import org.example.practicalexam.model.Magazine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MagazineServlet", value = "/magazine")
public class MagazineServlet extends HttpServlet {


    private IMagazineService magazineService;

    public void init() {
        magazineService = new IMagazineServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        getAll(request,response);
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
        if (action2 == null) {
            action2 = "";
        }
        switch (action2) {
            case "addNewMagazine":
                newMagazine(request,response);
                break;
        }
        switch (action) {
            case "reload":
                getAll(request,response);
                break;
            case "create":
                sendToPageCreateMagazine(request,response);
                break;
        }
        getAll(request,response);

    }
    private void sendToPageCreateMagazine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/Magazine.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Magazine> magazineList = magazineService.getAll();
        request.setAttribute("listMagazine", magazineList);
        request.getRequestDispatcher("view/index.jsp").forward(request, response);
    }

    private void newMagazine(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String courseID = request.getParameter("Maz_ID");
        String subject = request.getParameter("Magazine_Title");
        String lecturerName = request.getParameter("Publisher");
        int credits = Integer.parseInt(request.getParameter("Price"));
        Magazine magazine = new Magazine(courseID,subject,lecturerName,credits);
        magazineService.newMagazine(magazine);
    }

}
