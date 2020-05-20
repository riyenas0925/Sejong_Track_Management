<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<style>
    #sejongLink {
        background-image:url('../resources/img/brand/sejong.png');
        background-size:cover;
        background-repeat:no-repeat;
    }

    .homeLink {
        border-radius:5px;
    }
</style>

<%@ include file="include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="include/sidebar.jsp" %>

<div class="main-content">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <span class="alert-icon"><i class="ni ni-bell-55"></i></span>
                    <span class="alert-text"><strong>SW대학 트랙 제도 신청 기간!</strong> 20200302~20201231</span>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <!-- Card stats -->
                <div class="row" id="noticeDiv">
                    <!--공지사항-->

                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col-xl-8 mb-5 mb-xl-0">
                <div class="card shadow">
                    <div class="card-header bg-transparent">
                        <div class="row align-items-center">
                            <div class="col">
                                <h6 class="text-uppercase text-muted ls-1 mb-1">최근 트랙 현황 조회 결과</h6>
                                <h2 class="mb-0" id="univTitle"></h2>
                            </div>
                            <div class="col">
                                <ul class="nav nav-pills justify-content-end">
                                    <li class="nav-item">
                                        <a href="${path}/uploadForm" class="btn btn-primary btn-sm">
                                            트랙 조회
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="card-body p-0">
                        <div class="table-responsive">
                            <table class="table align-items-center table-flush">
                                <tbody id="trackDiv">
                                    <!--진척도 table-->
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xl-4">
                <div class="card shadow mb-2" style="border:0px;">
                    <div class="card-header bg-gradient-danger homeLink">
                        <a href="#" target="_blank">
                            <div class="row align-items-center">
                                <div class="col">
                                    <h6 class="text-uppercase text-white-50 ls-1 mb-1">20200302~20201231</h6>
                                    <h2 class="mb-0 text-white">트랙 제도 신청자 모집</h2>
                                </div>
                                <div class="col-auto">
                                    <div class="icon icon-shape bg-gradient-secondary rouned-circle text-danger shadow">
                                        <i class="ni ni-check-bold"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="card bg-default shadow mb-2">
                    <div class="card-header bg-transparent">
                        <div class="row align-items-center">
                            <div class="col">
                                <h6 class="text-uppercase text-muted ls-1 mb-1">테스트1</h6>
                                <h2 class="mb-0 text-white">테스트1 바로가기</h2>
                            </div>
                            <div class="col-auto">
                                <div class="icon icon-shape bg-gradient-secondary text-default rouned-circle shadow">
                                    <i class="ni ni-curved-next"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card bg-default shadow mb-2">
                    <div class="card-header bg-transparent">
                        <div class="row align-items-center">
                            <div class="col">
                                <h6 class="text-uppercase text-muted ls-1 mb-1">테스트2</h6>
                                <h2 class="mb-0 text-white">테스트2 바로가기</h2>
                            </div>
                            <div class="col-auto">
                                <div class="icon icon-shape bg-gradient-secondary text-default rouned-circle shadow">
                                    <i class="ni ni-curved-next"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card shadow mb-2" style="border:0px;">
                    <div class="card-header homeLink" id="sejongLink">
                        <a href="http://www.sejong.ac.kr/" target="_blank">
                            <div class="row align-items-center">
                                <div class="col">
                                    <h6 class="text-uppercase text-white-50 ls-1 mb-1">세종대 홈페이지 바로가기</h6>
                                    <h2 class="mb-0 text-white">세종대학교</h2>
                                </div>
                                <div class="col-auto">
                                    <div class="icon icon-shape bg-gradient-red text-white rouned-circle shadow">
                                        <i class="ni ni-hat-3"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@ include file="include/footer.jsp" %>
    </div>
</div>
<%@ include file="include/setting-f.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        var ID = '${userModel.userId}';;

        if(ID!=""){
            showTrackList();
        }
        else{
            notLogin();
        }

        showNoticeList();

        //최근트랙결과조회
        function showTrackList(){
            $.ajax({
                url: 'api/v1/log/find/user/'+ID,
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                async: false,
                success: function (data) { //리스트 -> json
                    if (data!=""){
                        printTrackList(data);
                    }
                    else{
                        nullTrackData();
                    }
                },
                error: function (error) {
                    alert("ERROR발생: " + JSON.stringify(error));
                }
            })
        }
        function printTrackList(data) {
            var str = "";
            var percent;
            var percentColor='';
            var trackName='';
            var univName='';

            console.log(data);
            $.each(data, function (index) {
                $.each(data[index], function (key, value) {
                    if (key == "percent") {
                        percent = Math.floor(value);
                    } else if (key == "trackName") {
                        trackName=value;
                    } else if (key == "percentColor"){
                        percentColor=value;
                    } else if (key == "univName"){
                        univName=value;
                    }
                });

                str+='<tr><th style="color:#324CDD;">'+ trackName +'</th><td width="60%"><span class="progress" style="width:100%;">\n'
                    + '<div class="progress-bar"role="progressbar" style="width: '
                + percent +'%;background-color:' + percentColor + ';"></div></span></td><td><span class="progress-percentage"><span>'
                + percent + '%</span></span></td></tr>';
            });

            $('#univTitle').html(univName);
            $('#trackDiv').html(str);
        }

        function nullTrackData(){
            var str='<tr><th style="text-align:center"><br><br>트랙 현황 조회 데이터가 없습니다.<br>최소 한 번 이상의 현황 조회가 필요합니다.';
            str +='<br><br><a href="${path}/uploadForm" class="btn btn-sm btn-outline-primary">트랙 현황 조회 </a></th></tr>';

            $('#univTitle').html("데이터가 없습니다");
            $('#trackDiv').html(str);
        }

        function notLogin(){
            var str='<tr><th style="text-align:center"><br><br>로그인이 필요한 서비스 입니다.';
            str +='<br><br><a href="${path}/loginView" class="btn btn-sm btn-outline-primary">로그인 </a></th></tr>';

            $('#univTitle').html("로그인 필요");
            $('#trackDiv').html(str);
        }

        //공지사항
        function showNoticeList() {
            $.ajax({
                url: 'api/v1/notice/list',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                async: false,
                success: function (data) { //리스트 -> json
                    printNoticeList(data);
                },
                error: function (error) {
                    alert("ERROR발생: " + JSON.stringify(error));
                }
            })
        };

        function printNoticeList(data) {
            var str = "";
            var title;
            var content;
            var i = 0;

            $.each(data, function (index) {
                if (i > 1) {
                    i=0;
                    $('#noticeDiv').html(str);
                }
                $.each(data[index], function (key, value) {
                    if (key == "title") {
                        title = value;
                    } else if (key == "content") {
                        content = value;
                    }
                });

                str += '<div class="col-xl-6 col-lg-6"><div class="card mb-4 mb-xl-0"><div class="card-body"><h6 class="text-uppercase text-muted ls-1 mb-1">최근 공지</h6><h3 class="card-title" style="color:#324CDD"> ' +
                    title + '</h3><div class="text-default" style="font-size:14px;">' + content + '<br></div></div></div></div>';
                i++;
            });

            $('#noticeDiv').html(str);
        }
    });
</script>

<script>
    sidebar();

    function sidebar(){
        $('.side').removeClass('active');
        $('#1').addClass('active');
    }
</script>