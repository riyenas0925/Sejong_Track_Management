<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

    <%--가입 성공조건: 같은 id가 없어야함--%>
    <%
        if (request.getAttribute("IsJoin").equals("Yes"))
        {
    %>
    <h4>Join success!</h4>

    id : ${member.id} <br>
    email : ${member.email} <br>
    name : ${member.name} <br>
    password : ${member.password} <br>
    <%
    } else {
    %>
    <h4>Join Failed........</h4>
    이미 있는 멤버입니다.<br>
    <%}%>
    <a href="/">홈</a>


</html>
