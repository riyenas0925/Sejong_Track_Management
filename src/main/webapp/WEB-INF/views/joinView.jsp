<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<h2>Sejong Track - 회원가입</h2>
<form id="joinForm" action="/memberJoin" method="post" onsubmit="return idCheck()">
    id :  <br>
    <input type="text" name="id" required> <input type="button" id="jButton" value="중복확인"><br>
    e-mail <br>
    <input type="text" name="email" required ><br>
    name : <br>
    <input type="text" name="name" required><br>
    password (<del>최소 6자리, 영문,숫자,특수문자 필수?</del>) <br>
    <input type="text" name="password" required placeholder="형식을 맞춰주세요"><br>
    *모두 입력하세요<br>
    <input type="submit" value="가입"> <input type="reset" value="취소">
</form>

</html>
<link rel="stylesheet" href="http://rawgit.com/Soldier-B/jquery.toast/master/jquery.toast/jquery.toast.min.css"/>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script type="text/javascript">
    function idCheck() {
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
                    toastr["success"]("사용가능한 아이디입니다.");
                    res = true;
                } else {
                    toastr["error"]("이미 존재하는 아이디입니다");
                    res = false;
                }
            },
            error: function (error) {
                console.log(error);
                res = false;
            }

        });
        return res;

    }

    $('#jButton').click(function() {
        idCheck();
    })

</script>