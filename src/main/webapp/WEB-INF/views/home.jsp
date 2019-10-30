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
                트랙 관리 프로그램
                <small>Sejong univ Track</small>
            </h1>
        </section>
        <br><br>
        <%-- Main content --%>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-sm-6" style="text-align: center;">
                    <img src="../dist/img/home_img1.png" width="80%">
                </div>
                <div class="col-xs-1">
                </div>
                <div class="col-xs-11 col-sm-5" style="padding-top:80px; padding-bottom: 80px">
                    <p style="font-size:20px;"><b style="font-size:30px;">세종대학교<br>통합 트랙 관리 시스템</b><br><br></p>

                    <div class="row">
                        <div class="col-md-12" style="margin-bottom:20px;">
                            <a href="${path}/home"><button class="btn-hover color-1" id="home-btn1">공지사항</button></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${path}/trackAll"><button class="btn-hover color-3">트랙 통계</button></a>
                        </div>
                        <div class="col-md-12">
                            <a href="${path}/uploadForm"><button class="btn-hover color-4" id="home-btn2">전체 트랙</button></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${path}/uploadForm"><button class="btn-hover color-9">트랙 조회</button></a>
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