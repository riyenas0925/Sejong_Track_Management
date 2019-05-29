<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%-- Main Header --%>
<header class="main-header">
    <%-- Logo --%>
    <a href="/" class="logo">
        <%-- mini logo for sidebar mini 50x50 pixels --%>
        <span class="logo-mini"><b>ST</b>M</span>
        <%-- logo for regular state and mobile devices --%>
        <span class="logo-lg"><b>Sejong</b>Track</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu" style="margin:6px;">
            <sec:authorize access="isAnonymous()">
                <a href="${CONTEXT }/customLogin" class="btn btn-default btn-flat">로그인</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="${CONTEXT }/customLogout" class="btn btn-default btn-flat">로그아웃</a>
            </sec:authorize>
        </div>
    </nav>
</header>