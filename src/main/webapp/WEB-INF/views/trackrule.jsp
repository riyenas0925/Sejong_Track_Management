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
            트랙 규칙 관리
            <small>Track Rule Management</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i>Admin</a></li>
            <li class="active">Track Rule</li>
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
                            <select class="form-control" id="select_univ">
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
                                <th style='text-align:center'>학위</th>
                                <th style='text-align:center'>기초교과</th>
                                <th style='text-align:center'>응용교과</th>
                                <th style='text-align:center'>심화교과</th>
                                <th style='text-align:center'>산학연계</th>
                                <th style='text-align:center' colspan="2">
                                    <button id="regist_rule_btn" type="button" class="btn btn-block btn-xs btn-success"
                                            data-toggle="modal" data-target="#modal">
                                        <i class="glyphicon glyphicon-pencil">추가</i>
                                    </button>
                                </th>
                            </tr>
                            </thead>

                            <tbody id="rule_list">

                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- modal -->
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header" id="">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">트랙 규칙 관리</h4>

                    </div>
                    <div class="modal-body">
                        <form>
                            <label for="univ" class="col-form-label"><b>대학</b></label>
                            <input type="text" class="form-control" id="univ" value="" disabled>
                            <br>

                            <div class="row">
                                <div class="col-md-6">
                                    <label for="track" class="col-form-label"><b>트랙</b></label>
                                    <div class="form-group" id="track">
                                        <select class="form-control" id="select_track">
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <label for="degree" class="col-form-label"><b>학위</b></label>
                                    <div class="form-group" id="degree">
                                        <select class="form-control" id="select_degree">
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <label for="credit-regist" class="col-form-label"><b>학점</b></label>
                            <div class="container" id="credit-regist">
                                <div class="row">
                                    <div class="col-sm-2">
                                        기초교과<br>
                                        <input type="number" class="form-control" placeholder="학점" min="0"
                                               id="basic_credit">
                                    </div>
                                    <div class="col-sm-2">
                                        응용교과<br>
                                        <input type="number" class="form-control" placeholder="학점" min="0"
                                               id="applied_credit">
                                    </div>
                                    <div class="col-sm-2">
                                        심화교과<br>
                                        <input type="number" class="form-control" placeholder="학점" min="0"
                                               id="expert_credit">
                                    </div>
                                    <div class="col-sm-2">
                                        산학연계<br>
                                        <input type="number" class="form-control" placeholder="학점" min="0"
                                               id="industry_credit">
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                        <button type="button" data-sub="submit" class="btn btn-primary" id="update_rule">수정</button>
                        <button type="button" data-sub="submit" class="btn btn-primary" id="delete_rule">삭제</button>
                        <button type="button" data-sub="submit" class="btn btn-primary" id="regist_rule">추가</button>
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
<script src="/track_js/rule.js"></script>

</body>

