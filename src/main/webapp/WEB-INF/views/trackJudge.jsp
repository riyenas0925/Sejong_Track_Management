<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head-color.jsp" %>
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

        ${classifySubjects}

        <!-- 선택한 트랙 -->
        <section class="content">
            <div id="test"></div>
            <br>
            <div id="test2"></div>
        </section>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

</body>

<script language="JavaScript">

    $(document).ready(function () {
        const params = getUrlParams();

        trackJudgeOne();
        trackJudgeAll();

        function trackJudgeOne(){
            $.ajax({
                url: "${path}/api/v1/trackJudge/one",
                type: "POST",
                data: {
                    "univId" : params.univId,
                    "trackId" : params.trackId,
                    "degreeId" : params.degreeId
                },
                dataType : "json",

                success : function(data){
                    console.log(data);
                    $("#test").html(JSON.stringify(data));
                },
            });
        }

        function trackJudgeAll(){
            $.ajax({
                url: "${path}/api/v1/trackJudge/all",
                type: "POST",
                data: {
                    "univId" : params.univId,
                    "trackId" : params.trackId,
                    "degreeId" : params.degreeId
                },
                dataType : "json",

                success : function(data){
                    console.log(data);
                    $("#test2").html(JSON.stringify(data));
                },
            });
        }

        function getUrlParams() {
            var params = {};
            window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) {
                params[key] = value;
            });
            return params;
        }
    });

</script>
</html>