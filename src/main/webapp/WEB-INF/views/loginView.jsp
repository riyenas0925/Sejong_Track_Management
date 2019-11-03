<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<h2>Sejong Track - 로그인</h2>
<form action="/memberLogin" method="post" onsubmit="return totalCheck()">
    id : <br>
    <input type="text" name="id" required><br>
    password : <br>
    <input type="text" name="password" required><br>
    *모두 입력하세요<br>
    <input type="submit" value="로그인"> <input type="reset" value="취소">
</form>
</html>
<%@ include file="include/plugins.jsp" %>
<script type="text/javascript">
    function idCheck2() {
        var id = $('input[name=id]').val();
        var res ;

        $.ajax({
            url: '/memberExist',
            data: {"id": id},
            dataType: 'text',
            type: 'POST',
            async:false,
            success: function (data) {
                if (data == "No") {
                    alert("존재하지 않는 회원입니다.");
                    res = false;
                }
                else {
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

    function pwCheck(){
        var id = $('input[name=id]').val();
        var pw = $('input[name=password]').val();
        var res ;

        $.ajax({
            url: '/memberPwCorrect',
            data: {"id": id, "password": pw},
            dataType: 'text', // true 반환시 : 세션저장, home이동(controller)
            type: 'POST',
            async:false,
            success: function (data) {
                if (data == "No") {
                    alert("비밀번호가 일치하지 않습니다.");
                    res = false;
                }
                else {

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
        if( idCheck2() == false )
            return false;
        else{
            return (pwCheck() == true)? true: false;
        }
    }

</script>
