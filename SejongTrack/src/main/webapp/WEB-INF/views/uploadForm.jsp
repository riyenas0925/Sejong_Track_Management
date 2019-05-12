<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

    <%-- Main Header --%>
    <%@ include file="include/main-header.jsp" %>

    <%-- Left side column. contains the logo and sidebar --%>
    <%@ include file="include/main-sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!--오른쪽 하단 nav-->
        <div class="nav-rb1">
            <button type="button" class="btn-nav1" data-toggle="modal" data-target="#modal-default">
                전체트랙
            </button>
        </div>
        <div class="nav-rb2">
            <button type="button" class="btn-nav2" data-toggle="modal" data-target="#modal-default">
                도움말
            </button>
        </div>

        <!--도움말 modal-->
        <div class="modal fade" id="modal-default">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Default Modal</h4>
                    </div>
                    <div class="modal-body">
                        <p>One fine body&hellip;</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->


        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                세종대학교 트랙 조회
                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Sejong Track</a></li>
                <li class="active">트랙 파일 첨부</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">
            <div class="row" style="margin-top:10px;margin-bottom:10px;">
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="callout callout-danger">
                                <h4>파일 형식은 xls입니다.</h4>

                                <p>조회하고자 하는 파일의 형식이 .xls 파일인지 확인하세요.<br>트랙 조회 시스템은 xls 파일만 가능합니다.</p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="callout callout-danger">
                                <h4>학사정보에서 기이수성적파일을 다운받으세요.</h4>

                                <p>학사정보시스템에서 제공하는 기이수 성적 파일만을 이용합니다.<br>자세한 방법은 오른쪽 하단 도움말 버튼에 있습니다.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">기이수 성적 업로드</h3>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="box-body">
                                    <div style="background-color:#d2d6de; padding:5px; padding-left:10px;">
                                        <h4><b>트랙 조회 시스템</b></h4>

                                        <p>트랙 조회 시스템은 사용자의 기이수 과목 목록으로 조회합니다.<br>현재 수강 과목은 반영되지 않으니 참고하시기 바랍니다.</p>
                                    </div><br>

                                    <div class="form-group">
                                        <select id="selectUniv" class="form-control">
                                            <option value="">소속대학 선택</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <select id="selectTrack" class="form-control">
                                            <option value="">트랙 선택</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="box-body">
                                    <div class="fileDrop" style="cursor:pointer">
                                        <input type="file" name="file" id="file" class="inputfile" />
                                        <label for="file" id="uploadText"><img src="../dist/img/파일선택.png" width="100px;"></label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 스크롤 박스 약관동의 -->

                        <div class="box-footer">
                            <button id="result" type="submit" class="btn btn-success">조회</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%-- /.content --%>
    </div>
    <%-- /.content-wrapper --%>

    <%-- Main Footer --%>
    <%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>
<script language="JavaScript">
    $(document).ajaxStart(function() {
        Pace.restart();
    });

    $(document).ready(function(){

        getUnivList();
        getTrackList(1);

        $(".fileDrop").on("dragenter dragover", function (event) {
            event.preventDefault();
        });

        $(".fileDrop").on("drop", function (event) {
            event.preventDefault();

            var formData = new FormData();
            var files = event.originalEvent.dataTransfer.files;
            var file = files[0];

            formData.append("file", file);

            $.ajax({
                url: '/uploadResult',
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    if(checkExcelType(file.name)){
                        toastr["success"]("올바른 파일입니다.");
                        document.getElementById("uploadText").innerHTML='<img src="../dist/img/기이수완료.png" width="100px;">';
                    }
                    else{
                        toastr["error"]("기이수 성적.xls 파일만 첨부할수 있습니다.");
                        document.getElementById("uploadText").innerHTML='<img src="../dist/img/파일선택.png" width="100px;">';
                    }
                }
            })
        });

        $('.inputfile').change(function(){
            var formData = new FormData();
            var file = $(this).prop('files')[0];

            formData.append("file", file);

            $.ajax({
                url: '/uploadResult',
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    if(checkExcelType(file.name)){
                        toastr["success"]("올바른 파일입니다.");
                        document.getElementById("uploadText").innerHTML='<img src="../dist/img/기이수완료.png" width="100px;">';
                    }
                    else{
                        toastr["error"]("기이수 성적.xls 파일만 첨부할수 있습니다.");
                        document.getElementById("uploadText").innerHTML='<img src="../dist/img/파일선택.png" width="100px;">';
                    }
                }
            })
        });

        $('#result').on('click', function (event) {
           var univ = $('#selectUniv').val();
           var track = $('#selectTrack').val();

            self.location = "uploadResult"
                + '?univNo=' + univ
                + '&trackNo=' + track;
        });

        function checkExcelType(fileName){
            var pattern = /xls|xlsx/i;
            return fileName.match(pattern);
        }

        <!-- Track, Univ 조회 기능 -->
        $('#selectUniv').on('change', function() {
            var selectUniv = this.value;
            getTrackList(selectUniv)
        });

        function getUnivList() {
            $.getJSON("uploadAjax/univList", function (data) {  //localhost:8080/uploadAjax/univList 주소 들어가보면 json 형태로 출력됨
                var str = "";

                $(data).each(
                    function () {
                        str += "<option value='" + this.univNo + "'>" + this.univTitle + "</option>"
                    });

                $("#selectUniv").html(str);
            });
        }

        function getTrackList(selectUniv) {
            $.getJSON("uploadAjax/selectUniv/" + selectUniv, function (data) {
                var str = "";
                console.log(data.length);

                $(data).each(
                    function () {
                        str += "<option value='" + this.trackNo + "'>" + this.trackTitle + "</option>"
                    });

                $("#selectTrack").html(str);
            });
        }
    });
</script>

<style>
    .fileDrop{
        width: 100%;
        height: 200px;
        border: 3px dashed grey;
        border-radius: 5px;
        text-align: center;
        line-height: 200px;
        display: block;
    }

    #uploadText{
        font-size: 2em;
        font-style : oblique;
        color : grey;
        width:100%;
        cursor:pointer;
    }

    .inputfile {
        width: 0.1px;
        height: 0.1px;
        opacity: 0;
        overflow: hidden;
        position: absolute;
        z-index: -1;
    }

    small{
        margin-left: 3px;
        font-weight: bold;
        color: gray;
    }
</style>
</html>