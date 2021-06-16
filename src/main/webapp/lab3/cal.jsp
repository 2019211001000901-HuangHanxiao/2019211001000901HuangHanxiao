<%--
  Created by IntelliJ IDEA.
  User: DeLL
  Date: 2021/6/15
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.sun.org.apache.xpath.internal.objects.XString" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
    </style>
    <script language="javascript">
        function isNumber(){
            var n1 = document.getElementById("firstValue").value;
            var n2 = document.getElementById("secondValue").value;
            if( n1 ) {
                if( isNaN( n1 ) ) {
                    alert('First value is not a Number');
                    return false;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
            if( n2 ) {
                if( isNaN( n2 ) ) {
                    alert('Second value is not a Number');
                    return false;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
            return true;
        }
        function isName(){
            var n1 = document.getElementById("name").value;
            if( n1 ) {
                if( !isNaN( n1 ) ) {
                    alert("Name is not valid");
                    return false;
                }
                else {
                    return true;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
        }
    </script>
</head>


<%
    Cookie[] cookies=request.getCookies();
    String firstValue="";
    String secondValue="";
    String result="";
    String name="";
    String length="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cLength")){
                length=cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                result=cookie.getValue();
            }
            if (cookie.getName().equals("cSecondValue")){
                secondValue=cookie.getValue();
            }
            if (cookie.getName().equals("cFirstValue")){
                firstValue=cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                name=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>
<body>
<form action="cal" method="post">
    <table>
        <tr>
            <td>
                First val:<input type="text" name="firstValue" id="firstValue" autocomplete="off" value="<%=firstValue%>">
            </td>
            <td>
                Enter a name:<input type="text" name="name" id="name" autocomplete="off" value="<%=name%>"/>
            </td>
        </tr>

        <tr>
            <td>
                Second val:<input type="text" name="secondValue" id="secondValue" autocomplete="off" value="<%=secondValue%>"/>
            </td>
            <td>
                Length:<input type="text" name="length" id="length" autocomplete="off" value="<%=length%>"/>
            </td>
        </tr>
        <tr>
            <td>
                Result:<input name="result" type="text" id="result" autocomplete="off" value="<%=result%>"/>
            </td>

        </tr>
    </table>
    <input type="submit" name="add" id="1" value="Add" onclick="return isNumber()"/>
    <input type="submit" name="subtract" id="2" value="Subtract" onclick="return isNumber()"/>
    <input type="submit" name="multiply" id="3" value="Multiply" onclick="return isNumber()"/>
    <input type="submit" name="divide" id="4" value="Divide" onclick="return isNumber()"/>
    <input type="submit" name="computerLength" id="5" value="Computer Length" onclick="return isName()"/>
    <input type="reset" value="Reset" id="6" /><br><br>
</form>
</body>
</html>
