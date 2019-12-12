<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head-color.jsp" %>
    <%-- Main Header --%>
    <%@ include file="include/main-header.jsp" %>

    <%-- Left side column. contains the logo and sidebar --%>
    <%@ include file="include/main-sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                트랙 현황 조회

                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Sejong Track</a></li>
                <li class="active">트랙 파일 첨부</li>
                <li class="active">트랙 현황 조회</li>
            </ol>
        </section>

        <!-- 선택한 트랙 -->
        <section class="content">
           <div class="row">
                <div class="col-md-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title"><c:out value="${resultTrack.trackTitle}"/> 트랙 이수 현황</h3>
                            <small>(<c:out value="${resultTrack.degreeTitle}"/>)</small>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered"> <!--선택한 트랙 정보-->
                                <thead>
                                <tr>
                                    <th>소속 대학</th>
                                    <th>트랙 이름</th>
                                    
                                    <c:if test="${resultTrack.ruleCredits[0] != 0}">
                                        <th>기초 교과</th>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[1] != 0}">
                                        <th>응용 교과</th>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[2] != 0}">
                                        <th>심화 교과</th>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[3] != 0}">
                                        <th>산학 연계</th>
                                    </c:if>
                                </tr>
                                </thead>

                                <tr>
                                    <td id="univNo"><c:out value="${resultTrack.univTitle}"/></td>
                                    <td><c:out value="${resultTrack.trackTitle}"/></td>
                                
                                    <c:if test="${resultTrack.ruleCredits[0] != 0}">
                                        <td><c:out value="${resultTrack.studentCredits[0]}"/> / <c:out value="${resultTrack.ruleCredits[0]}"/> <small>(학점)</small></td>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[1] != 0}">
                                        <td><c:out value="${resultTrack.studentCredits[1]}"/> / <c:out value="${resultTrack.ruleCredits[1]}"/> <small>(학점)</small></td>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[2] != 0}">
                                        <td><c:out value="${resultTrack.studentCredits[2]}"/> / <c:out value="${resultTrack.ruleCredits[2]}"/> <small>(학점)</small></td>
                                    </c:if>
                                    <c:if test="${resultTrack.ruleCredits[3] != 0}">
                                        <td><c:out value="${resultTrack.studentCredits[3]}"/> / <c:out value="${resultTrack.ruleCredits[3]}"/> <small>(학점)</small></td>
                                    </c:if>
                                </tr>
                            </table>

                            <table class="table table-bordered"> <!--진척도 계산-->
                                <thead>
                                    <tr>
                                        <th style="width:80%;">진척도</th>
                                        <th style="width:20%;">이수율</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>
                                            <div class='progress progress-xs'>
                                                <div class='progress-bar progress-bar-warning' style='width:<c:out value="${resultTrack.percent}"/>%'></div>
                                            </div>
                                        </td>

                                        <td>
                                            <span class='badge bg-orange'><c:out value="${resultTrack.percent}"/>%</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--box-->
                    <div class="row" id="div-parent">
                        <c:if test="${not empty resultAllMap.passBasicList || not empty resultAllMap.nonPassBasicList}">
                            <div class="col-md-6" id="div-1">
                                <div class="box">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">기초교과</h4>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                                <i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-bordered" style="width:100%;">
                                            <tr>
                                                <th><li style="list-style:square;">기초 이수</li></th>
                                            </tr>
                                            <!--기초교과 이수-->
                                            <c:forEach items="${resultAllMap.passBasicList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <th><li style="list-style:square;">기초 미이수</li></th>
                                            </tr>

                                            <!--기초교과 미이수-->
                                            <c:forEach items="${resultAllMap.nonPassBasicList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                                <!-- /.box -->
                            </div>                            
                        </c:if>
                        <c:if test="${not empty resultAllMap.passAppliedList || not empty resultAllMap.nonPassAppliedList}">
                            <div class="col-md-6" id="div-2">
                                <div class="box">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">응용교과</h4>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                                <i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-bordered" style="width:100%">
                                            <tr>
                                                <th><li style="list-style:square;">응용 이수</li></th>
                                           </tr>
                                            <c:forEach items="${resultAllMap.passAppliedList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <th><li style="list-style:square;">응용 미이수</li></th>
                                            </tr>

                                            <c:forEach items="${resultAllMap.nonPassAppliedList}" var="subject">
                                            <tr>
                                                <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                    <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                            </tr>
                                            </c:forEach>

                                        </table>
                                    </div>
                                </div>
                                <!-- /.box -->
                            </div>
                        </c:if>
                        <c:if test="${not empty resultAllMap.passExpertList || not empty resultAllMap.nonPassExpertList}">
                            <div class="col-md-6" id="div-3">
                                <div class="box">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">심화교과</h4>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                                <i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-bordered" style="width:100%">
                                            <tr>
                                                <th><li style="list-style:square;">심화 이수</li></th>
                                            </tr>
                                            <c:forEach items="${resultAllMap.passExpertList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <th><li style="list-style:square;">심화 미이수</li></th>
                                            </tr>

                                            <c:forEach items="${resultAllMap.nonPassExpertList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div>
                                </div>
                                <!-- /.box -->
                            </div>
                        </c:if>
                        <c:if test="${not empty resultAllMap.passExpertList || not empty resultAllMap.nonPassExpertList}">                        
                            <div class="col-md-6" id="div-4">
                                <div class="box">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">산학연계교과</h4>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                                <i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-bordered" style="width:100%">
                                            <tr>
                                                <th><li style="list-style:square;">산학 이수</li></th>
                                            </tr>
                                            <c:forEach items="${resultAllMap.passIndustryList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <th><li style="list-style:square;">산학 미이수</li></th>
                                            </tr>

                                            <c:forEach items="${resultAllMap.nonPassIndustryList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.subjectTitle}"/> [학수번호] <c:out value="${subject.subjectNo}"/> [학점] <c:out value="${subject.subjectCredit}"/>'>
                                                        <c:out value="${subject.subjectTitle}"/>(<c:out value="${subject.subjectCredit}"/>)</td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div>
                                </div>

                            <!-- /.box -->
                            </div>
                        </c:if>
                    </div>
                    <!-- /.box -->
                </div><!-- 선택한 트랙 -->

                <!-- 전체 트랙 -->
                <div class="col-md-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">전체 트랙 이수 현황</h3><br>
                            <small>※ 트랙을 클릭하시면, 해당 트랙의 이수 현황을 계산합니다.</small>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th style="width:5%;">#</th>
                                        <th style="width:35%;">트랙이름</th>
                                        <th style="width:50%;">진척도</th>
                                        <th style="width:10%;">이수율</th>
                                    </tr>
                                </thead>

                                <tbody id="resultTrack">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 전체 트랙 -->
        </div>
    </section>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>

<script language="JavaScript">

    $(document).ready(function () {

        getAllResult();
        
        function getAllResult() {

            $.getJSON("/trackJudge/all/" + 2, function (data) {
                var str = "";

                $(data).each(
                    function () {
                        str += "<tr>"
                                + "<td style='text-align:center'>" + this.trackId + "</td>"
                                + "<td><a href='trackJudge?univId=" + this.univId + "&trackId=" + this.trackId + "&degreeId=" + this.degreeId +"'>" + this.trackTitle + "</a></td>"
                                + "<td><div class='progress progress-xs'><div class='progress-bar progress-bar-warning' style='width:" + this.percent+ "%'></div></div></td>"
                                + "<td><span class='badge bg-orange'>" + this.percent + "%</span></td>"
                            + "</tr>"
                    });

                $("#resultTrack").html(str);
            });
        }
    });

</script>
</html>