<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<%@ include file="include/head.jsp" %>
<body>
<h1>IT IS NOTICE PAGE</h1>
<sec:authorize access="hasAuthority('ADMIN')">
    <h4>[관리자]님 공지를 추가하세요</h4>
    <div id="textBox">
        <form>
            제목 : <input type="text" name="title" required/><br>
            작성자 : <input type="text" value="관리자" name="author" required/><br>
            내용 : <textarea width="100" height="100" required></textarea>
            <input type="button" value="글 쓰기" name="save" onclick="insertNotice()"/>
        </form>
    </div>
</sec:authorize>
<h2>Notice List</h2>
<div>
    목록을 조회하려면 새로고침하세요
    <table id="noticeList" width="500" border="1">

    </table>
</div>
<%--<script src="/track_js/notice.js"/>     --%>
<%--외부js에서 라이브러리도 없이 jqeury써서 그런듯?--%>
<script type="text/javascript">

    $(document).ready(showNoticeList());

    function showNoticeList() {
        $.ajax({
            url: '/notice/list',
            type: 'GET',
            data: 'json',
            contentType: 'application/json; charset=utf-8',
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function (data) { //리스트 -> json
                var str = "<tr><th>제목</th><th>날짜</th><th>작성자</th></tr>" + printList(data);
                $('#noticeList').html(str);
            },
            error: function (error) {
                alert("ERROR발생: " + JSON.stringify(error));
            }
        })
    };

    function insertNotice() {
        var data = {
            title: $('input[name=title]').val(),
            author: $('input[name=author]').val(),
            content: $('textarea').val()
        };
        console.log("data: ", data);

        $.ajax({
            url: '/notice/create',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data),
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function (data) {
                alert("공지가 등록되었습니다.");
            },
            error: function (error) {
                alert("ERROR발생: " + JSON.stringify(error));
                console.log(JSON.stringify(error));
            }
        });

    };

    function printList(jsonArray) {
        var str = "";

        for (var jsonObj in jsonArray) {
            var id = jsonArray[jsonObj].id;
            var title = jsonArray[jsonObj].title;
            var author = jsonArray[jsonObj].author;
            var date = jsonArray[jsonObj].date;

            console.log("id: " + id);
            str += '<tr><td>' + '<a href="/notice/details/' + id + '">' + title + '</a></td><td>' + date + '</td><td>' + author + '</td></tr>';

        }
        console.log("jsonArray: ", jsonArray);
        return str;
    };

</script>
</body>
</html>

