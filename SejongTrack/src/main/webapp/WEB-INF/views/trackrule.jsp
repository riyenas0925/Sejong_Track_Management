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
                            <h2 class="box-title">대학을 선택하세요</h2>
                        </div>

                        <div class="box-body">
                            <div class="form-group">
                                <select class="form-control selectUniv" id="searchUniv">
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
                            <h3 class="box-title">트랙 규칙</h3>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style='text-align:center'>#</th>
                                    <th style='text-align:center'>대학</th>
                                    <th style='text-align:center'>트랙</th>
                                    <th style="text-align: center;">학위</th>
                                    <th style='text-align:center'>기초교과</th>
                                    <th style='text-align:center'>응용, 심화교과</th>
                                    <th style='text-align:center'>산학연계</th>
                                    <th style='text-align:center' colspan="2">
                                        <button id="registRuleBtn" type="button" class="btn btn-block btn-xs btn-success" data-toggle="modal" data-target="#modalRegist"> 추가</button>
                                    </th>
                                </tr>
                                </thead>

                                <tbody id="rules">

                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 추가 -->
            <div class="modal fade" id="modalRegist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">추가</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <label for="univ-regist" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="univ-regist" value="" readonly>
                                <br>

                                <label for="track" class="col-form-label"><b>트랙</b></label>
                                <div class="form-group" id="track">
                                    <select class="form-control" id="selectTrack">
                                    </select>
                                </div>

                                <label for="credit" class="col-form-label"><b>학점</b></label>

                                <div class="container" id="credit-regist">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            기초교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="basic">
                                        </div>
                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="applied">
                                        </div>
                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="industry">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-primary" id="registRule">추가</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 수정 -->
            <div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">수정</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <label for="univ-update" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="univ-update" value="" readonly>
                                <br>

                                <label for="track-update" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="track-update" value="" readonly>
                                <br>

                                <label for="credit-update" class="col-form-label"><b>학점</b></label>

                                <div class="container" id="credit-update">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            기초교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="basic-update">
                                        </div>
                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="applied-update">
                                        </div>
                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" id="industry-update">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                            <button id="updateRuleBtn" type="button" class="btn btn-primary">수정</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 삭제 -->
            <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title" id="">삭제</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <label for="univ_delete" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="univ_delete" value="" readonly>
                                <br>

                                <label for="track" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="track_delete" value="" readonly>
                                <br>


                                <label for="division" class="col-form-label"><b>구분</b></label><br>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="division" value="학사" readonly>
                                <br>

                                <label for="credit" class="col-form-label"><b>학점</b></label>

                                <div class="container" id="credit">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            기초교과<br>
                                            <input id="basic-delete" type="number" class="form-control" placeholder="학점" min="0" readonly value="">
                                        </div>

                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input id="applied-delete" type="number" class="form-control" placeholder="학점" min="0" readonly value="">
                                        </div>

                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input id="industry-delete" type="number" class="form-control" placeholder="학점" min="0" readonly value="">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
                            <button id="deleteRuleBtn" type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="트랙을 삭제합니다">삭제</button>
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
    $(document).ready(function () {

        getSearchList(1);
        getUnivList();
        getTrackList(1);

        function getSearchList(univNo) {
            $.getJSON("ruleAjax/list/" + univNo, function (data) {
                var str = "";

                $(data).each(
                    function () {
                        str += "<tr class='ruleID'" + " data-rno='" + this.ruleNo + "'>"
                            + "<td style='text-align:center'>"+ this.ruleNo + "</td>"
                            + "<td style='text-align:center'>"+ this.univTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.trackTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.degreeTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.basic + "</td>"
                            + "<td style='text-align:center'>"+ this.applied + "</td>"
                            + "<td style='text-align:center'>"+ this.industry + "</td>"
                            + "<td style='text-align:center'>"+ "<button id='updateRule' type='button'" + " class='btn btn-xs btn-block btn-warning' data-toggle='modal' data-target='#modalUpdate'>" + '<i class="glyphicon glyphicon-trash"></i>' + " 수정" + "</button></td>"
                            + "<td style='text-align:center'>"+ "<button id='deleteRule' type='button'" + " class='btn btn-xs btn-block btn-danger' data-toggle='modal' data-target='#modalDelete'>" + '<span class="glyphicon glyphicon-zoom-out"></span>' + " 삭제" + "</button></td>"
                            + "</tr>";
                    });

                $("#rules").html(str);
            });
        }

        <!-- Track, Univ 조회 기능 -->
        $('.selectUniv').on('change', function() {
            var selectUniv = this.value;
            getTrackList(selectUniv)

            var univNo = $('#searchUniv').val();
            getSearchList(univNo);
        });

        function getUnivList() {
            $.getJSON("uploadAjax/univList", function (data) {  //localhost:8080/uploadAjax/univList 주소 들어가보면 json 형태로 출력됨
                var str = "";

                $(data).each(
                    function () {
                        str += "<option value='" + this.univNo + "'>" + this.univTitle + "</option>"
                    });

                $(".selectUniv").html(str);
            });
        }

        function getTrackList(selectUniv) {
            $.getJSON("uploadAjax/selectUniv/" + selectUniv, function (data) {
                var str = "";

                $(data).each(
                    function () {
                        str += "<option value='" + this.trackNo + "'>" + this.trackTitle + "</option>"
                    });

                $("#selectTrack").html(str);
            });
        }

        $("#registRuleBtn").on("click",function () {
            var univNo = $('#searchUniv').html();
            $('#univ-regist').attr('value', univNo);
        });

        $("#registRule").on("click", function () {
            var trackId = $('#selectTrack').val();
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
                    trackId : trackId,
                    basic : basic,
                    applied : applied,
                    industry : industry
                }),
                success: function (result) {
                    if (result == "SUCCESS") {
                        $('#modalRegist').modal('hide');
                        toastr["success"]("새로운 규칙이 추가되었습니다.");

                        var univNo = $('#searchUniv').val();
                        getSearchList(univNo);
                    }
                }
            });
        });

        $("#rules").on("click", ".ruleID #updateRule",function () {
            var rule = $(this).parent().parent();
            var ruleNo = rule.attr("data-rno");
            var td = rule.children();

            $('#univ-update').attr('value', td.eq(1).text());
            $('#track-update').attr('value', td.eq(2).text());
            $('.modal-title').attr('id', ruleNo);
        });

        $("#updateRuleBtn").on('click', function () {
            var ruleNo = $('.modal-title').attr('id');
            var trackId = $('#selectTrack').val();
            var basic = $("#basic-update").val();
            var applied = $("#applied-update").val();
            var industry = $("#industry-update").val();

            $.ajax({
                type: "put",
                url: "ruleAjax/update/" + ruleNo,
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "POST"
                },
                dataType: "text",
                data: JSON.stringify({
                    trackId : trackId,
                    basic : basic,
                    applied : applied,
                    industry : industry
                }),
                success: function (result) {
                    if (result == "SUCCESS") {
                        $('#modalUpdate').modal('hide');
                        toastr["warning"]("규칙이 수정되었습니다.");
                        var univNo = $('#searchUniv').val();
                        getSearchList(univNo);
                    }
                }
            });
        });

        $("#rules").on("click", ".ruleID #deleteRule",function () {
            var rule = $(this).parent().parent();
            var ruleNo = rule.attr("data-rno");
            var td = rule.children();

            $('#univ_delete').attr('value', td.eq(1).text());
            $('#track_delete').attr('value', td.eq(2).text());
            $('#basic-delete').attr('value', td.eq(4).text());
            $('#applied-delete').attr('value', td.eq(5).text());
            $('#industry-delete').attr('value', td.eq(6).text());

            $('.modal-title').attr('id', ruleNo);
        });

        $('#deleteRuleBtn').on('click', function () {
            var ruleNo = $('.modal-title').attr('id');

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
                        $('#modalDelete').modal('hide');
                        toastr["error"]("규칙이 삭제되었습니다.");
                        var univNo = $('#searchUniv').val();
                        getSearchList(univNo);
                    }
                }
            });
        })
    });
</script>

<style>
    .col-sm-2 {
        padding-right: 15px;
        padding-left: 0px;
    }
</style>

</html>