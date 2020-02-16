<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="include/sidebar.jsp" %>
<div class="main-content" id="top">
    <div class="wrap-loading display-none">
        <div>
            <img src="../resources/img/theme/loading.gif" width="150">
        </div>
    </div>

    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header pb-8 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="col-12 ct-content">
                        <div class="ct-page-title">
                            <h1 class="ct-title">강의시간표 추가</h1>
                        </div>
                        <p class="ct-lead">트랙에 해당하는 과목을 직접 타이핑 할 필요 없이, 한번의 클릭으로 추가할 수 있도록 강의시간표를 DB에 저장하는 업로드 서비스입니다.</p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <form action="/api/v1/admin/courseSchedule/save" method="post" enctype="multipart/form-data" name="">
            <div class="row">
                <div class="col-xl-8 mb-5 mb-xl-0">
                    <div class="card bg-gradient-lighter shadow">
                        <div class="card-body text-center pb-1 pt-3">
                            <div class="filebox">
                                <label for="ex_filename" id="filelabel" class="btn btn-primary btn-lg fileBtn">Choose files to Upload</label>
                                <input type="file"  name="file" id="ex_filename" class="upload-hidden" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
                                <br>
                                <h5 class="text-muted ls-1 mb-1" id="upload-name">only excel file upload</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4">
                    <div class="card-body p-0">
                        <div class="row">
                            <div class="col-8 text-center mb-2">
                                <button type="button" id="btn1" class="btn btn-default filebtn" data-toggle="modal" data-target="#preview" disabled>미리보기</button>
                            </div>
                            <%@ include file="subject/preview.jsp" %>
                            <div class="col-4 text-center mb-2">
                                <button type="button" class="btn btn-danger filebtn" data-toggle="modal" data-target="#list"><i class="ni ni-align-left-2"></i></button>
                            </div>
                            <%@ include file="subject/list.jsp" %>
                            <div class="w-100"></div>
                            <div class="col-8 text-center mt-2">
                                <button type="submit" id="btn2" class="btn btn-default filebtn" disabled>시간표 추가</button>
                            </div>
                            <div class="col-4 text-center mt-2">
                                <button type="button" class="btn btn-danger filebtn" data-toggle="modal" data-target="#help"><i class="ni ni-settings"></i></button>
                            </div>
                            <%@ include file="subject/help.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="row mt-5">
            <div class="col-xl-12 mb-5 mb-xl-0">
                <div class="card shadow">
                    <div class="card-header border-0">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="mb-0">과목</h3>
                            </div>
                            <div class="col-3 text-right">
                                <input type="text" id="myInput" onkeyup="myFunction()" class="form-control form-control-rounded form-control-prepended" placeholder="Search" aria-label="Search">
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive" style="height:500px;">
                        <!-- Projects table -->
                        <table class="table align-items-center table-flush" id="myTable">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">학수번호</th>
                                    <th scope="col">교과목명</th>
                                    <th scope="col">이수구분</th>
                                    <th scope="col">학점</th>
                                    <th scope="col">파일번호</th>
                                </tr>
                            </thead>
                            <tbody id="table">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- nav-up -->
        <div id="nav-up" class="section-nav">
            <a href="#top" class="avatar rounded-circle mr-3 bg-primary">
                <i class="ni ni-bold-up text-white" style="font-size:24px;"></i>
            </a>
        </div>

        <!-- footer -->
        <%@ include file="include/footer.jsp" %>
    </div>
</div>
<%@ include file="include/setting-f.jsp" %>

<script>
    $(document).ready(function(){
        var navBg = $('#navbar-main');

        navBg.addClass('bg-gradient-primary-1');

        var fileTarget = $('.filebox .upload-hidden');
        var finddot;
        fileTarget.on('change', function() {
            if(window.FileReader){
                var filename = $(this)[0].files[0].name;
            }
            else{
                var filename = $(this).val().split('/').pop().split('\\').pop();
            }

            finddot = filename.indexOf('xlsx');

            if (finddot==-1){ //xlsx 아닌 파일 집어넣으면
                $('#upload-name').html(filename);
                $('#filelabel').html('File format is invalid');
                $('#filelabel').addClass('btn-danger');
                $('#btn1').attr('disabled', true);
                $('#btn2').attr('disabled', true);
            }

            else{
                $('#upload-name').html(filename);
                $('#filelabel').html('Success!!');
                $('#filelabel').removeClass('btn-danger');
                $('#filelabel').addClass('btn-success');
                $('#btn1').removeAttr("disabled");
                $('#btn2').removeAttr("disabled");
            }
        });
    });
</script>

<script>
    $(document).ready(function() {
        getSubject();

        function getSubject() {
            $.ajax({
                type : "GET",
                url : "${path}/api/v1/admin/courseSchedule/list",
                dataType : "json",

                success : function(data) {
                    $("#table").html(createTr(data));
                    $("#listModalTable").html(createList(data));
                },

            });
        }

        $(document).on('click','.removeClick',function(){
            var con = confirm("정말 삭제하시겠습니까?");

            if(con == true){
                $.ajax({
                    url: "${path}/api/v1/admin/courseSchedule/delete/"+$(this).attr("id"),
                    type: "DELETE",
                    data: {"id" : $(this).attr("id")},

                    success:function(data){
                        alert("강의시간표가 삭제되었습니다.");
                        window.location.replace("${path}/trackSubject");
                    },
                    beforeSend:function(){
                        $('.wrap-loading').removeClass('display-none');
                    },
                    complete:function(){
                        $('.wrap-loading').addClass('display-none');
                    }
                });
            }
            else if(con == false){
                return false;
            }
        })


        //trackSubject.jsp table
        function createTr(data) {
            var str = "";
            var id= "";
            $(data).each(
                function () {
                    id=this.id;
                    $(this.subjects).each(function(){
                        str += "<tr>";
                        str += "    <td>" + this.courseNum + "</td>";
                        str += "    <th>" + this.courseTitle + "</th>";
                        str += "    <td>" + this.completionType + "</td>";
                        str += "    <td>" + this.credit + "</td>";
                        str += "    <td>" + id + "</td>";
                        str += "</tr>";
                    })

                }
            );

            return str;
        }

        //list.jsp
        function createList(data) {
            var str = "";
            $(data).each(
                function () {
                    str += "<tr>";
                    str += "    <th scope='row' class='name text-center'>" + this.id + "</th>";
                    str += "    <td class='budget'>" + this.name + "</th>";
                    str += "    <td class='text-right'>";
                    str += "        <button type='button' class='btn btn-warning btn-sm removeClick' id='"+ this.id +"'>삭제</button>";
                    str += "    </td></tr>";
                }
            );

            return str;
        }
    });
</script>

<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, th, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            th = tr[i].getElementsByTagName("th")[0];
            if (th) {
                txtValue = th.textContent || th.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }

</script>