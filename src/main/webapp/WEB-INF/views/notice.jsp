<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="include/sidebar.jsp" %>
<div class="main-content" id="top">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header pb-7 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="col-12 ct-content">
                        <div class="ct-page-title">
                            <h1 class="ct-title">공지사항</h1>

                        </div>
                        <p class="ct-lead" style="float:left;">세종대학교 트랙 공지사항입니다. &nbsp;&nbsp;<a href="#">트랙 관련 문의</a></p>
                        <sec:authorize access="hasRole('ADMIN')">
                            <button type="button" class="btn btn-success btn-sm" style="float:right;"  data-toggle="modal" data-target="#noticeCreate">글 쓰기</button>
                            <%@ include file="notice/create.jsp" %>
                        </sec:authorize>
                        <hr style="clear:both;">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <div class="row" id="noticeList">

        </div>
    </div>

    <%@ include file="include/setting-f.jsp" %>


    <script type="text/javascript">
        $(document).ready(showNoticeList());
        function showNoticeList() {
            $.ajax({
                url: 'api/v1/notice/list',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                async: false,
                <%--beforeSend: function (xhr) {--%>
                <%--xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");--%>
                <%--},--%>
                success: function (data) { //리스트 -> json
                    printList(data);
                },
                error: function (error) {
                    alert("ERROR발생: " + JSON.stringify(error));
                }
            })
        };

        function printList(jsonArray) {
            var str = "";

            for (var jsonObj in jsonArray) {
                var id = jsonArray[jsonObj].id;
                var title = jsonArray[jsonObj].title;
                var author = jsonArray[jsonObj].author;
                var date = jsonArray[jsonObj].date;
                var content = jsonArray[jsonObj].content;

                str += '<div class="col-xl-12 mb-3">' +
                    '        <div class="mb-2">' +
                    '              <div class="btn btn-secondary btn-lg btn-block notice" id="notice'+id+'" onclick="noticeClick(\'#notice'+id+'\',\'#tap'+id+'\')">' +
                    '                   <name>'+title+'</name>' +
                    '                   <div>' +
                    '                        <date>'+date+'</date>' +
                    '                        <author>'+author+'</author>' +
                    '                   </div>' +
                    '              </div>' +
                    '        </div>' +
                    '        <iv class="card shadow display-none tap" id="tap'+id+'">' +
                    '              <div class="card-body">' +
                    '                   <p class="description">'+content+'</p>' +
                    '              </div>' +
                    '<sec:authorize access="hasRole(\'ADMIN\')">'+
                    '              <div class="card-footer" style="text-align:right;">' +
                    '                   <input type="button" class="btn btn-warning btn-sm" onclick="noticeDetails('+id+')" value="글 수정">' +
                    '                   <input type="button" class="btn btn-danger btn-sm" onclick="noticeDelete('+id+')" data-toggle="modal" data-target="#noticeUpdate'+ id +'" value="글 삭제">' +
                    '              </div>' +
                    '</sec:authorize>'+
                    '        </div>' +
                    '   </div>';
            }

            $('#noticeList').html(str);
        };

        function noticeDetails(id){
            window.location.replace("/notice/"+id);
        }

        function noticeDelete(id){
            var del = confirm("정말로 삭제 하시겠습니까?");

            if (del == true){

                $.ajax({
                    url: 'api/v1/admin/notice/delete/' + id,
                    type: 'POST',
                    async: false,
                    <%--beforeSend: function (xhr) {--%>
                    <%--xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");--%>
                    <%--},--%>
                    success: function () {
                        alert("공지가 삭제되었습니다.");
                        window.location.replace("${path}/notice");
                    },
                    error: function (request, status, error) {
                        alert("Error! 콘솔로그를 확인하세요");
                        console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
                    }
                })

            }
            else {
                alert("삭제를 취소합니다.")
            }
        };
    </script>

    <!-- css 효과 -->
    <style>
        .notice{
            background-color:white;
            text-align:left;
            height:50px;
            color:#172b4d;
        }
        .notice name{
            padding-left:20px;
            float:left;
        }
        .notice div{
            padding-right:20px;
            float:right;
        }
        .notice div date{
            padding-right:40px;
            color:#adb5bd;
        }
        .notice div author{
            color:#f5365c;
        }
        .tap{
            clear:both;

        }
    </style>

    <script>
        function noticeClick(notice,tap){
            if($(tap).hasClass("display-none") === true) {
                $(notice).addClass("active");
                $(tap).removeClass("display-none");
                $(notice).css('background-color','#172b4d');
                $(notice).css('color','white');
            }

            else {
                $(notice).removeClass("active");
                $(tap).addClass("display-none");
                $(notice).css('background-color','white');
                $(notice).css('color','#172b4d');
            }

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