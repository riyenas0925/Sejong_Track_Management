<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!-- Navbar -->
<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
    <div class="container-fluid">
        <!-- Brand -->
        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="./index.html">Sejong Track Management</a>
        <!-- Form -->
        <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
            <div class="form-group mb-0">
            </div>
        </form>
        <!-- User -->
        <ul class="navbar-nav align-items-center d-none d-md-flex">
            <li class="nav-item">
                <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <div class="media align-items-center">
                                <span class="avatar avatar-sm rounded-circle">
                                    <sec:authorize access="isAuthenticated()">
                                        <img alt="Image placeholder" src="../resources/img/theme/user.png">
                                    </sec:authorize>
                                    <sec:authorize access="isAnonymous()">
                                        <img alt="Image placeholder" src="../resources/img/theme/logout.png">
                                    </sec:authorize>
                                </span>
                        <div class="media-body ml-2 d-none d-lg-block">
                            <sec:authorize access="isAuthenticated()">
                                <span class="mb-0 text-sm  font-weight-bold" OnClick="location.href='${path}/memberLogout'">Logout</span>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <span class="mb-0 text-sm  font-weight-bold" OnClick="location.href='${path}/loginView'">Login</span>
                            </sec:authorize>
                        </div>
                    </div>
                </a>
            </li>
        </ul>
    </div>
</nav>
<!-- End Navbar -->