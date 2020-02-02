<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="userId" value='principal.id'/>

<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp" %>

<body>

<form id="joinForm" action="/modifyPw" method="post" onsubmit="return totalCheck()">
        <div class="form-group has-feedback">
            기존 비밀번호
            <input type="password" class="form-control" name="password" required placeholder="original password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            새 비밀번호
            <input type="password" class="form-control" name="newPw" required placeholder="new password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            재입력
            <input type="password" class="form-control" name="newPwRe" required placeholder="retype new password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <div class="col-xs-8"><span id="pwCheckRes"></span></div>
        </div>
    <div class="col-xs-5">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="<sec:authentication property='principal.id'/>"/>
        <button type="submit" class="btn btn-primary btn-block btn-flat">change password</button>
    </div>
</form>

<%--test--%>
<br><br>
세션 전달 정상여부 테스트:
<br>id : <c:out value="${userId}"/>
<%----%>

</body>
</html>
<script type="text/javascript">
    var psRes=false;

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

    function totalCheck(){
        return pwRes;
    }
</script>