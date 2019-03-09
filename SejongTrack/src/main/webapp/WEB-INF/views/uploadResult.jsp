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
                트랙 현황 조회

                <small>Sejong univ Track</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/"><i class="fa fa-dashboard"></i>Sejong Track</a></li>
                <li class="active">트랙 파일 첨부</li>
                <li class="active">트랙 현황 조회</li>
            </ol>
        </section>

        <!-- 전체트랙 조회 구현되면 없에도 될 듯?
        <section>
            <br>
            <div class="col-md-12">
                <div class="box box-solid">
                    <div class="box-header with-border">
                        <h3 class="box-title"><i class="fa fa-warning"></i>트랙 선택</h3>
                    </div>
                    <div class="box-body">
                        <input type="button">트랙 선택</input>
                    </div>
                </div>
            </div>
        </section>
        -->

        <!-- 선택한 트랙 -->
        <section class="content">
           <div class="row">
                <div class="col-md-6">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title"><c:out value="${rule.track}"/> 이수 현황</h3>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered"> <!--선택한 트랙 정보-->
                                <thead>
                                <tr>
                                    <th>소속 대학</th>
                                    <th>트랙 이름</th>
                                    <th>기초 교과</th>
                                    <th>응용 교과</th>
                                    <th>산학 연계</th>
                                </tr>
                                </thead>

                                <tr>
                                    <td><c:out value="${rule.univ}"/></td>
                                    <td><c:out value="${rule.track}"/></td>
                                    <td><c:out value="${pbcredit}"/> / <c:out value="${rule.basic}"/> <small>(학점)</small></td>
                                    <td><c:out value="${pacredit}"/> / <c:out value="${rule.applied}"/> <small>(학점)</small></td>
                                    <td><c:out value="${picredit}"/> / <c:out value="${rule.industry}"/> <small>(학점)</small></td>
                                </tr>
                            </table>

                            <table class="table table-bordered"> <!--진척도 계산-->
                                <tr>
                                    <th style="width:80%;">진척도</th>
                                    <th style="width:20%;">이수율</th>
                                </tr>
                                <tr id="select-track-progress"></tr><!--progress-->
                            </table>

                            <!--select track progress js-->
                            <script>
                                var str='';
                                var percent;
                                var pa = <c:out value="${pacredit}"/>; //자신의 응용교과 이수 학점

                                //응용교과 추가 이수로 인한 계산 오류 방지
                                if ( pa  >= <c:out value="${rule.applied}"/> ){
                                    pa = <c:out value="${rule.applied}"/>;
                                }

                                percent = Math.round((( <c:out value="${pbcredit}"/> + pa ) / (<c:out value="${rule.basic}"/> + <c:out value="${rule.applied}"/>))*100);

                                if (percent >= 80){
                                    str = str + "<td><div><div class='progress progress-xs'><div class='progress-bar progress-bar-success' style='width:" + percent + "%;'></div></div></div></td>";
                                    str = str + "<td><span class='badge bg-green'>" + percent + "%</span></td></td>";
                                }

                                else if (percent >= 50){
                                    str = str + "<td><div><div class='progress progress-xs'><div class='progress-bar progress-bar-warning' style='width:" + percent + "%;'></div></div></div></td>";
                                    str = str + "<td><span class='badge bg-orange'>" + percent + "%</span></td></td>";
                                }

                                else {
                                    str = str + "<td><div><div class='progress progress-xs'><div class='progress-bar progress-bar-danger' style='width:" + percent + "%;'></div></div></div></td>";
                                    str = str + "<td><span class='badge bg-red'>" + percent + "%</span></td></td>";
                                }

                                document.getElementById("select-track-progress").innerHTML=str;
                            </script>

                            <!--구분선-->
                            <hr align="center" size="10" width="100%" id="hrColor" noshade style="background-color:#d2d6de;border-color:#d2d6de;">

                            <small>※ 과목에 마우스를 올리시면, 해당 과목의 상세정보를 알 수 있습니다.</small><br>
                            <table class="table table-bordered" style="margin-top:0;">
                                <tr>
                                   <td colspan="2"><div class="box-header" style="margin:0;padding:0;"><h3 class="box-title" style="margin:0;padding:0;">자신의 트랙 이수 현황</h3></div></td>
                                </tr>

                                <tr>
                                    <td><!--자신의 기초 과목 현황 -->
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th><li style="list-style:square;">기초 이수 과목</li></th>
                                            </tr>
                                            </thead>

                                            <c:forEach items="${resultAllMap.passAllList}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.courseTitle}"/> [학수번호] <c:out value="${subject.courseNum}"/> [학점] <c:out value="${subject.credit}"/>'>
                                                        <c:out value="${subject.courseTitle}"/></td>
                                                </tr>
                                            </c:forEach>

                                            <thead>
                                            <tr>
                                                <th><li style="list-style:square;">기초 미이수 과목</li></th>
                                            </tr>
                                            </thead>


                                            <c:forEach items="${npblist}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.courseTitle}"/> [학수번호] <c:out value="${subject.courseNum}"/> [학점] <c:out value="${subject.credit}"/>'>
                                                        <c:out value="${subject.courseTitle}"/></td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </td>

                                    <td> <!--자신의 응용 과목 현황-->
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th><li style="list-style:square;">응용 이수 과목</li></th>
                                            </tr>
                                            </thead>

                                            <c:forEach items="${palist}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.courseTitle}"/> [학수번호] <c:out value="${subject.courseNum}"/> [학점] <c:out value="${subject.credit}"/>'>
                                                        <c:out value="${subject.courseTitle}"/></td>
                                                </tr>
                                            </c:forEach>



                                            <thead>
                                            <tr>
                                                <th><li style="list-style:square;">응용 미이수 과목</li></th>
                                            </tr>
                                            </thead>

                                            <c:forEach items="${npalist}" var="subject">
                                                <tr>
                                                    <td class="tbl_hover" title='[교과목명] <c:out value="${subject.courseTitle}"/> [학수번호] <c:out value="${subject.courseNum}"/> [학점] <c:out value="${subject.credit}"/>'>
                                                        <c:out value="${subject.courseTitle}"/></td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
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
                                <tr>
                                    <th style="width:5%;">#</th>
                                    <th style="width:35%;">트랙 명</th>
                                    <th style="width:40%;">진척도</th>
                                    <th style="width:20%;">이수율</th>
                                </tr>

                                <!--example data-->
                                <tr>
                                    <td>1</td>
                                    <td>hcl</td>
                                    <td><div><div class="progress progress-xs"><div class="progress-bar progress-bar-warning" style="width:50%;"></div></div></div></td>
                                    <td><span class="badge bg-orange">50%</span></td></td>
                                </tr>
                            </table>
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
</html>