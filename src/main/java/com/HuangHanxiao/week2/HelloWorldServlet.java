package com.HuangHanxiao.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name:Huang Hanxiao");
        writer.println("ID:2019211001000901");
        Date d = new Date();
        String s = null;
        writer.println("Date and Time " +d);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
    }
}
