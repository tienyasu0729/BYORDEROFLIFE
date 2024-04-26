package com.example.ungdungcaculator.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "caculatorServlet", value = "/caculator")
public class caculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        float result = 0.0f;
        char operator = request.getParameter("operator").charAt(0);
        switch (operator){
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                try{
                    result = firstOperand / secondOperand;
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
        }
        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("result", result);
        request.setAttribute("operator", operator);
        request.getRequestDispatcher("/user/result.jsp").forward(request,response);

    }
}
