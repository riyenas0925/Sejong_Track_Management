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

    <form action="/memberJoin" method="post">
        id : <input type="text" name="id" required><br>
        e-mail : <input type="text" name="email" required><br>
        name : <input type="text" name="name" required><br>
        password : <input type="text" name="password" required><br>
        *모두 입력하세요<br>
        <input type="submit" value="가입"> <input type="reset" value="취소">
    </form>

    <%-- /.content --%>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</html>