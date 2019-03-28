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
                                <c:forEach items="${univName}" var="univName" >
                                    <option value="${univName.univNo}"> ${univName.univTitle} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h2 class="box-title" id="univ">대학을 선택하세요</h2>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover" id="trackTbl">
                            <!--여기임-->
                        </table>
                        <div id="test"></div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
    </section>
    <%-- /.content --%>
</div>

<script>
    var selectElem = document.getElementById('selectUniv');
    var univ = document.getElementById('univ');

    selectElem.addEventListener('change', function() {
        var index = selectElem.selectedIndex;

        if (index==0) {
            univ.innerHTML="대학을 선택하세요";
            document.getElementById('trackTbl').innerHTML=""; //테이블 초기화
        }

        else {
            <c:forEach items="${univName}" var="univName" >
                if (index==${univName.univNo}){
                    univ.innerHTML="${univName.univTitle} 트랙 조회";
                    trackTable(${univName.univNo});
                }
            </c:forEach>
        }
    })

    function trackTable(univNum){
        var table = document.getElementById('trackTbl');
        var str = "<tr style='text-align:center'><th>#</th><th>트랙 명</th><th>기초교과</th><th>응용교과</th></tr>";

        /*여기서 받은 univNum을 이용해야하는데... 할 줄 몰라서 일단 controller에서 1로넘겨줌요ㅠ
        if (univNum== 생략)
        */
        
        <c:forEach items="${trackName}" var="trackName">
            str+="<tr><td>${trackName.trackNo}</td><td>${trackName.trackTitle}</td>";
                <c:forEach items="${basicList}" var="basicList">
                    if(${trackName.trackNo}==${basicList.trackNo}){
                        str+="<td>${basicList.trackAll}</td>"
                    }
                </c:forEach>
                <c:forEach items="${appliedList}" var="appliedList">
                if(${trackName.trackNo}==${appliedList.trackNo}){
                    str+="<td>${appliedList.trackAll}</td>"
                }
                </c:forEach>
            str+="</tr>"
        </c:forEach>
        table.innerHTML=str;

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

<!--
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
-->