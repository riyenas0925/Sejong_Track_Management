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
            세종대학교 트랙 현황
            <small>Sejong univ Track</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i>SejongTrack</a></li>
            <li class="active">트랙 현황</li>
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
                            <select id="select_univ" class="form-control">
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
                        <h2 id="univ_title" class="box-title">

                        </h2>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="track_tbl">

                            </table>
                        </div>
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
    $(document).ready(function () {

        selectService.univ();
        trackAllList(1);

        function trackAllList(selectUniv) {
            $.getJSON("trackAll/" + selectUniv, function (data) {

                var univ_title= $('#select_univ option:selected').html();
                var str = "";
                var cnt=1;

                $("#univ_title").html(univ_title);

                str += "<thead>"
                    + "<tr>"
                    + "<th style='width:50px;'>번호</th>"
                    + "<th style='width:200px;'>트랙 이름</th>"
                    + "<th>기초 교과</th>"
                    + "<th>응용 교과</th>"
                    + "<th>심화 교과</th>"
                    + "<th>산학 연계 교과</th>"
                    + "</tr>"
                    + "</thead>";

                $(data).each(
                    function () {
                        str += "<tbody>"
                            + "<tr>"
                            + "<td style='vertical-align: middle;'>"+ cnt + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackTitle + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackBasic + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackApplied + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackExpert + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackIndustry + "</td>"
                            + "</tr>"
                            + "</tbody>";

                        cnt++;
                    });

                $("#track_tbl").html(str);
                deleteEmptyCell();
            });
        }

        function deleteEmptyCell() {
            $('#track_tbl').each(function (a, tbl) {
                var currentTableRows = $(this).find("tr").length - 1;
                $(tbl).find('th').each(function (i) {
                    var removeVal = 0;
                    var currentTable = $(this).parents('#track_tbl');

                    var tds = currentTable.find('tr td:nth-child(' + (i + 1) + ')');
                    tds.each(function () {
                        if ($(this).text().trim() == 'null') removeVal++;
                    });

                    if (removeVal == currentTableRows) {
                        $(this).hide();
                        tds.hide();
                    }
                });
            });
        }

        $('#select_univ').on('change', function() {
            var selectUniv = this.value;
            trackAllList(selectUniv);
        });
    });
</script>