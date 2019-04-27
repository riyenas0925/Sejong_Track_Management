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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">기이수 성적 업로드</h3>
                        </div>

                        <div class="box-body">
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

                            <div class="fileDrop">
                                <input type="file" name="file" id="file" class="inputfile" />
                                <label for="file" id="uploadText">기이수 성적.xlsx</label>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button id="result" type="submit" class="btn btn-primary">Submit</button>
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
                        alert("올바른 타입입니다.");
                    }
                    else{
                        alert("기이수 성적.xls 파일만 첨부할수 있습니다.");
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
                        alert("올바른 타입입니다.");
                    }
                    else{
                        alert("기이수 성적.xls 파일만 첨부할수 있습니다.");
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