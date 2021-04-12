<%--
  Created by IntelliJ IDEA.
  User: DeLL
  Date: 2021/4/7
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td>
    </tr>
    <%
        ResultSet rs=(ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("sex") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");
            out.println("</tr>");
        }
    }
    %>
</table>
<%@include file="footer.jsp"%>
