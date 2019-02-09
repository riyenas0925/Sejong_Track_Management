<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

<body class="hold-transition skin-black sidebar-mini">
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
                트랙 규칙 추가 및 수정
                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Admin</a></li>
                <li class="active">Track CRUD</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">트랙 규칙</h3>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style='text-align:center'>번호</th>
                                    <th style='text-align:center'>대학</th>
                                    <th style='text-align:center'>트랙</th>
                                    <th style='text-align:center'>기초교과</th>
                                    <th style='text-align:center'>응용교과, 심화교과</th>
                                    <th style='text-align:center'>산학연계</th>
                                    <th style='text-align:center' colspan="2"><button type="button" class="btn btn-block btn-success" data-toggle="modal" data-target="#modal-default">
                                        추가
                                    </button></th>
                                </tr>
                                </thead>

                                <tbody id="rules">

                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modal-default">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">트랙 규칙 추가</h4>
                        </div>
                        <div class="modal-body">
                            <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th style='text-align:center'>소속 대학</th>
                                    <th style='text-align:center'>트랙</th>
                                    <th style='text-align:center'>기초교과</th>
                                    <th style='text-align:center'>응용교과</th>
                                    <th style='text-align:center'>산학연계</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <!--
                                    <td>
                                        <select name="serachType" class="form-control">
                                            <option value="a"<c:out value="${cri.searchType == 'a'? 'selected':''}"/>>----</option>
                                            <option value="b"<c:out value="${cri.searchType eq 'b'? 'selected':''}"/>>소프트웨어융합대학</option>
                                            <option value="c"<c:out value="${cri.searchType eq 'c'? 'selected':''}"/>>무인기융합트랙</option>
                                        </select>
                                    </td>

                                    <td>
                                        <select name="serachType" class="form-control">
                                            <option value="a"<c:out value="${cri.searchType == 'a'? 'selected':''}"/>>----</option>
                                            <option value="b"<c:out value="${cri.searchType eq 'b'? 'selected':''}"/>>무인기 시스템</option
                                            <option value="c"<c:out value="${cri.searchType eq 'c'? 'selected':''}"/>>무인기 소프트웨어</option>
                                        </select>
                                    </td>

                                    -->
                                    <td><input type="text" class="form-control" id="univTitle"></td>
                                    <td><input type="text" class="form-control" id="trackTitle"></td>
                                    <td><input type="text" class="form-control" id="basic"></td>
                                    <td><input type="text" class="form-control" id="applied"></td>
                                    <td><input type="text" class="form-control" id="industry"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="registRule">Save changes</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
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

    $(document).ready(function () {

        getAllList();

        $("#registRule").on("click", function () {

            var univTitle = $("#univTitle").val();
            var trackTitle = $("#trackTitle").val();
            var basic = $("#basic").val();
            var applied = $("#applied").val();
            var industry = $("#industry").val();

            $.ajax({
                type: "post",
                url: "ruleAjax/register",
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "POST"
                },
                dataType: "text",
                data: JSON.stringify({
                   univ : univTitle,
                   track : trackTitle,
                   basic : basic,
                   applied : applied,
                   industry : industry
                }),
                success: function (result) {
                    if (result == "SUCCESS") {
                        $('#modal-default').modal('hide');
                        getAllList();
                    }
                }
            });
        });

        function getAllList() {
            $.getJSON("ruleAjax/list", function (data) {
                var str = "";
                console.log(data.length);

                $(data).each(
                    function () {
                        str += "<tr class='ruleID'" + " data-rno='" + this.ruleNo + "'>"
                                + "<td style='text-align:center'>"+ this.ruleNo + "</td>"
                                + "<td style='text-align:center'>"+ this.univ + "</td>"
                                + "<td style='text-align:center'>"+ this.track + "</td>"
                                + "<td style='text-align:center'>"+ this.basic + "</td>"
                                + "<td style='text-align:center'>"+ this.applied + "</td>"
                                + "<td style='text-align:center'>"+ this.industry + "</td>"
                                + "<td style='text-align:center'>"+ "<button id='updateRule' type='button'" + " class='btn btn-block btn-warning' data-toggle='modal' data-target='#modal-update'>" + "수정" + "</button></td>"
                                + "<td style='text-align:center'>"+ "<button id='deleteRule' type='button'" + " class='btn btn-block btn-danger'>" + "삭제" + "</button></td>"
                            + "</tr>";
                        });

                $("#rules").html(str);
            });
        }

        $("#rules").on("click", ".ruleID #deleteRule",function () {

            var rule = $(this).parent().parent();
            var ruleNo = rule.attr("data-rno");

            $.ajax({
                type: "delete",
                url: "ruleAjax/remove/" + ruleNo,
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "DELETE"
                },
                dataType: "text",
                success: function (result) {
                    console.log("result : " + result);
                    if (result == "SUCCESS") {
                        getAllList();
                    }
                }
            });
        });
    });
</script>

</html>