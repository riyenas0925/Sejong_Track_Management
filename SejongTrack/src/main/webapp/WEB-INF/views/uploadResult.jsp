<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%-- Main Header --%>
    <%@ include file="include/main-header.jsp" %>

    <%-- Left side column. contains the logo and sidebar --%>
    <%@ include file="include/main-sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                트랙 현황 조회

                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Sejong Track</a></li>
                <li class="active">트랙 파일 첨부</li>
                <li class="active">트랙 현황 조회</li>
            </ol>
        </section>

        <section>
            <br>
            <div class="col-md-12">
                <div class="box box-solid">
                    <div class="box-header with-border">
                        <h3 class="box-title"><i class="fa fa-warning"></i>트랙 이수 조건</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>소속 대학</th>
                                <th>트랙 이름</th>
                                <th>기초 교과</th>
                                <th>응용 교과</th>
                                <th>산학 연계</th>
                            </tr>
                            </thead>

                            <tr>
                                <td><c:out value="${rule.univ}"/></td>
                                <td><c:out value="${rule.track}"/></td>
                                <td><c:out value="${rule.basic}"/></td>
                                <td><c:out value="${rule.applied}"/></td>
                                <td><c:out value="${rule.industry}"/></td>
                            </tr>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </section>

        <%-- Main content --%>
        <section class="content">
            <div class="row">
                <div class="col-xs-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">자신의 이수 과목</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>학수번호</th>
                                    <th>교과목명</th>
                                    <th>학점</th>
                                </tr>
                                </thead>

                                <c:forEach items="${plist}" var="subject">
                                    <tr>
                                        <td><c:out value="${subject.courseNum}"/></td>
                                        <td><c:out value="${subject.courseTitle}"/></td>
                                        <td><c:out value="${subject.credit}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">자신의 미이수 과목</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>학수번호</th>
                                    <th>교과목명</th>
                                    <th>학점</th>
                                </tr>
                                </thead>

                                <c:forEach items="${nplist}" var="subject">
                                    <tr>
                                        <td><c:out value="${subject.courseNum}"/></td>
                                        <td><c:out value="${subject.courseTitle}"/></td>
                                        <td><c:out value="${subject.credit}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
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