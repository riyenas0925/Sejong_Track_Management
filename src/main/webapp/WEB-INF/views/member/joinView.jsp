<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/setting-h.jsp" %>

<body class="bg-default" style="background-color:#172b4d">
<div class="main-content">
    <%@ include file="../include/member-header.jsp" %>

    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-6">
        <div class="container">
            <div class="header-body text-center mb-7">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-6">
                        <h1 class="text-white">Welcome!</h1>
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
                    <div class="card-body px-lg-5 py-lg-3">
                        <div class="text-center text-muted mb-4">
                            <small>Register a new membership</small>
                        </div>
                        <form action="/memberJoin" id="joinForm" method="post" onsubmit="return totalCheck()">
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-single-02"></i></span>
                                    </div>
                                    <input type="text" class="form-control" placeholder="ID" name="id" required>
                                </div>
                                <div style="margin-top:10px;">
                                    <div style="float:left;"><span id="idCheckRes"></span></div>
                                    <div style="float:right;">
                                        <input type="button" id="jButton" class="btn btn-danger btn-sm" value="중복확인">
                                    </div>
                                    <br style="clear:both;">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-circle-08"></i></span>
                                    </div>
                                    <input type="text" class="form-control" name="name" required placeholder="Full name">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-circle-08"></i></span>
                                    </div>
                                    <input type="email" class="form-control" name="email" required placeholder="Email">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                    </div>
                                    <input class="form-control" placeholder="PassWord" type="password" name="password" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                    </div>
                                    <input type="password" class="form-control" name="pwRe" required placeholder="Retype password">
                                </div>
                                <div id="pwCheckRes" style="margin-top:10px;"></div>
                            </div>

                            <div class="text-center">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-primary my-4">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12 text-right">
                        <a href="${path}/loginView" class="text-light"><small>I already have a membership</small></a>
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
    var idRes = false;
    var pwRes;
    var IsjButtonClicked = false;

    //아이디 중복확인 체킹
    function idCheck() {
        var id = $('input[name=id]').val();

        if (id == "") {
            $('#idCheckRes').css("color", 'red');
            $('#idCheckRes').html("아이디를 입력해주세요.");
            idRes = false;
        } else {
            $.ajax({
                url: '/memberExist',
                data: {"id": id},
                dataType: 'text',
                type: 'POST',
                async: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
                },
                success: function (data) {
                    if (data == "No") {
                        $('#idCheckRes').css("color", 'green');
                        $('#idCheckRes').html("사용가능한 아이디입니다.");
                        idRes = true;
                    } else {
                        $('#idCheckRes').css("color", 'red');
                        $('#idCheckRes').html("이미 존재하는 아이디입니다.");
                        idRes = false;
                    }
                },
                error: function (error) {
                    console.log(error);
                    idRes = false;
                }
            });
        }
    }

    $('input[name=id]').change(function () {
        idRes = false;
        IsjButtonClicked = false
    });

    $('#jButton').click(function () {
        IsjButtonClicked = true;
        idCheck();
    });

    //비밀번호 재확인 체킹
    function pwCorrect() {
        $("input[name=password]").keyup(function () {
            if ($("input[name=password]").val() == $("input[name=pwRe]").val()) {
                $("#pwCheckRes").html("비밀번호가 일치합니다.");
                pwRes = true;

            } else {
                $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                pwRes = false;
            }
        });

        $("input[name=pwRe]").keyup(function () {
            if ($("input[name=password]").val() == $("input[name=pwRe]").val()) {
                $("#pwCheckRes").html("비밀번호가 일치합니다.");
                pwRes = true;

            } else {
                $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                pwRes = false;

            }
        });
    }

    pwCorrect();

    //submit할 때 체킹
    function totalCheck() {
        if (IsjButtonClicked == false) {
            alert(" 중복확인을 해주세요 ");
        }
        return IsjButtonClicked && idRes && pwRes;
    }
</script>

</body>
</html>