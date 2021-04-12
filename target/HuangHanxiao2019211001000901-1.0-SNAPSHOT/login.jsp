<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="/2019211001000901HuangHanxiao_war_exploded/login">
Username:<input style="width: 200px; height:30px" type="text" name="username" autocomplete="off"><br/><br/>
Password:<input style="width: 200px; height:30px" type="password" name="password"  minlength="8"><br/><br/>
<input style="width: 80px; height:30px" type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>