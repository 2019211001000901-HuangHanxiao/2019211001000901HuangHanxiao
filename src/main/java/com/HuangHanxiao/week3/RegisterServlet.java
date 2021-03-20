package com.HuangHanxiao.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Password=request.getParameter("Password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String date=request.getParameter("date");
        String register=request.getParameter("register");

        PrintWriter writer= response.getWriter();
        writer.println("<br>username: "+username);
        writer.println("<br>password: "+Password);
        writer.println("<br>email:  "+email);
        writer.println("<br>gender: "+sex);
        writer.println("<br>birth date: "+date);
        writer.close();
    }
}
