<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Left side column. contains the logo and sidebar --%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
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
            <li><a href="${path}/trackrule"><i class="fa fas fa-cogs"></i><span>트랙 규칙 관리</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa far fa-bar-chart"></i> 트랙 통계 관리
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