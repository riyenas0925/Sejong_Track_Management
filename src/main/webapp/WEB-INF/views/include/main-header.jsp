<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

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

        <!-- 로그인 기능 넣을 자리-->
        <sec:authorize access="isAnonymous()">
            <a href="${path}/joinView">회원가입</a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <a href="${path}/loginView">로그인</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="${path}/memberLogout">로그아웃</a>
        </sec:authorize>
        <sec:authorize access="hasAuthority('ADMIN')">
            &nbsp<b>안녕하세요 관리자님</b>
        </sec:authorize>

    </nav>
</header>
