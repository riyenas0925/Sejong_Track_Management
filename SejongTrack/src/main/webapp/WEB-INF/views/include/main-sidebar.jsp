<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%-- Left side column. contains the logo and sidebar --%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <sec:authorize access="isAnonymous()">
                    <img src="dist/img/login_icon.png" class="img-circle" alt="User Image">
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_MEMBER')">
                    <img src="dist/img/student_icon.png" class="img-circle" alt="User Image">
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_NOMEMBER')">
                    <img src="dist/img/student_icon.png" class="img-circle" alt="User Image">
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_MANAGE')">
                    <img src="dist/img/manager_icon.png" class="img-circle" alt="User Image">
                </sec:authorize>
            </div>
            <div class="pull-left info">
                <sec:authorize access="isAnonymous()">
                    <p>미로그인시 <br> 서비스 이용이 <br> 불가능합니다.</p>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <p>??? 님</p>
                </sec:authorize>


                <sec:authorize access="hasRole('ROLE_MANAGE')">
                    <a href="#"><i class="fa fa-circle text-success"></i> 관리자</a>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_MEMBER')">
                    <a href="#"><i class="fa fa-circle text-success"></i> 학생</a>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_NOMEMBER')">
                    <a href="#"><i class="fa fa-circle text-success"></i> 미가입</a>
                </sec:authorize>
            </div>
        </div>

        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">공지</li>
            <li><a href="${path}/"><i class="fa  fas fa-home"></i><span>Home</span></a></li>
            <li><a href="${path}"><i class="fa fas fa-bullhorn"></i><span>공지사항</span></a></li>
            <li>

            <li class="header">Sejong Track</li>
            <li><a href="${path}/trackAll"><i class="fa  fas fa-sitemap"></i><span>전체 트랙 보기</span></a></li>
            <li><a href="${path}/uploadForm"><i class="fa fas fa-search"></i><span>트랙 현황 조회</span></a></li>
            <li>

            <li class="header">관리자</li>
            <li><a href="${path}/trackrule"><i class="fa fas fa-cogs"></i><span>트랙 규칙 추가 및 수정</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa far fa-bar-chart"></i> 트랙 통계
                    <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${path}/visitor"><i class="fa fa-circle-o"></i> 접속자 통계</a></li>
                    <li><a href="${path}/student"><i class="fa fa-circle-o"></i> 학생 통계</a></li>
                </ul>
            </li>
        </ul>
        <%-- /.sidebar-menu --%>
    </section>
</aside>