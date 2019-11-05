<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="include/head.jsp" %>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="/"><b>Sejong-Track</b> Login</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form action="/memberLogin" id="form-login" method="post" onsubmit="return totalCheck()">
            <div class="form-group has-feedback">
                <input type="id" class="form-control" name="id" required placeholder="Id">
                <span class="glyphicon glyphicon-user form-control-feedback"></span></div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" required placeholder="Password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="rememberCheck"> Remember Me
                            <br><span id="area">?</span>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- OR -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in
                using
                Facebook</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in
                using
                Google+</a>
        </div>
        <!-- /.social-auth-links -->

        <a href="#">I forgot my password</a><br>
        <a href="${path}/joinView" class="text-center">Register a new membership</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
</body>
</html>

<%@ include file="include/plugins.jsp" %>
<script type="text/javascript">

    function idCheck2() {
        var id = $('input[name=id]').val();
        var res;

        $.ajax({
            url: '/memberExist',
            data: {"id": id},
            dataType: 'text',
            type: 'POST',
            async: false,
            success: function (data) {
                if (data == "No") {
                    alert("존재하지 않는 회원입니다.");
                    res = false;
                } else {
                    res = true;
                }
            },
            error: function (error) {
                console.log(error);
                res = false;
            }

        });
        return res;
    }

    function pwCheck() {
        var id = $('input[name=id]').val();
        var pw = $('input[name=password]').val();
        var res;

        $.ajax({
            url: '/memberPwCorrect',
            data: {"id": id, "password": pw},
            dataType: 'text', // true 반환시 : 세션저장, home이동(controller)
            type: 'POST',
            async: false,
            success: function (data) {
                if (data == "No") {
                    alert("비밀번호가 일치하지 않습니다.");
                    res = false;
                } else {

                    res = true;
                }
            },
            error: function (error) {
                console.log(error);
                res = false;
            }

        });
        return res;
    }

    function totalCheck() {
        if (idCheck2() == false)
            return false;
        else {
            return (pwCheck() == true) ? true : false;
        }
    }


    $('input').iCheck({//AdminLTE 회원가입 테마 jquery
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });


</script>
