<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp" %>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="/"><b>My info</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">profile</p>

        <form id="joinForm" action="/modifyMemberInfo" method="post">
            Id
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="id" readonly value=<sec:authentication
                        property="principal.id"/>>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            Password
            <div class="form-group has-feedback">
                <input type="button" value="modify password" onclick="showPopup_pw()"/>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            Name
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="name" value=<sec:authentication
                        property="principal.name"/>>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            Email
            <div class="form-group has-feedback">
                <input type="email" class="form-control" name="email" value=<sec:authentication
                    property="principal.email"/>>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <br>Please enter a password to modify the information.
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" required placeholder="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">

                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Modify</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

</body>
</html>

<script type="text/javascript">

    function showPopup_pw() {
        window.open("/popupPwModify", "비밀번호 변경", "width=400,height=300, left=100, top=100, scrollbars=no");
    }

    $('input').iCheck({ //AdminLTE 회원가입 테마 jquery
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
</script>
