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

    <div class="header pb-7 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="col-12 ct-content">
                        <div class="ct-page-title">
                            <h1 class="ct-title">전체 트랙 보기</h1>

                        </div>
                        <p class="ct-lead">세종대학교 각 대학에서 시행하는 트랙을 한 눈에 볼 수 있는 서비스입니다.</p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col-xl-12">
                <select class="form-control form-control-sm" id="select_univ">

                </select>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-xl-12 mb-xl-0">
                <div class="card shadow">
                    <div class="card-header border-0">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="mb-0" id="univName"><!-- 대학이름 --></h3>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive" style="height:500px;">
                        <!-- Projects table -->
                        <table class="table align-items-center table-flush">
                            <thead class="thead-light">
                            <tr id="thead"><!-- 테이블 헤드 --><th></th></tr>
                            </thead>
                            <tbody id="table"><!-- 테이블 --></tbody>
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

<script language="JavaScript">
    $(document).ready(function () {
        //시작
        getUnivData();
        getJson(0);

        function getUnivData(){
            $.ajax({
                url: '/api/v1/select/univ',
                type: "GET",
                data: JSON,

                success:function(data){
                    addSelectUniv(data);
                },
            });
        }

        function addSelectUniv(data){
            var str="<option value='0'>------ 대학 선택 ------</option>";

            $.each(data,function(index){
                $.each(data[index],function(key,value){
                    if(key=="id"){
                        str+="<option value="+value+">"
                    }
                    else if(key=="title"){
                        str+= value + "</option>";
                    }
                });
            });
            $("#select_univ").html(str);
        };

        //select 값 변경
        $('#select_univ').on('change', function() {
            $("#table").html("");
            $("#thead").html("<th></th>");

            var selectUniv = this.value;
            getJson(selectUniv);
        });

        //selectUniv > GET json data
        function getJson(selectUniv) {
            if (selectUniv == 0){
                $("#univName").html("대학을 선택하세요.");
                return false; //함수 강제 종료
            }

            //table title
            var univ_Name= $('#select_univ option:selected').html();
            $("#univName").html(univ_Name);

            //get data
            $.ajax({
                url: "${path}/api/v1/trackAll/"+selectUniv,
                type: "GET",
                data: JSON,

                beforeSend:function(){
                    //loding?
                },
                success:function(data){
                    trackName(data);
                },
            });

        }

        //thead
        function thead(data){
            console.log(data);
            $("#thead").html("<th scope='col'>트랙 명</th>");
            $.each(data,function(key,value){
                $.each(value,function(key){
                    $("#thead").append("<th scope='col'>"+key+"</th>");
                });
                return false;
            })
        }

        //tbody - track name
        function trackName(data){
            var str = "";

            thead(data);

            $.each(data,function(key,value){
                str += "<tr>";
                str += "    <th>"+key+"</th>";

                $.each(value,function(key,value){
                    //course
                    str += jsonArray(value);
                });

                str += "</tr>";
                $("#table").append(str);
                str = ""; //초기화
            });
        }

        //tbody - course
        function jsonArray(data){
            var courseNo="";
            var str="<td>";

            $.each(data,function(index){
                $.each(data[index],function(key,value){
                    if(key=="courseNo"){
                        courseNo+="학수번호 : "+ value;
                    }
                    else if(key=="title"){
                        str += '<a title="'+ courseNo +'"><mark>';
                        str += value +'</mark></a> &nbsp;&nbsp;';

                        //초기화
                        courseNo = "";
                    }
                });
            });

            str += "</td>";
            return str;
        }

    });
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
        $('#4').addClass('active');
    }
</script>

<!-- toastr js 라이브러리 -->
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
