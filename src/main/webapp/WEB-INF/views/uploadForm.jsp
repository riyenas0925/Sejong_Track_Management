<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                            <h1 class="ct-title">트랙 현황 조회</h1>

                        </div>
                        <p class="ct-lead">사용자의 <a href="#">기이수 성적표</a>를 이용해 한 눈에 트랙 진척도를 확인할 수 있는 서비스입니다.</p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col-xl-5">
                <div class="card bg-gradient-danger">
                    <div class="card-body">
                        <h2 class="card-title text-white"><i class="ni ni-bell-55 text-white"></i> 기이수 성적 xls파일</h2>
                        <div class="text-white" style="font-size:14px;">
                            학사정보시스템에서 제공하는 기이수 성적 파일만을 이용합니다.<br>
                        </div>
                    </div>
                </div>
                <div class="card mt-3">
                    <div class="card-body">
                        <h2 class="card-title">세종트랙 일반 사용 약관</h2>

                        <p style="font-size:14px;">최종 업데이트일: 2018년 6월 5일 모든 이전 버전을 대체합니다.
                            <br><br>본 일반 사용 약관("일반 약관")은 해당하는 추가 약관(아래 1.2조 참조)과 구독 및 취소 약관(통칭하여 "약관")과 함께 본사 웹사이트, 고객 지원 및 Creative Cloud와 같은 서비스(통칭하여 "서비스")의 사용 및 서비스의 일부로 본사가 포함하는 소프트웨어, 모든 응용 프로그램, 샘플 파일 및 컨텐츠 파일(아래 정의), 스크립트, 소스 코드, 지침 세트 및 관련 설명서(통칭하여 "소프트웨어")의 사용에 적용됩니다. 귀하가 특정 서비스 또는 소프트웨어와 관련하여 본사와 다른 계약을 맺은 경우, 해당 계약이 본 약관과 상충할 때 해당 계약의 조항이 우선합니다. 아래의 4조에서 추가적으로 논의되는 바와 같이, 귀하는 귀하의 컨텐츠에서 귀하가 갖는 모든 권리 및 소유권을 유지합니다.
                            <br><br>개인 Adobe ID로 등록하려면 만13세 이상이어야 합니다.초등 및 중등 교육 명명 사용자 상품에 참여하는 학교는 만13세 미만 아동에게 엔터프라이즈 수준의 Adobe ID를 발생할 수 있지만 이는 명시적인 부모 동의를 받은 후에 이루어져야 합니다.
                        </p>

                        <div class="custom-control custom-checkbox" style="text-align:right;">
                            <input type="checkbox" class="custom-control-input" id="agree">
                            <label class="custom-control-label" for="agree">위 약관에 동의합니다.</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-7">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title">기이수 성적 업로드</h2><br>
                        <form>
                            <div class="form-group">
                                <label for="selectUniv"><i class="ni ni-check-bold text-primary"></i> 대학</label>
                                <select class="form-control form-control-sm" id="selectUniv">
                                    <option value='0'>--- 대학 선택 ---</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="selectTrack"><i class="ni ni-check-bold text-primary"></i> 트랙</label>
                                <select class="form-control form-control-sm" id="selectTrack">
                                    <option value='0'>--- 트랙 선택 ---</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="selectUniv"><i class="ni ni-check-bold text-primary"></i> 학위</label>&nbsp;
                                <div id="selectDegree">

                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uploadFile"><i class="ni ni-check-bold text-primary"></i> 기이수 성적 엑셀 파일</label>
                                <div class="card bg-gradient-lighter shadow" id="uploadFile">
                                    <div class="card-body text-center pb-1 pt-3">
                                        <div class="filebox">
                                            <label for="file" id="filelabel" class="btn btn-primary btn-lg fileBtn">Choose files to Upload</label>
                                            <input type="file"  name="file" id="file" class="upload-hidden">
                                            <br>
                                            <h5 class="text-muted ls-1 mb-1" id="upload-name">only excel file upload</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer" style="text-align:right;">
                        <button type="button" class="btn btn-outline-danger">도움말</button>
                        <button type="button" class="btn btn-outline-success" id="result">진척도 조회</button>
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
        getUnivData();

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
            var str="<option value='0'>--- 대학 선택 ---</option>";

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
            $("#selectUniv").html(str);
        };

        $("#selectUniv").on('change', function() {
            var id = $('#selectUniv').val();

            $.ajax({
                url: '/api/v1/select/track/'+id,
                type: "GET",
                data: JSON,

                success:function(data){
                    addSelectTrack(data);
                },
            });
        });

        $("#selectTrack").on('change', function() {
            var id = $('#selectTrack').val();

            $.ajax({
                url: '/api/v1/select/degree/'+id,
                type: "GET",
                data: JSON,

                success:function(data){
                    addSelectDegree(data);
                },
            });
        });

        function addSelectTrack(data){
            var str = "<option value='0'>--- 트랙 선택 ---</option>";

            $.each(data,function(index){
                $.each(data[index],function(key,value){
                    if(key=="id"){
                        str+="<option value="+ value +">"
                    }
                    else if(key=="title"){
                        str+= value + "</option>";
                    }
                });
            });
            $("#selectTrack").html(str);
        }

        function addSelectDegree(data){
            var result="";
            var str = '';
            var id = "";
            var i=0;

            $.each(data,function(index){
                i++;
                str += '<div class="custom-control custom-radio custom-control-inline">';
                $.each(data[index],function(key,value){

                    if(key=="id"){
                        if (i==1){
                            id = value;
                            str += '<input type="radio" value="'+id+'" id="degree'+id+'" name="degreeRadio" class="custom-control-input" checked>';
                        }
                        else{
                            id = value;
                            str += '<input type="radio" value="'+id+'" id="degree'+id+'" name="degreeRadio" class="custom-control-input">';
                        }
                    }
                    else if(key=="title"){
                        str+= '<label class="custom-control-label" for="degree' + id + '">'+ value +'</label></div>';
                    }
                });

                result += str;
                str='';
                id='';
            });
            $("#selectDegree").html(result);
        }
    });
