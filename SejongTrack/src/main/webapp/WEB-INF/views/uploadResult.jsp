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
                                    <td id="univNo"><c:out value="${rule.univ}"/></td>
                                    <td><c:out value="${rule.track}"/></td>
                                    <td><c:out value="${resultAllMap.passCredit[0].credit}"/> / <c:out value="${rule.basic}"/> <small>(학점)</small></td>
                                    <td><c:out value="${resultAllMap.passCredit[1].credit}"/> / <c:out value="${rule.applied}"/> <small>(학점)</small></td>
                                    <td><c:out value="${resultAllMap.passCredit[2].credit}"/> / <c:out value="${rule.industry}"/> <small>(학점)</small></td>
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

                                            <c:forEach items="${resultAllMap.passBasicList}" var="subject">
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


                                            <c:forEach items="${resultAllMap.nonPassBasicList}" var="subject">
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

                                            <c:forEach items="${resultAllMap.passAppliedList}" var="subject">
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

                                            <c:forEach items="${resultAllMap.nonPassAppliedList}" var="subject">
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
                                <thead>
                                    <tr>
                                        <th style="width:5%;">#</th>
                                        <th style="width:35%;">트랙 명</th>
                                        <th style="width:40%;">진척도</th>
                                        <th style="width:20%;">이수율</th>
                                    </tr>
                                </thead>

                                <!--example data-->
                                <tbody id="resultTrack">
                                    <c:forEach items="${resultTrack}" var="result">
                                        <tr>
                                            <td style='text-align:center'><c:out value="${result.trackNo}"/></td>
                                            <td><c:out value="${result.trackTitle}"/></td>
                                            <td><div class='progress progress-xs'><div class='progress-bar progress-bar-warning' style='width:<c:out value="${result.percent}"/>%'></div></div></td>
                                            <td><span class='badge bg-orange'><c:out value="${result.percent}"/>%</span></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
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

<script language="JavaScript">

</script>
</html>