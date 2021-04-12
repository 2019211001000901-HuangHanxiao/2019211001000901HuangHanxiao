package com.HuangHanxiao.week5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name="LoginServlet",value="/login")

public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {

        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();
        String sql="select * from usertable where username='"+username+"' and password='"+password+"'";
        try {
            ResultSet rst= con.createStatement().executeQuery(sql);
            if(rst.next()){
                //week5 code
                //out.println("Login Success!!!");
                //out.println("Welcome,"+username);
                request.setAttribute("id",+rst.getInt("id"));
                request.setAttribute("username",rst.getString("username"));
                request.setAttribute("password",rst.getString("password"));
                request.setAttribute("email",rst.getString("email"));
                request.setAttribute("sex",rst.getString("sex"));
                request.setAttribute("birthdate",rst.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else {
                //out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
