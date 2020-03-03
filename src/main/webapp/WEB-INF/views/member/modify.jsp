<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%@ include file="../include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="../include/sidebar.jsp" %>
<div class="main-content">
    <!--header -->
    <%@ include file="../include/header.jsp" %>
    <!-- Header -->
    <div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center"
         style="min-height: 600px; background-image: url(../resources/img/theme/sejongbg.png); background-size: cover; background-position: center top;">
        <!-- Mask -->
        <span class="mask bg-gradient-default opacity-8"></span>
        <!-- Header container -->
        <div class="container-fluid d-flex align-items-center">
            <div class="row">
                <div class="col-lg-7 col-md-10">
                    <h1 class="display-2 text-white">안녕하세요.<br><sec:authentication property="principal.name"/>님!</h1>
                    <p class="text-white mt-0 mb-5">This is your profile page. You can see the progress you've made with
                        your work and manage your projects or assigned tasks</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
                <div class="card card-profile shadow">
                    <div class="row justify-content-center">
                        <div class="col-lg-3 order-lg-2">
                            <div class="card-profile-image">

                                <img src="../resources/img/theme/student_y.png" class="rounded-circle">

                            </div>
                        </div>
                    </div>
                    <div class="card-body pt-0 pt-md-4">
                        <div class="text-center" style="margin-top:140px;">
                            <h3>
                                <sec:authentication property="principal.name"/><span class="font-weight-light"></span>
                            </h3>

                            <div class="h5 font-weight-300">
                                <i class="ni location_pin mr-2"></i>17010491
                            </div>

                            <div class="h5 mt-4">
                                <i class="ni business_briefcase-24 mr-2"></i>소프트웨어융합대학
                            </div>

                            <div>
                                <i class="ni education_hat mr-2"></i>컴퓨터공학과
                            </div>

                            <hr class="my-4"/>
                            <a href="${path}/uploadForm">트랙 현황 조회 바로가기</a><br>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-8 order-xl-1">
                <div class="card bg-secondary shadow">
                    <div class="card-header bg-white border-0">
                        <div class="row align-items-center">
                            <div class="col-8">
                                <h3 class="mb-0">My account</h3>
                            </div>
                            <div class="col-4 text-right" style="font-size:10px;">
                                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal"
                                        data-target="#passwordChange">비밀번호변경
                                </button>
                            </div>
                            <%@ include file="pwChange.jsp" %>
                        </div>
                    </div>
                    <div class="card-body">
                        <form id="joinForm" action="/modifyMemberInfo" method="post">
                            <div class="pl-lg-4">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="id">ID</label>
                                            <input type="text" name="id" id="id"
                                                   class="form-control form-control-alternative"
                                                   value="<sec:authentication property='principal.id'/>" readonly>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="name">이름</label>
                                            <input type="text" name="name" id="name"
                                                   class="form-control form-control-alternative"
                                                   value="<sec:authentication property='principal.name'/>">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="ex1">학과</label>
                                            <input type="text" id="ex1" class="form-control form-control-alternative"
                                                   placeholder="컴퓨터공학과" readonly>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="ex2">학번</label>
                                            <input type="number" id="ex2" class="form-control form-control-alternative"
                                                   placeholder="17010491" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="email">이메일</label>
                                            <input type="email" name="email" id="email"
                                                   class="form-control form-control-alternative"
                                                   value="<sec:authentication property='principal.email'/>">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label" for="ex">예시1</label>
                                            <input type="text" id="ex" class="form-control form-control-alternative"
                                                   placeholder="예시" readonly>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr class="my-4"/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label class="form-control-label" for="password">Please enter a password to
                                            modify the information.</label>
                                        <input type="password" id="password" name="password"
                                               class="form-control form-control-alternative" required
                                               placeholder="비밀번호 입력">
                                    </div>
                                </div>
                                <div class="col-lg-12" style="text-align:center">
                                    <div class="alert alert-danger" role="alert">
                                        <strong>Danger! </strong>정보 수정 후 재로그인 바랍니다.
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button type="submit" class="btn btn-primary my-4">Modify</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@ include file="../include/footer.jsp" %>
    </div>
</div>
</body>
</html>
<!-- Core -->
<script src="../resources/js/plugins/jquery/dist/jquery.min.js"></script>
<script src="../resources/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Optional JS -->
<!-- Argon JS -->
<script src="../resources/js/argon-dashboard.min.js?v=1.1.1"></script>
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        var pwRes = false;

        //비밀번호 재확인 체킹
        function pwCorrect() {

            $("input[name=newPw]").keyup(function () {
                if ($("input[name=newPw]").val() == $("input[name=newPwRe]").val()) {
                    $("#pwCheckRes").html("비밀번호가 일치합니다.");
                    pwRes = true;
                } else {
                    $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                    pwRes = false;
                }
            });

            $("input[name=newPwRe]").keyup(function () {
                if ($("input[name=newPw]").val() == $("input[name=newPwRe]").val()) {
                    $("#pwCheckRes").html("비밀번호가 일치합니다.");
                    pwRes = true;
                } else {
                    $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                    pwRes = false;
                }
            });
        }

        pwCorrect();

        function totalCheck() {
            return pwRes;
        }

        $('input[name=modifyBtn]').on('click', function () {

            if ($('input[name=password]').val() == "" || $('input[name=newPw]').val() == ""
                ||$('input[name=newPwRe]').val() == ""){
                toastr.warning('비밀번호를 입력해주세요');
            }
            else if (totalCheck() == false) {
                toastr.warning('재입력한 비밀번호를 다시 확인해주세요.');  // 비밀번호 재확인경고알림
            }
            else {

                var target = {
                    id: $('input[name=id]').val(),
                    password: $('input[name=password]').val(),
                    newPw: $('input[name=newPw]').val()
                };

                $.ajax({
                    url: "/api/v1/member/modifyPw",
                    type: "POST",
                    dataType: "text",
                    data: JSON.stringify(target),
                    contentType: 'application/json; charset=utf-8',
                    async: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
                    },
                    success: function (data) {
                        toastr.success("비밀번호가 변경되었습니다.");
                            window.location.href="/memberLogout";

                    },
                    error: function (request, status, error) {
                        toastr.warning(request.responseText);
                        console.log("code:" + request.status + "\n\n" + "reponseType:" + request.responseType + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
                    }
                });
            }
        });
    });
</script>

<!-- toastr js 라이브러리 -->
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
