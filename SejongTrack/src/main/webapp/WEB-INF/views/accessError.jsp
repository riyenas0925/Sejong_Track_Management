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
    <section class="content-header">
        <h1>
            <c:out value="${msg}"/>
        </h1>
    </section>
    <br><br>
    <%-- Main content --%>
    <section class="content container-fluid">
        <div class="row" style="text-align: center;padding-top:10px;">
            <img src="../dist/img/warning.png" width="150px;">

            <h3>해당 페이지는 관리자만 접근할 수 있습니다.</h3>
            <br>
            <h5>관리자 권한은 하단 (-------)로 문의하실 수 있습니다.</h5>
        </div>
    </section>
    <%-- /.content --%>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>
</html>