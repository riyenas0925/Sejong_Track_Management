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
        <section class="content-header">
            <h1>
                세종대학교 트랙 조회
                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Sejong Track</a></li>
                <li class="active">트랙 파일 첨부</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">기이수 성적 업로드</h3>
                        </div>

                        <div class="box-body">
                            <div class="form-group">
                                <select id="selectUniv" class="form-control">
                                    <option value="">소속대학 선택</option>
                                    <c:forEach items="${univs}" var="univ" >
                                        <option value="${univ.univNo}"> ${univ.univTitle} </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <select id="selectTrack" class="form-control">
                                    <option value="">트랙 선택</option>

                                </select>
                            </div>

                            <form id="form1" action="uploadForm" method="post" enctype="multipart/form-data">
                                <input type="file" name="file"> <input type="submit">
                            </form>
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

<script language="JavaScript">
    $(document).ready(function(){

        $('#selectUniv').on('change', function() {
            var selectUniv = this.value;
            getTrackList(selectUniv)
        });

        $('#form1').on('click', function () {
           var univ = $('#selectUniv').val();
           var track = $('#selectTrack').val();
        });

        function getTrackList(selectUniv) {
            $.getJSON("uploadAjax/selectUniv/" + selectUniv, function (data) {
                var str = "";
                console.log(data.length);

                $(data).each(
                    function () {
                        str += "<option value='" + this.trackNo + "'>" + this.trackTitle + "</option>"
                    });

                $("#selectTrack").html(str);
            });
        }
    });


</script>
</html>