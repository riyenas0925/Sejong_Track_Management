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
            세종대학교 전체 트랙
            <small>Sejong univ Track</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i>SejongTrack</a></li>
            <li class="active">전체 트랙</li>
        </ol>
    </section>

    <%-- Main content --%>
    <section class="content container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                    </div>

                    <div class="box-body">
                        <div class="form-group">
                            <select id="selectUniv" class="form-control">
                                <option value="">대학 선택</option>
                                <option>소프트웨어융합대학</option>
                                <option>항공우주대학원</option>
                                <!--
                                <c:forEach items="${univs}" var="univ" >
                                    <option value="${univ.univNo}"> ${univ.univTitle} </option>
                                </c:forEach>
                                -->
                            </select>
                            <button style="margin-top:15px;" id="result" type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="univ" style="text-align: center;font-size:20px;">
            대학을 선택하세요
        </div>

        <div>
            <ul>
            <c:forEach items="${trackAll}" var="trackAll">
                <li>${trackAll.trackNo}</li>
                <li>${trackAll.trackAll}</li>
            </c:forEach>
            </ul>
        </div>
    </section>
    <%-- /.content --%>
</div>
<script>

    // TODO: ajax 방식으로 변경
    var selectElem = document.getElementById('selectUniv');
    var univ = document.getElementById('univ');

    selectElem.addEventListener('change', function() {
        var index = selectElem.selectedIndex;

        if(index==0){
            univ.innerHTML="대학을 선택하세요.";
        }
        else if(index==1){
            univ.innerHTML="소프트웨어융합대학 전체 트랙";
        }
        else if(index==2){
            univ.innerHTML="항공우주대학원 전체 트랙";
        }
    })

    function getTrackList(selectUniv) {
        $.getJSON("trackAll/selectUniv/" + selectUniv, function (data) {
            var str = "";
            console.log(data.length);

            $(data).each(
                function () {
                    str += "<option value='" + this.trackNo + "'>" + this.trackTitle + "</option>"
                });

            $("#selectTrack").html(str);
        });
    }
</script>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>
</html>