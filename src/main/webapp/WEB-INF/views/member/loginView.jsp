<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/setting-h.jsp" %>

<body class="bg-default" style="background-color:#172b4d">
<div class="main-content">
    <%@ include file="../include/member-header.jsp" %>

    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8">
        <div class="container">
            <div class="header-body text-center mb-7">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-6">
                        <h1 class="text-white">Sign in</h1>
                        <p class="text-lead text-light" style="margin-bottom:0px;">세종대학교 트랙 관리 프로그램</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="separator separator-bottom separator-skew zindex-100">
            <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
                <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
            </svg>
        </div>
    </div>

    <!-- Page content -->
    <div class="container mt--9 pb-4">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="card bg-secondary shadow border-0">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-center text-muted mb-4">
                            <small>Sign in to your account</small>
                        </div>
                        <form role="form" action = "/api/v1/member/login" id="form-login" method="post">
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-single-02"></i></span>
                                    </div>
                                    <input class="form-control" placeholder="ID" type="id" name="id" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                    </div>
                                    <input class="form-control" placeholder="PW" type="password" name="password" required>
                                </div>
                            </div>
                            <div class="custom-control custom-control-alternative custom-checkbox">
                                <input class="custom-control-input" id=" customCheckLogin" type="checkbox">
                                <label class="custom-control-label" for=" customCheckLogin">
                                    <span class="text-muted">Remember me</span>
                                </label>
                            </div>
                            <div class="text-center">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" name="signInBtn" class="btn btn-primary my-4">Sign in</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <a href="#" class="text-light"><small>비밀번호 찾기</small></a>
                    </div>
                    <div class="col-6 text-right">
                        <a href="${path}/joinView" class="text-light"><small>회원가입</small></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--   Core   -->
<script src="../resources/js/plugins/jquery/dist/jquery.min.js"></script>
<script src="../resources/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!--   Optional JS   -->
<!--   Argon JS   -->
<script src="../resources/js/argon-dashboard.min.js?v=1.1.1"></script>
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<script>
    $(document).ready(function () {
        //---------------test중(form옵션, 제출버튼 타입 고려)-------------------//
        <%--var target = {--%>
            <%--"id": $('input[name=id]').val(),--%>
            <%--"password":$('input[name=password]').val()--%>
        <%--};--%>

        <%--$('button[name=signInBtn]').on('click',function(){--%>
        <%--$.ajax({--%>
            <%--url: "/api/v1/member/login",--%>
            <%--type: "POST",--%>
            <%--dataType: "text",--%>
            <%--data: JSON.stringify(target),--%>
            <%--contentType: 'application/json; charset=utf-8',--%>
            <%--async: false,--%>
            <%--&lt;%&ndash;beforeSend: function (xhr) {&ndash;%&gt;--%>
            <%--&lt;%&ndash;xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");&ndash;%&gt;--%>
            <%--&lt;%&ndash;},&ndash;%&gt;--%>
            <%--success: function (data) {--%>
                <%--alert("세상에 ajax 작동!");--%>
                <%--window.location.href = "/";--%>
            <%--},--%>
            <%--error: function (request, status, error) {--%>
                <%--alert(request.responseText);--%>
                <%--console.log("code:" + request.status + "\n\n" + "reponseType:" + request.responseType + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);--%>
            <%--}--%>

        <%--});--%>
        <%--});--%>
        //-------------------------------------------------------//
        window.TrackJS &&
        TrackJS.install({
           token: "ee6fab19c5a04ac1a32a645abde4613a",
          application: "argon-dashboard-free"
         });
    })
</script>
</body>
</html>