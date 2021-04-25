<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies= request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }

        }
    }
%>
<form method="post" action="/2019211001000901HuangHanxiao_war_exploded/login">
    Username: <input style="width: 200px; height:30px" type="text" name="username" autocomplete="off" value="<%=username%>"><br/><br/>
    Password: <input style="width: 200px; height:30px" type="password" name="password"  minlength="8"  value="<%=password%>" ><br/><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked />RememberMe<br/>
    <input style="width: 80px; height:30px" type="submit" name="login" value="login">
</form>
<%@ include file="footer.jsp"%>
