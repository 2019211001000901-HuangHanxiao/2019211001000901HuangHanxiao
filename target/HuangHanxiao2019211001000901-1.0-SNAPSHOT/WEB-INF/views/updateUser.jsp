<%--
  Created by IntelliJ IDEA.
  User: DeLL
  Date: 2021/4/24
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>


<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"><br/>
    password<input type="password" name="password" value="<%=u.getPassword()%>"><br/>
    Email<input type="text" name="email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="sex" value="male" <%="male".equals(u.getSex()) ?"checked":""%>>Male
            <input type="radio" name="sex" value="female" <%="female".equals(u.getSex()) ?"checked":""%>>Female<br/>
    Date of Birth<input type="text" name="birthdate" value="<%=u.getBirthdate()%>"><br/>
    <input type="submit" value="Save Changes" />
</form>
<%@include file="footer.jsp"%>