</script>

<script>
    $(document).ready(function(){
        var submit = 0;

        $('#result').on('click', function (event) {
            var univId = $('#selectUniv').val();
            var trackId = $('#selectTrack').val();
            var degreeId = $('input[name="degreeRadio"]:checked').val();

            if ($("input:checkbox[id='agree']").is(":checked") == false){
                alert("약관을 동의하세요");
                return;
            }

            if ($('#selectUniv').val()==0){
                alert("대학을 선택하세요");
                return;
            }

            if ($('#selectTrack').val()==0){
                alert("트랙을 선택하세요");
                return;
            }

            if (submit==0){
                alert("기이수성적 파일을 기입해주세요");
                return;
            }

            else {
                self.location = "trackJudge"
                    + '?univId=' + univId
                    + '&trackId=' + trackId
                    + '&degreeId=' + degreeId;
            }
        });

        $('#file').change(function () {
            var formData = new FormData();
            var file = $(this).prop('files')[0];

            if(window.FileReader){
                var filename = $(this)[0].files[0].name;
            }
            else{
                var filename = $(this).val().split('/').pop().split('\\').pop();
            }

            formData.append("file", file);
            $.ajax({
                url: '/trackJudge',
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    if (checkExcelType(file.name)) {
                        $('#upload-name').html(filename);
                        $('#filelabel').html('Success!!');
                        $('#filelabel').removeClass('btn-danger');
                        $('#filelabel').addClass('btn-success');
                        submit=1;

                    } else {
                        $('#upload-name').html(filename);
                        $('#filelabel').html('File format is invalid');
                        $('#filelabel').addClass('btn-danger');
                        submit=0;
                    }
                }
            })
        });

        function checkExcelType(fileName) {
            var pattern = /xls|xlsx/i;
            return fileName.match(pattern);
        }
    });
</script>

<!-- nav -->
<script>
    $(document).ready(function(){
        var navBg = $('#navbar-main');

        navBg.addClass('bg-gradient-primary-1');

    });
</script>

<!-- sidebar -->
<script>
    sidebar();

    function sidebar(){
        $('.side').removeClass('active');
        $('#5').addClass('active');
    }
</script>

<!-- toastr js 라이브러리 -->
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>