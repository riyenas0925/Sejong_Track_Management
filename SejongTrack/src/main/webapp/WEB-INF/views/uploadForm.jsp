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
                                    <c:forEach items="${univs}" var="univ" >
                                        <option value="${univ.univNo}"> ${univ.univTitle} </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <select id="selectTrack" class="form-control">
                                    <option value="">트랙 선택</option>

                                </select>
                            </div>

                            <div class="fileDrop"></div>
                            <div class="uploadedList"></div>

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

<style>
    .fileDrop{
        width: 100%;
        height: 200px;
        border: 1px dotted blue;
    }

    small{
        margin-left: 3px;
        font-weight: bold;
        color: gray;
    }
</style>

<script language="JavaScript">
    $(document).ajaxStart(function() {
        Pace.restart();
    });

    $(document).ready(function(){

        $(".fileDrop").on("dragenter dragover", function (event) {
            event.preventDefault();
        });

        $(".fileDrop").on("drop", function (event) {
            event.preventDefault();

            var files = event.originalEvent.dataTransfer.files;
            var file = files[0];

            var formData = new FormData();
            formData.append("file", file);

            var univ = $('#selectUniv').val();
            var track = $('#selectTrack').val();

            $.ajax({
                url: '/uploadResult?univNo=' + univ + '&track=' + track,
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST'
            })
        });

        $('#result').on('click', function (event) {
           var univ = $('#selectUniv').val();
           var track = $('#selectTrack').val();
           
           self.location = "uploadResult"
                         + '?univNo=' + univ
                         + '&trackNo=' + track;
        });

        $('#selectUniv').on('change', function() {
            var selectUniv = this.value;
            getTrackList(selectUniv)
        });

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
</html>