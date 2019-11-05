<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

    <%-- Main Header --%>
    <%@ include file="include/main-header.jsp" %>

    <%-- Left side column. contains the logo and sidebar --%>
    <%@ include file="include/main-sidebar.jsp" %>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Error Page
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Dashboard</a></li>
                <li class="active">Home</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header">
                            <h3 class="box-title">
                                ${exceptionData.getMessage()}
                            </h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <c:forEach items="${exceptionData.getStackTrace()}" var="stack">
                                <li>${stack.toString()}</li>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col-->
            </div>
            <!-- ./row -->
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