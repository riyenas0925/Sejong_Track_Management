<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="include/setting-h.jsp" %>

<div class="main-content" id="top">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header pb-8 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="table-responsive">
                        <div>
                            <input type="text" name="id">
                            <button type="button" class="btn btn-primary" id="jButton">button</button>
                        </div>
                        <span id="idCheckRes"></span>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<%@ include file="include/setting-f.jsp" %>


<script>
    $(document).ready(function() {
        $('#jButton').click(function () {
            idCheck();
        });

        function idCheck() {
            var id = $('input[name=id]').val();

            if (id == "") {
                $('#idCheckRes').css("color", 'red');
                $('#idCheckRes').html("아이디를 입력해주세요.");
            } else {
                $.ajax({
                    url: '/memberExist',
                    data: {"id": id},
                    dataType: 'text',
                    type: 'POST',
                    async: false,

                    success: function (data) {
                        if (data == "No") {
                            $('#idCheckRes').css("color", 'green');
                            $('#idCheckRes').html("사용가능한 아이디입니다.");
                        } else {
                            $('#idCheckRes').css("color", 'red');
                            $('#idCheckRes').html("이미 존재하는 아이디입니다.");
                        }
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            }
        }
    });
</script>