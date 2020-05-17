<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="include/sidebar.jsp" %>
<div class="main-content">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header bg-gradient-primary pb-3 pt-4 pt-md-8 pl-3">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <h1 class="display-3 text-white" id="resultTitle"></h1>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt-4">
        <div class="row">
            <div class="col-xl-6 pt-1">
                <div class="ct-content">
                    <div class="ct-page-title">
                        <h1 class="ct-title" style="font-size:15px;">트랙 이수 현황</h1>
                    </div>
                </div>
                <div class="card shadow">
                    <div class="table-responsive">
                        <table class="table align-items-center table-flush">
                            <tbody>
                            <tr>
                                <th class="text-default" id="selectTrackTitle">
                                    <!-- 트랙 명 -->
                                </th>
                                <td id="totalCredit">
                                    <!-- 학점 -->
                                </td>
                                <td  width="45%">
                                    <span class="progress" style="width:100%;" id="totalPercent">
                                        <!-- 프로그래스바 -->
                                    </span>
                                </td>
                                <td>
                                    <span class="progress-percentage">
                                        <span id="percent">
                                            <!-- 진척도 -->
                                        </span>
                                    </span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="row pb-2" id="resultCard">
                    <!-- 결과 카드 -->
                </div>
            </div>
            <div class="col-xl-6 pt-1">
                <div class="ct-content">
                    <div class="ct-page-title">
                        <h1 class="ct-title" style="font-size:15px;">전체 트랙 진척도</h1>
                    </div>
                </div>
                <div class="card shadow">
                    <div class="table-responsive">
                        <table class="table align-items-center table-flush">
                            <thead class="thead-light">
                            <tr id="thead">
                                <th>트랙 명</th>
                                <th>진척도</th>
                                <th width="50%"></th>
                            </tr>
                            </thead>

                            <tbody id="trackAlltable">
                            <tr>
                                <th>멀티미디어</th>
                                <td>
                                    <span class="progress-percentage">
                                        <span>70%</span>
                                    </span>
                                </td>
                                <td>
                                    <span class="progress" style="width:100%;">
                                        <div class="progress-bar"role="progressbar" style="width: 70%;background-color:red;"></div>
                                    </span>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-5">

        </div>
        <!-- footer -->
        <%@ include file="include/footer.jsp" %>
    </div>
</div>
<%@ include file="include/setting-f.jsp" %>
<script language="JavaScript">
    $(document).ready(function () {
        const params = getUrlParams();

        trackJudgeOne();
        trackJudgeAll();

        function trackJudgeOne(){
            $.ajax({
                url: "${path}/api/v1/trackJudge/one",
                type: "POST",
                data: {
                    "univId" : params.univId,
                    "trackId" : params.trackId,
                    "degreeId" : params.degreeId
                },
                dataType : "json",

                success : function(data){
                    console.log(data);
                    selectTrack(data);
                },
            });
        }

        function trackJudgeAll(){
            $.ajax({
                url: "${path}/api/v1/trackJudge/all",
                type: "POST",
                data: {
                    "univId" : params.univId,
                    "degreeId" : params.degreeId
                },
                dataType : "json",

                success : function(data){
                    trackAll(data);
                },
            });
        }

        function getUrlParams() {
            var params = {};
            window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) {
                params[key] = value;
            });
            return params;
        }
        function trackAll(data){
            var track;
            var percent;
            var percentColor;
            var str="";
            var block="";

            $.each(data,function(index){
                $.each(data[index],function(key,value){
                    if(key=="percent"){
                        percent=Math.floor(value);
                    }
                    else if(key=="percentColor"){
                        percentColor=value;
                    }
                    else if(key=="track"){
                        $.each(value,function(key,value){
                            if(key=="title"){
                                track=value;
                            }
                        });
                    }
                });

                block+='<tr><th>'+track+'</th><td><span class="progress-percentage"><span>'+percent+'%</span>';
                block+='</span></td><td><span class="progress" style="width:100%;">';
                block+='<div class="progress-bar"role="progressbar" style="width: '+percent+'%; background-color: ' +percentColor+';"></div></span></td></tr>';

                str+=block;
                block="";
            });

            $("#trackAlltable").html(str);
        }

        function selectTrack(data){
            var univ;
            var track;
            var percent;
            var totalCourseCredit;
            var totalRuleCredit;
            var percentColor;

            var progress;
            var jsonData;

            $.each(data,function(key,value){
                if(key=="univ"){ //univ name
                    $.each(value,function(key,value){
                        if(key=="title"){
                            univ=value;
                        }
                    })
                }

                else if(key=="track"){ //track name
                    $.each(value,function(key,value){
                        if(key=="title"){
                            track=value;
                        }
                    })
                }

                else if(key=="percent"){
                    percent=Math.floor(value);
                }

                else if(key=="totalCourseCredit"){
                    totalCourseCredit=value;
                }

                else if(key=="totalRuleCredit"){
                    totalRuleCredit=value;
                }

                else if(key=="percentColor"){
                    percentColor=value;
                }

                else if(key=="trackClassify"){
                    jsonData=value;
                }
            });

            progress='<div class="progress-bar" role="progressbar"'
                    +'style="width:'+percent+'%;background-color:'+percentColor+'"></div>';

            $("#resultTitle").html('${userModel.name}님의<br>'+univ+'<br>트랙 현황 조회');
            $("#selectTrackTitle").html(track);
            $("#totalCredit").html(totalCourseCredit + ' / ' + totalRuleCredit + ' <small>학점</small>');
            $("#totalPercent").html(progress);
            $("#percent").html(percent+"%");
            printResult(jsonData);
        }

        function printResult(data) {
            var str = "";

            var sumCredit;
            var ruleCredit;

            $.each(data,function(key,value){
                // 조건
                str+='<div class="col-sm-6 pt-2"><div class="card shadow"><div class="card-header border-0"><div class="row align-item-center">'
                    +'<div class="col"><p class="mb-0"><i class="ni ni-book-bookmark text-primary"></i> '
                    + key + '</p></div>';
                var course ="";

                $.each(value,function(key,value){
                    if(key=="PASS"){
                        $.each(value,function(key,value){
                            if(key=="courses"){
                                course += checkCourses(value,1);
                            }
                            else if(key=='sumCredit'){
                                sumCredit=value;
                            }
                            else if(key=='ruleCredit'){
                                ruleCredit=value;
                            }
                        })
                    }
                    else if(key=="NON_PASS"){
                        $.each(value,function(key,value){
                            if(key=="courses"){
                                course += checkCourses(value,0);
                            }
                        })
                    }
                });

                str+='<div class="col text-right"><p>'+sumCredit+' / '+ruleCredit+'</p></div>';
                str+='</div></div><div class="table-responsive"><table class="table align-items-center table-flush"><tbody>';
                str+=course;
                str+='</tbody></table></div></div></div>';
            });
            $("#resultCard").html(str);
        }

        function checkCourses(data,i){
            var color="text-default";
            var courseNo;
            var title;
            var str = "";

            if (i==1){
                color="text-primary";
            }

            $.each(data,function(index){
                $.each(data[index],function(key,value){
                    if (key=="courseNo"){
                        courseNo=value;
                    }
                    else if(key=="title"){
                        title=value;
                    }
                });

                str += '<tr><th class="'+ color +'"width="70%">'+ title +'</th>'
                    +  '<td><span class="badge badge-primary">'+ courseNo + '</span></td></tr>';
            });

            return str;
        }
    });
</script>

<script>
    sidebar();

    function sidebar(){
        $('.side').removeClass('active');
        $('#5').addClass('active');
    }
</script>