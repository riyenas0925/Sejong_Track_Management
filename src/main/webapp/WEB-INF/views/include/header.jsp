<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!-- Navbar -->
<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
    <div class="container-fluid">
        <!-- Brand -->
        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="${path}/">Sejong Univ. Track Management</a>
        <!-- Form -->
        <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
            <div class="form-group mb-0">
            </div>
        </form>
        <!-- User -->
        <ul class="navbar-nav align-items-center d-none d-md-flex">
            <li class="nav-item dropdown">
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
                                <span class="mb-0 text-sm  font-weight-bold">${userModel.name}</span>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <span class="mb-0 text-sm  font-weight-bold">Login</span>
                            </sec:authorize>
                        </div>
                    </div>
                </a>

                <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
                    <div class=" dropdown-header noti-title">
                        <sec:authorize access="isAnonymous()">
                            <h6 class="text-overflow m-0">안녕하세요.<br>로그인하세요.</h6>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <h6 class="text-overflow m-0">안녕하세요.<br>${userModel.name}님!</h6>
                        </sec:authorize>
                    </div>

                    <sec:authorize access="isAuthenticated()">
                        <a href="${path}/modifyView" class="dropdown-item">
                            <i class="ni ni-single-02"></i>
                            <span>내 정보</span>
                        </a>
                    </sec:authorize>

                    <div class="dropdown-divider"></div>

                    <div class="dropdown-item">
                        <i class="ni ni-user-run"></i>
                        <sec:authorize access="isAuthenticated()">
                            <span OnClick="location.href='${path}/api/v1/member/logout'">Logout</span>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <span OnClick="location.href='${path}/loginView'">Login</span>
                        </sec:authorize>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>
<!-- End Navbar -->