<script language="JavaScript">
    $(document).ready(function () {

        selectService.univ();
        getSearchList(1);

        $('#select_univ').on('change', function () {
            var univId = $('#select_univ').val();
            getSearchList(univId);
        });

        /* Track rule List */
        function getSearchList(univId) {

            ruleService.list(univId, function (data) {

                var str = "";

                $(data).each(
                    function () {
                        str += "<tr class='rule_id'" + " data-rno='" + this.ruleId + "'>"
                            + "<td style='text-align:center'>" + this.ruleId + "</td>"
                            + "<td style='text-align:center'>" + this.univTitle + " (" + this.univNo + ")" + "</td>"
                            + "<td style='text-align:center'>" + this.trackTitle + " (" + this.trackNo + ")" + "</td>"
                            + "<td style='text-align:center'>" + this.degreeTitle + "</td>"
                            + "<td style='text-align:center'>" + this.basicCredit + "</td>"
                            + "<td style='text-align:center'>" + this.appliedCredit + "</td>"
                            + "<td style='text-align:center'>" + this.expertCredit + "</td>"
                            + "<td style='text-align:center'>" + this.industryCredit + "</td>"
                            + "<td style='text-align:center; display:none;'>" + this.trackId + "</td>"
                            + "<td style='text-align:center; display:none;'>" + this.degreeId + "</td>"
                            + "<td style='text-align:center'>"
                            + "<button id='update_rule_btn' type='button' class='btn btn-xs btn-block btn-warning' data-toggle='modal' data-target='#modal'>"
                            + '<i class="glyphicon glyphicon-repeat">수정</i></button></td>'
                            + "<td style='text-align:center'>"
                            + "<button id='delete_rule_btn' type='button' class='btn btn-xs btn-block btn-danger' data-toggle='modal' data-target='#modal'>"
                            + '<i class="glyphicon glyphicon-trash">삭제</i></button></td>'
                            + "</tr>";
                    });

                $("#rule_list").html(str);
            });
        }

        /*************************************************************** Track Clean up 작업 완성 *****************************************************************************************/

        var modal = $(".modal");

        /* Track rule create */
        $("#regist_rule_btn").on("click", function () {
            var univId = $('#select_univ').val();
            var univTitle = $("#select_univ option:selected").text();

            modal.find("button").show();
            modal.find("button[id != 'regist_rule'][data-sub = 'submit']").hide();

            $("#univ").val(univTitle);

            selectService.track(univId);
            selectService.degree();
            ruleService.creditDisable(false);
        });

        $('#regist_rule').on('click', function () {
            var modalAttr = ruleService.modalAttr();

            ruleService.create(modalAttr, function (result) {
                if (result == "SUCCESS") {
                    $('#modal').modal('hide');
                    toastr["success"]("새로운 규칙이 추가되었습니다.");
                    getSearchList();
                }
            }, function (err) {
                console.log("Error........." + err);
            });
        })

        /* Track rule update*/
        $("#rule_list").on("click", ".rule_id #update_rule_btn", function () {
            var rule = ruleService.attribute($(this));
            var univId = $('#select_univ').val();

            modal.find("button").show();
            modal.find("button[id != 'update_rule'][data-sub = 'submit']").hide();

            selectService.track(univId);
            selectService.degree();

            $("#track_list option:eq(2)").attr("selected", "selected");

            $("#univ").val(rule.univTitle);
            $(".modal-header").attr('id', rule.ruleId);

            ruleService.creditDisable(false, rule.basicCredit, rule.appliedCredit, rule.industryCredit);
        });

        $('#update_rule').on('click', function () {
            var modalAttr = ruleService.modalAttr();

            ruleService.update(modalAttr, function (result) {
                if (result == "SUCCESS") {
                    $('#modal').modal('hide');
                    toastr["error"]("규칙이 수정되었습니다.");
                    getSearchList();
                }
            }, function (err) {
                console.log("Error........." + err);
            });
        });

        /* Track rule delete*/
        $("#rule_list").on("click", ".rule_id #delete_rule_btn", function () {
            var rule = ruleService.attribute($(this));

            modal.find("button").show();
            modal.find("button[id != 'delete_rule'][data-sub = 'submit']").hide();

            selectService.track(1);
            selectService.degree();

            $("#univ").val(rule.univTitle);
            $(".modal-header").attr('id', rule.ruleId);

            ruleService.creditDisable(true, rule.basicCredit, rule.appliedCredit, rule.industryCredit);
        });

        $('#delete_rule').on('click', function () {
            var ruleId = $(".modal-header").attr('id');

            ruleService.remove(ruleId, function (result) {
                if (result == "SUCCESS") {
                    $('#modal').modal('hide');
                    toastr["error"]("규칙이 삭제되었습니다.");
                    getSearchList();
                }
            }, function (err) {
                console.log("Error........." + err);
            });
        });
    });
</script>

<style>
    .col-sm-2 {
        padding-right: 15px;
        padding-left: 0px;
    }
</style>

</html>