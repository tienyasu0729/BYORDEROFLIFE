package com.example.productdiscountcalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "caculationServlet", value = "/caculation")
public class caculationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("productDescription");
        int price = Integer.parseInt(request.getParameter("listPrice"));
        int percent = Integer.parseInt(request.getParameter("discountPercent"));
        int discountAmount = (int) (price * percent * 0.01);
        int discountPrice = price - discountAmount;
        String productDescription = request.getParameter("productDescription");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<p>Product description : " + productDescription+ "</p>");
        writer.println("<h3>Discount Amount: " + discountAmount + "</h3>");
        writer.println("<h3>Discount Price: " + discountPrice + "</h3>");
        writer.println("</html>");
    }
}
