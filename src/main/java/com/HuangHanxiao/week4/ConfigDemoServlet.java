package com.HuangHanxiao.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet(
       // urlPatterns = {"/config"},
        //initParams = {
               // @WebInitParam(name="name",value="Huang Hanxiao"),
               // @WebInitParam(name="studentid",value="2019211001000901"),
        //},loadOnStartup = 2
//)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =getServletConfig().getInitParameter("name");
        String id =getServletConfig().getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
