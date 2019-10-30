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
                        <div id="univT">
                        </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="trackTbl">
                                <!--여기임-->
                            </table>
                            <div id="test"></div>
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
        //trackAllList(1);

        function trackAllList(selectUniv) {
            $.getJSON("trackAll/" + selectUniv, function (data) {
                var univT= $('#select_univ option:selected').html();
                var univStr= '<h2 class="box-title">'+univT+'</h2>';
                var str = "";
                var industry=1;
                var cnt=1;

                document.getElementById('univT').innerHTML=univStr;

                str += "<thead>"
                    +"<tr>"
                    +"<th style='width:50px;'>번호</th>"
                    +"<th style='width:200px;'>트랙 이름</th>"
                    +"<th>기초 교과</th>"
                    +"<th>응용 교과</th>";

                $(data).each(
                    function () {
                        if(this.trackIndustry==null){
                            industry=0;
                        }
                    }
                )

                if (industry==1){
                    str += "<th>산학 연계</th>";
                }

                str += "</tr>"
                    +"</thead>";

                $(data).each(
                    function () {
                        str += "<tbody>"
                            + "<tr>"
                            + "<td style='vertical-align: middle;'>"+ cnt + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackTitle + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackBasic + "</td>"
                            + "<td style='vertical-align: middle;'>"+ this.trackApplied + "</td>";

                        if (this.trackIndustry!=null){
                            str += "<td style='margin: 100px 0px;'>"+ this.trackIndustry + "</td>";
                        }

                        str += "</tr>"
                            + "</tbody>";

                        cnt++;
                    });

                $("#trackTbl").html(str);

            });
        }

        $('#select_univ').on('change', function() {
            var selectUniv = this.value;

            trackAllList(selectUniv);

        });
    });
</script>