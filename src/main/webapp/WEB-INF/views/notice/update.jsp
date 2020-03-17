<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="../include/sidebar.jsp" %>
<div class="main-content" id="top">
    <!--header -->
    <%@ include file="../include/header.jsp" %>

    <div class="header pb-7 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="col-12 ct-content">
                        <div class="ct-page-title">
                            <h1 class="ct-title">공지 글 수정</h1>

                        </div>
                        <p class="ct-lead" style="float:left;">${noticeModel.title}</p>

                        <hr style="clear:both;">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
    <div class="container-fluid mt--7">
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <div class="form-group">
                        <label for="updateTitle">제목</label>
                        <input class="form-control" type="text" name="title" id="updateTitle" value="${noticeModel.title}" required/>
                    </div>
                    <div class="form-group">
                        <label for="updateAuthor">작성자</label>
                        <input class="form-control" type="text" name="author" value="${noticeModel.author}" id="updateAuthor" required/>
                    </div>
                    <div class="form-group">
                        <label for="updateContent">본문</label>
                        <textarea class="form-control" id="updateContent" required>${noticeModel.content}</textarea>
                    </div>
                </div>
                <div class="card-footer" style="text-align:right;">
                    <button type="button" class="btn btn-danger" onclick="back()">뒤로가기</button>
                    <button type="button" class="btn btn-success" onclick="noticeUpdate(${noticeModel.id})">글 수정</button>
                </div>
            </div>
        </div>
    </div>
    </sec:authorize>
    <%@ include file="../include/setting-f.jsp" %>

    <script type="text/javascript">
        function noticeUpdate(id){
            var data = {
                title: $('#updateTitle').val(),
                author: $('#updateAuthor').val(),
                content: $('#updateContent').val()
            };

            $.ajax({
                url: '/api/v1/admin/notice/update/' + id,
                type: 'POST',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                async: false,
                <%--beforeSend: function (xhr) {--%>
                <%--xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");--%>
                <%--},--%>
                success: function (data) {
                    alert("공지가 수정되었습니다.");
                    window.location.replace("${path}/notice");
                },
                error: function (request, status, error) {
                    alert("Error! 콘솔로그를 확인하세요");
                    console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
                }
            })
        }

        function back(){
            window.location.replace("${path}/notice");
        }
    </script>

    <script>
        $(document).ready(function(){
            var navBg = $('#navbar-main');

            navBg.addClass('bg-gradient-primary-1');

        });
    </script>

    <script>
        sidebar();

        function sidebar(){
            $('.side').removeClass('active');
            $('#2').addClass('active');
        }
    </script>

    <!-- toastr js 라이브러리 -->
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>