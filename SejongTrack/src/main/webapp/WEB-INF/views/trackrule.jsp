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
                            <h3 class="box-title">트랙 규칙</h3>
                        </div>

                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#추가">
                            추가
                        </button>

                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#수정">
                            수정
                        </button>

                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#삭제">
                            삭제
                        </button>

                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style='text-align:center'>#</th>
                                    <th style='text-align:center'>대학</th>
                                    <th style='text-align:center'>트랙</th>
                                    <th style="text-align: center">규칙</th>
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


            <!-- 추가 -->
            <div class="modal fade" id="추가" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">추가</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <label for="univ" class="col-form-label"><b>대학</b></label>
                                <!-- select -->
                                <div class="form-group" id="univ">
                                    <select class="form-control">
                                        <option selected>대학 선택</option>
                                        <option value="1">소프트웨어융합대학</option>
                                        <option value="2">무인기융합대학원</option>
                                    </select>
                                </div>
                                <br>

                                <label for="track" class="col-form-label"><b>트랙</b></label>
                                <input type="text" class="form-control" id="track" placeholder="트랙 명">
                                <br>


                                <label for="division" class="col-form-label"><b>구분</b></label><br>
                                <div class="btn-group btn-group-toggle" data-toggle="buttons" id="division">
                                    <label class="btn btn-outline-dark active">
                                        <input type="radio" name="구분" id="학사" autocomplete="off" checked> 학사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="석사" autocomplete="off"> 석사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="박사" autocomplete="off"> 박사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="석박사통합" autocomplete="off"> 석박사통합
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="산업석박사" autocomplete="off"> 산업석박사
                                    </label>
                                </div>
                                <br><br>

                                <label for="credit" class="col-form-label"><b>학점</b></label>

                                <div class="container" id="credit">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            기초교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0">

                                        </div>
                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0">
                                        </div>
                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-primary">추가</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 수정 -->
            <div class="modal fade" id="수정" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">수정</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <label for="univ" class="col-form-label"><b>대학</b></label>
                                <!-- select -->
                                <div class="form-group" id="univ">
                                    <select class="form-control" disabled>
                                        <option>대학 선택</option>
                                        <option value="1" selected>소프트웨어융합대학</option>
                                        <option value="2">무인기융합대학원</option>
                                    </select>
                                </div>

                                <label for="track" class="col-form-label"><b>트랙</b></label>
                                <input type="text" class="form-control" id="track" value="소프트웨어융합대학">
                                <br>


                                <label for="division" class="col-form-label"><b>구분</b></label><br>
                                <div class="btn-group btn-group-toggle" data-toggle="buttons" id="division">
                                    <label class="btn btn-outline-dark active">
                                        <input type="radio" name="구분" id="학사" autocomplete="off"> 학사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="석사" autocomplete="off"> 석사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="박사" autocomplete="off"> 박사
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="석박사통합" autocomplete="off"> 석박사통합
                                    </label>
                                    <label class="btn btn-outline-dark">
                                        <input type="radio" name="구분" id="산업석박사" autocomplete="off"> 산업석박사
                                    </label>
                                </div>
                                <br><br>

                                <label for="credit" class="col-form-label"><b>학점</b></label>

                                <div class="container" id="credit">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            기초교과<br>
                                            <input type="number" class="form-control" min="0" value="18">

                                        </div>
                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input type="number" class="form-control" min="0" value="18">
                                        </div>
                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input type="number" class="form-control" min="0" value="0">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-primary">수정</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 삭제 -->
            <div class="modal fade" id="삭제" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">삭제</h3>
                        </div>
                        <div class="modal-body">
                            <form>
                                <!-- select -->
                                <div class="form-group" id="univ">
                                    <select class="form-control" disabled>
                                        <option>대학 선택</option>
                                        <option value="1" selected>소프트웨어융합대학</option>
                                        <option value="2">무인기융합대학원</option>
                                    </select>
                                </div>
                                <br>

                                <label for="track" class="col-form-label"><b>트랙</b></label>
                                <!---예시 value---->
                                <input type="text" class="form-control" id="track" value="사물인터넷" readonly>
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
                                            <input type="number" class="form-control" placeholder="학점" min="0" readonly value="18">

                                        </div>
                                        <div class="col-sm-2">
                                            응용교과<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" readonly value="18">
                                        </div>
                                        <div class="col-sm-2">
                                            산학연계<br>
                                            <input type="number" class="form-control" placeholder="학점" min="0" readonly value="0">
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="트랙을 삭제합니다">
                                삭제
                            </button>
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

        getAllList();

        $("#registRule").on("click", function () {
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
                        $('#modal-default').modal('hide');
                        getAllList();
                    }
                }
            });
        });

        $("#rules").on("click", ".ruleID #updateRule",function () {

            var rule = $(this).parent().parent();
            var ruleNo = rule.attr("data-rno");

            alert(ruleNo);

            var trackId = 1;
            var basic = 9999;
            var applied = 9999;
            var industry = 9999;

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
                        $('#modal-default').hide("slow");
                        getAllList();
                    }
                }
            });
        });

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

        function getAllList() {
            $.getJSON("ruleAjax/list", function (data) {
                var str = "";

                $(data).each(
                    function () {
                        str += "<tr class='ruleID'" + " data-rno='" + this.ruleNo + "'>"
                            + "<td style='text-align:center'>"+ this.ruleNo + "</td>"
                            + "<td style='text-align:center'>"+ this.univTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.trackTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.ruleTitle + "</td>"
                            + "<td style='text-align:center'>"+ this.basic + "</td>"
                            + "<td style='text-align:center'>"+ this.applied + "</td>"
                            + "<td style='text-align:center'>"+ this.industry + "</td>"
                            + "<td style='text-align:center'>"+ "<button id='updateRule' type='button'" + " class='btn btn-block btn-warning'>" + "수정" + "</button></td>"
                            + "<td style='text-align:center'>"+ "<button id='deleteRule' type='button'" + " class='btn btn-block btn-danger'>" + "삭제" + "</button></td>"
                            + "</tr>";
                    });

                $("#rules").html(str);
            });
        }
    });
</script>

</html>