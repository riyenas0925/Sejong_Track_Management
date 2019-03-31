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
                        <h2 class="box-title" id="univ">대학을 선택하세요</h2>
                    </div>

                    <div class="box-body">
                        <div class="form-group">
                            <select id="selectUniv" class="form-control">
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12">
                <div class="box">
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
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>
</html>

<script language="JavaScript">
    $(document).ready(function () { //이거는 필수 ㅇㅇ

        getUnivList();  //select리스트 처음 로딩때 불러오기
        trackTbl(1);    //change기 때문에 처음 선택된 소프트웨어융합대학 한번 불러줘야함

        $('#selectUniv').on('change', function() {
            var selectUniv = this.value;    //selectUniv 리스트에서 value값 뽑아내기
            trackTbl(selectUniv)             //트랙 리스트 출력
        });
        
        function getUnivList() {
            $.getJSON("uploadAjax/univList", function (data) {  //localhost:8080/uploadAjax/univList 주소 들어가보면 json 형태로 출력됨
                                                                 //uploadFormAjaxController 보면됨
                var str = "";

                $(data).each(   //for문
                    function () {
                        str += "<option value='" + this.univNo + "'>" + this.univTitle + "</option>"
                    });

                $("#selectUniv").html(str);
                //자바스크립트에서 innerHTML같은거
            });
        }

    function trackTbl(selectUniv) {
            $.getJSON("trackAll/selectUniv/" + selectUniv, function (data) {
                //localhost:8080/trackAll/selectuniv/1 주소로 들어가보면 json으로 출력됨
                //TrackAllAjaxController 보면 확인 가능

                var str = "";

                str += "<thead>"
                        +"<tr>"
                            +"<th>번호</th>"
                            +"<th>트랙 이름</th>"
                            +"<th>기초 교과</th>"
                            +"<th>응용 교과</th>"
                            +"<th>산학 연계</th>"
                        +"</tr>"
                    +"</thead>";

                $(data).each(
                    function () {
                        str += "<tbody>"
                                + "<tr>"
                                    + "<td style='text-align:center'>"+ this.trackNo + "</td>"
                                    + "<td>"+ this.trackTitle + "</td>"
                                    + "<td>"+ this.trackBasic + "</td>"
                                    + "<td>"+ this.trackApplied + "</td>"
                                    + "<td>"+ this.trackIndustry + "</td>"
                                + "</tr>"
                            + "</tbody>";
                    });

                $("#trackTbl").html(str);
            });
        }
    });
</script>