<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Left side column. contains the logo and sidebar --%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <sec:authorize access="isAuthenticated()">
                    <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <img src="dist/img/unknown-160x160.jpg"class="img-circle" alt="User Image">
                </sec:authorize>

            </div>
            <div class="pull-left info">
                <p>
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.name"/>
                        &nbsp<a href="/modifyView"><u><small>내정보</small></u></a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        Guest
                    </sec:authorize>
                </p>
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasAuthority('STUDENT')">
                        <a>17학번 | 스마트기기공학과</a>
                    </sec:authorize>
                    <sec:authorize access="hasAuthority('PRO')">
                        <a>소프트웨어융합대학 소속</a>
                    </sec:authorize>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a>로그인을 해주세요</a>
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
            <li><a href="${path}/noticeList"><i class="fa fas fa-bullhorn"></i><span>공지사항</span></a></li>
            <li>

            <li class="header">Sejong Track</li>
            <li><a href="${path}/trackAll"><i class="fa  fas fa-sitemap"></i><span>전체 트랙 보기</span></a></li>
            <li><a href="${path}/uploadForm"><i class="fa fas fa-search"></i><span>트랙 현황 조회</span></a></li>
            <li>

            <li class="header">관리자</li>
            <li><a href="${path}/trackrule"><i class="fa fas fa-cogs"></i><span>트랙 규칙 관리</span></a></li>
        </ul>
        <%-- /.sidebar-menu --%>
    </section>
</aside>