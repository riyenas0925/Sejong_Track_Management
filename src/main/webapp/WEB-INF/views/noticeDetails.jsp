<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<%@ include file="include/head.jsp" %>
<body>

<h1>Notice</h1>
<div>
    <table border="1">
        <tr>
            <th>제목</th>
            <td>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <input type="text" id="selectedTitle" value="${noticeModel.title}"/>
                </sec:authorize>
                <sec:authorize access="!hasAuthority('ADMIN')">
                    ${noticeModel.title}
                </sec:authorize>
            </td>
        </tr>
        <tr>
            <th>날짜</th>
            <td id="selectedDate">${noticeModel.date}</td>

        </tr>
        <tr>
            <th>작성자</th>
            <td id="selectedAuthor">${noticeModel.author}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <textarea id="selectedContent">${noticeModel.content}</textarea>
                </sec:authorize>
                <sec:authorize access="!hasAuthority('ADMIN')">
                    ${noticeModel.content}
                </sec:authorize>
            </td>
        </tr>
    </table>
    <sec:authorize access="hasAuthority('ADMIN')">
        <input type="button" value="글 수정" onclick="updateNotice(${noticeModel.id})"/>
        <input type="button" value="글 삭제" onclick="deleteNotice(${noticeModel.id})"/>
    </sec:authorize>
</div>
</body>
</html>
<script type="text/javascript">
    function updateNotice(noticeId) {
        alert("글수정을 눌렀습니다.");

        var data = {
            title: $('#selectedTitle').val(),
            author: $('#selectedAuthor').html(),
            content: $('#selectedContent').html()
        };

        console.log(noticeId);
        console.log("update함수 data: ", data);

        $.ajax({
            url: '/notice/update/' + noticeId,
            type: 'POST',
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function (data) {
                alert("공지가 수정되었습니다.");
            },
            error: function (request, status, error) {
                alert("Error! 콘솔로그를 확인하세요");
                console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
            }
        })
    };

    function deleteNotice(noticeId) {
        alert("글삭제를 눌렀습니다.");
        var data = {
            title: $('#selectedTitle').val(),
            author: $('#selectedAuthor').val(),
            content: $('#selectedContent').val()
        };

        $.ajax({
            url: '/notice/delete/' + noticeId,
            type: 'POST',
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function (data) {
                alert("공지가 삭제되었습니다.");
            },
            error: function (request, status, error) {
                alert("Error! 콘솔로그를 확인하세요");
                console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
            }
        })
    };
</script>