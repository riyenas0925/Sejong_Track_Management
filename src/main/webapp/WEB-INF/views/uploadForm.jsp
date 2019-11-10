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
            <div class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4>파일 형식은 xls입니다.</h4>
                                <p>조회하고자 하는 파일의 형식이 .xls 파일인지 확인하세요.<br>트랙 조회 시스템은 xls 파일만 가능합니다.</p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>

                                <h4>학사정보에서 기이수성적파일을 다운받으세요.</h4>
                                <p>학사정보시스템에서 제공하는 기이수 성적 파일만을 이용합니다.<br>자세한 방법은 오른쪽 하단 도움말 버튼에 있습니다.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">기이수 성적 업로드</h3>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box-body">
                                    <div style="background-color:#d2d6de; padding:5px; padding-left:10px;">
                                        <h4><b>트랙 조회 시스템</b></h4>
                                        <p>트랙 조회 시스템은 사용자의 기이수 과목 목록으로 조회합니다.<br>현재 수강 과목은 반영되지 않으니 참고하시기 바랍니다.</p>
                                    </div><br>

                                    <div class="form-group">
                                        <label>대학</label>
                                        <select id="select_univ" class="form-control">
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>트랙</label>
                                        <select id="select_track" class="form-control">
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>학위</label>
                                        <select id="" class="form-control">
                                        </select>
                                    </div>

                                    <div class="fileDrop" style="cursor:pointer">
                                        <input type="file" name="file" id="file" class="inputfile" />
                                        <label for="file" id="uploadText"><img src="../dist/img/파일선택.png" width="100px;"></label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="box">
                        <div class="box-body">
                            <div style="height: 528px; overflow:auto">
                            <h2 style="text-align: center">Sejong Track 일반 사용 약관</h2>
                            <hr>
                            최종 업데이트일: 2018년 6월 5일 모든 이전 버전을 대체합니다.<br><br>
                            본 일반 사용 약관("일반 약관")은 해당하는 추가 약관(아래 1.2조 참조)과 구독 및 취소 약관(통칭하여 "약관")과 함께 본사 웹사이트, 고객 지원 및 Creative Cloud와 같은 서비스(통칭하여 "서비스")의 사용 및 서비스의 일부로 본사가 포함하는 소프트웨어, 모든 응용 프로그램, 샘플 파일 및 컨텐츠 파일(아래 정의), 스크립트, 소스 코드, 지침 세트 및 관련 설명서(통칭하여 "소프트웨어")의 사용에 적용됩니다. 귀하가 특정 서비스 또는 소프트웨어와 관련하여 본사와 다른 계약을 맺은 경우, 해당 계약이 본 약관과 상충할 때 해당 계약의 조항이 우선합니다. 아래의 4조에서 추가적으로 논의되는 바와 같이, 귀하는 귀하의 컨텐츠에서 귀하가 갖는 모든 권리 및 소유권을 유지합니다.<br><br>
                            개인 Adobe ID로 등록하려면 만13세 이상이어야 합니다.초등 및 중등 교육 명명 사용자 상품에 참여하는 학교는 만13세 미만 아동에게 엔터프라이즈 수준의 Adobe ID를 발생할 수 있지만 이는 명시적인 부모 동의를 받은 후에 이루어져야 합니다.<br>
                            </div>
                        </div>
                        <div class="box-footer">
                            <div class="text-center">
                                <button id="result" type="submit" class="btn btn-success">조회</button>
                            </div>
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

        selectService.univ();
        selectService.track(1);

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
           var univId = $('#select_univ').val();
           var trackId = $('#select_track').val();

            self.location = "uploadResult"
                + '?univId=' + univId
                + '&trackId=' + trackId;
        });

        function checkExcelType(fileName){
            var pattern = /xls|xlsx/i;
            return fileName.match(pattern);
        }

        <!-- Track, Univ 조회 기능 -->
        $('#select_univ').on('change', function() {
            var univId = this.value;
            selectService.track(univId);
        });
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