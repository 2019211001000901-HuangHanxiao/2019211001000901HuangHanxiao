<%--
  Created by IntelliJ IDEA.
  User: DeLL
  Date: 2021/3/31
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
This is my JSP page.<br><br>
    <form method="post" action="/2019211001000901HuangHanxiao_war_exploded/register">
        <table>
            <tr>
                <td width=250px><input style="width: 250px; height:30px;background-color:#FEFFEF;border:0" type="text" name="username" placeholder="Username" autocomplete="off"></td>
            </tr>
            <tr>
                <td><input style="width: 250px; height:30px;background-color:#FEFFEF;border:0" type="password" name="password" placeholder="password" minlength="8"></td>
            </tr>
            <tr>
                <td><input style="width: 250px; height:30px;background-color:#FEFFEF;border:0" type="email" name="email" placeholder="Email"></td>
            </tr>
            <tr>
                <td  style="width: 250px; height:30px">Gender:
                    <input  type="radio" name="sex" value="Male"  >Male
                    <input  type="radio" name="sex" value="Female" />Female</td>
            </tr>
            <tr>
                <td>
                    <input style="width: 250px; height:30px;background-color:#FEFFEF;border:0" type="date" name="birthdate" placeholder="Date of Birth(yyyy-mm-dd)">
                </td>
            </tr>
            <tr>
                <td>
                    <input style="color:azure;background-color: #EE9223;width: 120px; height:30px;border:0" type="submit" name="register" value="Register">
                </td>
            </tr>
        </table>
    </form>
<%@include file="footer.jsp"%>
