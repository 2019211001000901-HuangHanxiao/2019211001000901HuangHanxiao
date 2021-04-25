package com.HuangHanxiao.controller;

import com.HuangHanxiao.dao.UserDao;
import com.HuangHanxiao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = null;
        try {
            System.out.println(request.getParameter("birthdate").trim());

            birthdate = simpleDateFormat.parse(request.getParameter("birthdate").trim());
        } catch (ParseException e) {
            System.out.println(e);
        }
        User u = new User(Integer.valueOf(id), username, password, email, sex, birthdate);
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser((Connection) getServletContext().getAttribute("con"), u);
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(birthdate);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
