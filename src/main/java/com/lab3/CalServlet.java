package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/lab3/cal")
public class CalServlet extends HttpServlet {

    int add(int a,int b){
        return  a+b;
    }
    int subtract(int a,int b){
        return a-b;
    }
    int multiply (int a,int b){
        return a*b;
    }
    int divide(int a,int b) {
        return a/b;
    }
    int computeLength(String str) {
        return str.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("computerLength") != null){
            String str=request.getParameter("name").trim();
            int length=computeLength(str);
            Cookie cookie1=new Cookie("cName",str);
            Cookie cookie2=new Cookie("cLength",Integer.toString(length));
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            cookie1.setMaxAge(5);
            cookie2.setMaxAge(5);
        }else{
            String firstValue=request.getParameter("firstValue");
            String secondValue=request.getParameter("secondValue");
            int n1=Integer.valueOf(firstValue);
            int n2=Integer.valueOf(secondValue);
            int cResult=0;
            if(request.getParameter("add") != null){
                cResult=add(n1,n2);
            }else if(request.getParameter("subtract") != null){
                cResult=subtract(n1,n2);
            }else if(request.getParameter("multiply") != null){
                cResult=multiply(n1,n2);
            }else if(request.getParameter("divide") != null){

                cResult=divide(n1,n2);
            }
            Cookie cookie3=new Cookie("cFirstValue",Integer.toString(n1));
            Cookie cookie4=new Cookie("cSecondValue",Integer.toString(n2));
            Cookie cookie5=new Cookie("cResult",Integer.toString(cResult));
            response.addCookie(cookie3);
            response.addCookie(cookie4);
            response.addCookie(cookie5);
            cookie3.setMaxAge(5);
            cookie4.setMaxAge(5);
            cookie5.setMaxAge(5);
        }
        response.sendRedirect("/2019211001000901HuangHanxiao_war_exploded/lab3/cal.jsp");
    }
}
