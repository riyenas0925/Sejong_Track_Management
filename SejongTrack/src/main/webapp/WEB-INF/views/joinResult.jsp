<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

<%-- Main Header --%>
<%@ include file="include/main-header.jsp" %>

<%-- Left side column. contains the logo and sidebar --%>
<%@ include file="include/main-sidebar.jsp" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->

    <%--가입 성공조건: 같은 id가 없어야함--%>
    <%Object IsJoin = request.getAttribute("IsJoin");%>
    IsJoin : <%=IsJoin%><br>
    <%
        if (request.getAttribute("IsJoin").equals("Yes")) //가능?? .equals안에 int있음(?)
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
    <%-- /.content --%>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</html>
